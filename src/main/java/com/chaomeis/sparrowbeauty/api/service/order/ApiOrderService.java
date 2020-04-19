package com.chaomeis.sparrowbeauty.api.service.order;

import com.chaomeis.sparrowbeauty.api.paramVo.CartOrderParamVo;
import com.chaomeis.sparrowbeauty.api.paramVo.GoodsParamVO;
import com.chaomeis.sparrowbeauty.api.responseVo.CalculateReturnVo;
import com.chaomeis.sparrowbeauty.api.service.calculate.CalculateService;
import com.chaomeis.sparrowbeauty.api.service.pay.ApiPayService;
import com.chaomeis.sparrowbeauty.api.service.user.ApiUserService;
import com.chaomeis.sparrowbeauty.common.PageReqVO;
import com.chaomeis.sparrowbeauty.common.PageRespDto;
import com.chaomeis.sparrowbeauty.common.SparrowBeautyConstant;
import com.chaomeis.sparrowbeauty.config.WechatInfoProperties;
import com.chaomeis.sparrowbeauty.entity.*;
import com.chaomeis.sparrowbeauty.mapper.*;
import com.chaomeis.sparrowbeauty.utils.PriceCalculateUtil;
import com.chaomeis.sparrowbeauty.utils.SerialGenerator;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ApiOrderService {
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

    @Resource
    private TbGoodsMapper tbGoodsMapper;

    @Resource
    private TbLogisticsMapper tbLogisticsMapper;

    @Resource
    private TbAddressMapper tbAddressMapper;

    @Resource
    private TbApiUserMapper tbApiUserMapper;

    @Resource
    private ApiUserService apiUserService;

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
        log.info("wechat pay create order return result : {}",payMap);
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

    public PageRespDto<TbOrder> findOrderPageList(PageReqVO<TbOrder> page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<TbOrder> orderPage = tbOrderMapper.selectList(page.getCondition());
        PageRespDto<TbOrder> pageList = new PageRespDto(orderPage);
        return pageList;
    }

    /**
     * 订单明细
     * @param tbOrder 点单参数
     * @return 订单信息
     */
    public TbOrder findOrderDetail(TbOrder tbOrder) {
        return tbOrderMapper.findOrderDetail(tbOrder);
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

    public void orderStatisticalByStatus(String openId) {
        //todo 根据openId 统计当前用户各个状态的订单数量 需要自己创建返回对象所需的字段
        return;
    }

    /**
     * 使用商品id直接创建订单参数校验
     * @param goodsParamVO 参数对象
     * @return 返回是否校验通过
     */
    public boolean checkGoodsOrderParameter(GoodsParamVO goodsParamVO) {
        //todo 订单参数必要性校验
        return true;
    }

    //根据商品id创建订单
    public Map<String, Object> createOrderByGoodsId(GoodsParamVO goodsParamVO) {
        Map<String, Object> resultMap = new HashMap<>();
        double orderGoodsPrice = 0;
        Date currentDate = new Date();
        try {
            //查询商品信息
            TbGoods tbGoods = tbGoodsMapper.selectByPrimaryKey(goodsParamVO.getGoodsId());
            if (tbGoods == null){
                resultMap.put("result","商品信息不存在");
                return resultMap;
            }
            //查询skuDetail信息
            List<Integer> skuDetailIdList = goodsParamVO.getSkuDetailIdList();
            if (!CollectionUtils.isEmpty(skuDetailIdList)){
                //todo 第一期未做商品sku相关的功能
            }
            //查询物流费用
            TbLogistics tbLogistics = tbLogisticsMapper.selectByPrimaryKey(goodsParamVO.getLogisticsId());
            if (tbLogistics == null){
                resultMap.put("result","物流信息有误");
                return resultMap;
            }
            TbAddress tbAddress = tbAddressMapper.selectByPrimaryKey(goodsParamVO.getAddressId());
            if (tbAddress == null){
                resultMap.put("result","收货地址为空");
                return resultMap;
            }

            TbApiUser apiUser = apiUserService.findApiUserByOpenId(goodsParamVO.getOpenId());
            if (apiUser == null){
                resultMap.put("result","未登陆，请先授权登陆");
                return resultMap;
            }
            if (goodsParamVO.getGoodsCount() != 1){
                orderGoodsPrice = PriceCalculateUtil.multiply(tbGoods.getGoodsPrice(),goodsParamVO.getGoodsCount());
            }
            TbOrder order = new TbOrder();
            String orderId = SerialGenerator.getOrderSerial();
            order.setOrderId(orderId);
            order.setOrderName(tbGoods.getGoodsName()+"等"+goodsParamVO.getGoodsCount()+"件商品");
            order.setOrderAmount(String.valueOf(PriceCalculateUtil.add(orderGoodsPrice,tbLogistics.getLogisticsPrice())));
            order.setPaymentAmount(String.valueOf(PriceCalculateUtil.add(orderGoodsPrice,tbLogistics.getLogisticsPrice())));
            order.setPaymentChannel(SparrowBeautyConstant.PAYMENT_CHANNEL_WECHAT);
            order.setOrderStatus(SparrowBeautyConstant.ORDER_STATUS_NO_PAY);
            order.setOrderPostageAmount(String.valueOf(tbLogistics.getLogisticsPrice()));
            order.setGoodsAmount(String.valueOf(PriceCalculateUtil.multiply(tbGoods.getGoodsPrice(),goodsParamVO.getGoodsCount())));
            order.setCouponsReduceAmount("0");
            order.setLogisticsName(tbLogistics.getLogisticsName());
            order.setLogisticsCode(String.valueOf(tbLogistics.getId()));
            order.setApiUserId(apiUser.getId());
            order.setApiUserMessage(goodsParamVO.getBuyerMessage());
            order.setApiUserNick(apiUser.getNickName());
            order.setOpenId(apiUser.getOpenId());
            String addressStr = tbAddress.getProvince()+tbAddress.getCity()+tbAddress.getDistrict()+tbAddress.getDetailedAddress();
            order.setAddress(addressStr);
            order.setPhoneNum(tbAddress.getConsigneePhone());
            order.setUserBindPhone(apiUser.getUserBindPhoneNum());
            order.setPosterUrl(tbGoods.getGoodsPosters());
            order.setCreateTime(currentDate);
            order.setGoodsTotalCount(String.valueOf(goodsParamVO.getGoodsCount()));
            order.setApiUserAddressId(tbAddress.getId());
            order.setCreateTime(currentDate);
            order.setUpdateTime(currentDate);
            //生成订单信息并入库
            tbOrderMapper.insert(order);

            //生成订单明细
            TbOrderDetail tbOrderDetail = new TbOrderDetail();
            tbOrderDetail.setOrderId(orderId);
            tbOrderDetail.setGoodsId(tbGoods.getId());
            tbOrderDetail.setGoodsName(tbGoods.getGoodsName());
            tbOrderDetail.setGoodsNum(goodsParamVO.getGoodsCount());
            tbOrderDetail.setGoodsPrice(tbGoods.getGoodsPrice());
            tbOrderDetail.setGoodsTotalAmount(String.valueOf(orderGoodsPrice));
            tbOrderDetailMapper.insert(tbOrderDetail);
            //调用微信支付进行支付
            Map<String, Object> payMap = apiPayService.createPayOrderToWechat(order);
            log.info("wechat pay create order return result : {},order : {}",payMap,order);
            //构建用户支付记录
            String businessId = SerialGenerator.getPayRecordSerial();
            TbUserPayRecord payRecord = new TbUserPayRecord();
            payRecord.setBusinessId(businessId);
            payRecord.setApiUserId(apiUser.getId());
            payRecord.setOpenId(apiUser.getOpenId());
            payRecord.setOrderId(order.getOrderId());
            payRecord.setOrderAmount(order.getOrderAmount());
            payRecord.setPaymentAmount(order.getPaymentAmount());
            payRecord.setNonceStr(String.valueOf(payMap.get("nonce_str")));
            payRecord.setPrepayId(String.valueOf(payMap.get("prepay_id")));
            String timeStamp = String.valueOf(System.currentTimeMillis() / 1000);
            payMap.put("timeStamp",timeStamp);
            payMap.put("signType",wechatInfoProperties.getSignType());
            String paySign = apiPayService.secondEncrypt(payRecord,timeStamp);
            payMap.put("paySign",paySign);
            payRecord.setCreateTime(currentDate);
            payRecord.setUpdateTime(currentDate);
            tbUserPayRecordMapper.insert(payRecord);
            payMap.remove("mch_id");
            return payMap;
        }catch (Exception e){
            log.error("createOrderByGoodsId happen exception",e);
            throw new RuntimeException("createOrderByGoodsId happen exception");
        }
    }
}
