package com.chaomeis.sparrowbeauty.api.controller.order;

import com.chaomeis.sparrowbeauty.api.paramVo.CartOrderParamVo;
import com.chaomeis.sparrowbeauty.api.responseVo.CalculateReturnVo;
import com.chaomeis.sparrowbeauty.api.service.calculate.CalculateService;
import com.chaomeis.sparrowbeauty.api.service.order.ApiOrderService;
import com.chaomeis.sparrowbeauty.api.service.pay.ApiPayService;
import com.chaomeis.sparrowbeauty.api.service.user.ApiUserService;
import com.chaomeis.sparrowbeauty.common.PageReqVO;
import com.chaomeis.sparrowbeauty.common.PageRespDto;
import com.chaomeis.sparrowbeauty.entity.TbApiUser;
import com.chaomeis.sparrowbeauty.entity.TbOrder;
import com.chaomeis.sparrowbeauty.entity.TbOrderDetail;
import com.chaomeis.sparrowbeauty.entity.TbUserCoupons;
import com.chaomeis.sparrowbeauty.response.ResultInfo;
import com.chaomeis.sparrowbeauty.utils.DateUtil;
import com.chaomeis.sparrowbeauty.wechat.WxUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/order")
public class ApiOrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiOrderController.class);

    @Resource
    private ApiOrderService apiOrderService;

    @Resource
    private ApiPayService apiPayService;

    @Resource
    private ApiUserService apiUserService;

    @Resource
    private CalculateService calculateService;

    /**
     * 创建订单接口
     * @param cartOrderParamVo 创建订单参数对象
     * @return 返回支付加密字符串 小程序前端调起支付页面
     */
    @RequestMapping("createOrderByCart")
    public ResultInfo createOrderByCart(@RequestBody CartOrderParamVo cartOrderParamVo){
        if (cartOrderParamVo == null){
            LOGGER.error("createOrderByCart cartOrderParamVo is null");
            return ResultInfo.newEmptyParamsResultInfo();
        }
        //判断是否有订单id 如果有订单id 直接调用订单支付接口不用创建订单
        String orderId = cartOrderParamVo.getOrderId();
        if (StringUtils.isNotEmpty(orderId)){
            //直接走支付流程
            Map<String,Object> resultMap = apiPayService.payByOrderId(orderId);
            ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
            resultInfo.setData(resultMap);
            return resultInfo;
        }
        LOGGER.info("createOrderByCart cartOrderParamVo : {}",cartOrderParamVo);
        String openId = cartOrderParamVo.getOpenId();
        String cartItemIds = cartOrderParamVo.getCartItemIds();
        int userCouponsId = cartOrderParamVo.getUserCouponsId();
        int addressId = cartOrderParamVo.getAddressId();

        try {
            LOGGER.info("createOrderByCart params openId : {}, cartItemIds : {}, userCouponsId: {} ,addressId :{} ",
                    openId,cartItemIds,userCouponsId,addressId);
            ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();

            boolean flag = apiOrderService.checkCartOrderParameter(cartOrderParamVo);
            if (!flag){
                return ResultInfo.newParameterErrorResultInfo();
            }

            TbApiUser apiUser = apiUserService.findApiUserByOpenId(openId);

            Map<String, Object> payMap = apiOrderService.createOrderByCart(cartOrderParamVo,apiUser);
            if (payMap.size() == 0){
                return resultInfo;
            }else {
                resultInfo.setData(payMap);
                return resultInfo;
            }
        }catch (Exception e){
            LOGGER.error("createOrderByCart happen exception openId : {}, cartItemIds : {}, userCouponsId: {} ,addressId :{} selfGet : {}",
                    openId,cartItemIds,userCouponsId,addressId,e);
            return ResultInfo.newExceptionResultInfo();
        }
    }

    /**
     * 查询订单明细接口
     * @param params 查询订单明细接口参数对象
     * @return 返回订单明细
     */
    @RequestMapping("/findOrderDetailById")
    public ResultInfo findOrderDetailById(@RequestBody Map<String,String> params){
        if (params == null){
            return ResultInfo.newEmptyParamsResultInfo();
        }
        String orderId = params.get("orderId");
        try {
            ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
            TbOrder orderInfo = apiOrderService.findOrderDetailById(orderId);
            orderInfo.setCreateDateStr(DateUtil.viewDateFormat(orderInfo.getCreateTime()));
            List<TbOrderDetail> orderDetails = apiOrderService.findOrderDetailByOrderId(orderId);
            orderInfo.setOrderDetails(orderDetails);
            resultInfo.setData(orderInfo);
            return resultInfo;
        }catch (Exception e){
            LOGGER.error("findOrderDetailById happen exception orderId ; {}",orderId,e);
            return ResultInfo.newExceptionResultInfo();
        }
    }

    /**
     * 查询订单明细接口
     * @param tbOrder  查询订单明细接口参数对象
     * @return  查询订单明细接口参数对象
     */
    @RequestMapping("/findOrderDetail")
    public ResultInfo findOrderDetail(@RequestBody TbOrder tbOrder){
        if (tbOrder == null){
            return ResultInfo.newEmptyParamsResultInfo();
        }
        String orderId = tbOrder.getOrderId();
        String openId = tbOrder.getOpenId();
        if(StringUtils.isEmpty(orderId) || StringUtils.isEmpty(openId)) {
            return ResultInfo.newRepeatResultInfo("订单Id或者openId不能为空!");
        }
        TbOrder order = apiOrderService.findOrderDetail(tbOrder);
        ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
        resultInfo.setData(order);
        return resultInfo;

    }

    /**
     * 根据用户openId查询用户的订单列表
     * @param page 查询订单列表的参数对象
     * @return 返回用户的订单列表信息xx
     */
    @RequestMapping("/findPage")
    public PageRespDto<TbOrder> findOrderPageList(@RequestBody PageReqVO<TbOrder> page){
        TbOrder order = page.getCondition();
        if (StringUtils.isEmpty(order.getOpenId())) {
            // openId不能为空
            return new PageRespDto(null);
        }
        return apiOrderService.findOrderPageList(page);
    }

    /**
     * 计算订单价格
     * @param paramVo 创建订单的参数对象
     * @return 返回后台结算的订单价格信息
     */
    @RequestMapping("/calculateCartOrderPrice")
    public ResultInfo calculateCartOrderPrice(@RequestBody CartOrderParamVo paramVo){

        if (paramVo == null){
            return ResultInfo.newEmptyParamsResultInfo();
        }
        try {
            LOGGER.info("calculateCartOrderPrice CartOrderParamVo : {}",paramVo);
            ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
            CalculateReturnVo calculateReturnVo = calculateService.calculateCartOrderPrice(paramVo);
            LOGGER.info(" call cart calculate price calculateReturnVo : {}",calculateReturnVo);
            resultInfo.setData(calculateReturnVo);
            return resultInfo;
        }catch (Exception e){
            LOGGER.error("calculateCartOrderPrice happen exception",e);
            return ResultInfo.newExceptionResultInfo();
        }

    }

    /**
     * 微信支付回调接口
     * @param request 回调参数对象
     * @return 向微信方返回满足微信方回调的结果，该结果返回错误微信方会使用退避算法一直调用该接口
     */
    @RequestMapping("/payUpdateOrder")
    public String payUpdateOrder(HttpServletRequest request){
        LOGGER.info("wechat callback.......");
        String lastXml;
        try {
            boolean flag = apiPayService.payCallbackHandle(request);
            if (flag){
                //处理成功
                lastXml = WxUtil.returnXML("SUCCESS");
                LOGGER.info("wechat pay call back update success *******");
            }else{
                //处理失败
                lastXml =  WxUtil.returnXML("FAIL");
            }
            LOGGER.info("wechat pay callback return info : {}" + lastXml);
            return lastXml;
        } catch (Exception e) {
            lastXml =  WxUtil.returnXML("FAIL");
            LOGGER.info("wechat pay callback return info : {} happen exception" + lastXml,e);
            return lastXml;
        }
    }

    /**
     * 取消订单操作
     * @param params 订单信息对象
     * @return 返回取消是否成功
     */
    @RequestMapping("/cancelOrder")
    public ResultInfo cancelOrder(@RequestBody Map<String,String> params){
        if (params == null){
            return ResultInfo.newEmptyParamsResultInfo();
        }
        String openId = params.get("openId");
        String orderId = params.get("orderId");
        LOGGER.info("current user openId : {} cancel order orderId : {}",openId,orderId);
        try {
            ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
            apiOrderService.cancelOrder(openId,orderId);
            return resultInfo;
        }catch (Exception e){
            LOGGER.error("calculateGoodsOrderPrice GoodsOrderParamVo : {}",params,e);
            return ResultInfo.newExceptionResultInfo();
        }
    }



}
