package com.chaomeis.sparrowbeauty.api.service.order;

import com.chaomeis.sparrowbeauty.api.paramVo.CartOrderParamVo;
import com.chaomeis.sparrowbeauty.api.responseVo.CalculateReturnVo;
import com.chaomeis.sparrowbeauty.api.service.calculate.CalculateService;
import com.chaomeis.sparrowbeauty.api.service.pay.ApiPayService;
import com.chaomeis.sparrowbeauty.config.WechatInfoProperties;
import com.chaomeis.sparrowbeauty.entity.TbApiUser;
import com.chaomeis.sparrowbeauty.entity.TbOrder;
import com.chaomeis.sparrowbeauty.entity.TbOrderDetail;
import com.chaomeis.sparrowbeauty.entity.TbUserPayRecord;
import com.chaomeis.sparrowbeauty.mapper.TbOrderDetailMapper;
import com.chaomeis.sparrowbeauty.mapper.TbOrderMapper;
import com.chaomeis.sparrowbeauty.mapper.TbUserPayRecordMapper;
import com.chaomeis.sparrowbeauty.utils.PriceCalculateUtil;
import com.chaomeis.sparrowbeauty.utils.SerialGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ApiOrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiOrderService.class);

    @Resource
    private ApiPayService apiPayService;

    @Resource
    private WechatInfoProperties wechatInfoProperties;

    @Resource
    private CalculateService calculateService;

    @Resource
    private TbUserPayRecordMapper tbUserPayRecordMapper;

    @Resource
    private TbOrderMapper tbOrderMapper;

    @Resource
    private TbOrderDetailMapper tbOrderDetailMapper;

    public Map<String, Object> createOrderByCart(CartOrderParamVo cartOrderParamVo, TbApiUser apiUser) throws Exception {
        TbOrder tbOrder = new TbOrder();
        //todo 结算价格
        CalculateReturnVo calculateReturnVo = calculateService.calculateCartOrderPrice(cartOrderParamVo);

        String orderId = SerialGenerator.getOrderSerial();
        tbOrder.setOrderId(orderId);
        //todo 保存订单信息

        //todo 保存订单明细信息

        //todo 锁定优惠券状态

        TbUserPayRecord tbUserPayRecord = buildPayRecord(tbOrder,apiUser);

        //微信支付统一下单
        Map<String, Object> payMap = apiPayService.createPayOrderToWechat(tbOrder);
        LOGGER.info("wechat pay create order return result : {}",payMap);
        tbUserPayRecord.setNonceStr(String.valueOf(payMap.get("nonce_str")));
        tbUserPayRecord.setPrepayId(String.valueOf(payMap.get("prepay_id")));
        String timeStamp = String.valueOf(System.currentTimeMillis() / 1000);
        payMap.put("timeStamp",timeStamp);
        payMap.put("signType",wechatInfoProperties.getSignType());
        String paySign = apiPayService.secondEncrypt(tbUserPayRecord,timeStamp);
        payMap.put("paySign",paySign);
        //todo 删除购物车记录
        //todo 保存用户支付记录信息
        tbUserPayRecordMapper.insert(tbUserPayRecord);
        payMap.remove("mch_id");
        return payMap;
    }

    private TbUserPayRecord buildPayRecord(TbOrder tbOrder,TbApiUser apiUser) {
        //生成付款记录
        TbUserPayRecord tbUserPayRecord = new TbUserPayRecord();
        tbUserPayRecord.setApiUserId(apiUser.getId());
        tbUserPayRecord.setOpenId(tbOrder.getOpenId());
        tbUserPayRecord.setOrderId(tbOrder.getOrderId());
        tbUserPayRecord.setOrderAmount(tbOrder.getOrderAmount());
        tbUserPayRecord.setPaymentAmount(tbOrder.getPaymentAmount());
        tbUserPayRecord.setPayStatus(0);
        tbUserPayRecord.setCreateTime(new Date());
        return tbUserPayRecord;
    }

    /**
     * 校验创建订单参数
     * @param cartOrderParamVo 订单参数对象
     * @return 返回订单参数校验结果
     */
    public boolean checkCartOrderParameter(CartOrderParamVo cartOrderParamVo) {
        //todo 订单参数必要性校验
        return true;
    }

    public TbOrder findOrderDetailById(String orderId) {
        return tbOrderMapper.selectByPrimaryKey(orderId);
    }

    public List<TbOrderDetail> findOrderDetailByOrderId(String orderId) {
        return tbOrderDetailMapper.findOrderDetailByOrderId(orderId);
    }

    public List<TbOrder> findOrderByOpenId(String openId) {
        return tbOrderMapper.findOrderByOpenId(openId);
    }

    public void cancelOrder(String openId, String orderId) {
        TbOrder tbOrder = tbOrderMapper.selectByPrimaryKey(orderId);
        if (tbOrder == null ){
            return;
        }
        if (tbOrder.getOrderStatus() != 0){
            return;
        }
        tbOrderMapper.cancelOrder(openId,orderId);
        if (tbOrder.getApiUserCouponsId() != 0){
            //todo 释放订单锁定的优惠券
        }
    }
}
