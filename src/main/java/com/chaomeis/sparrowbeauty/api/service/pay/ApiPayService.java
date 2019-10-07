package com.chaomeis.sparrowbeauty.api.service.pay;

import com.chaomeis.sparrowbeauty.api.service.wechat.WechatSendService;
import com.chaomeis.sparrowbeauty.mapper.TbOrderMapper;
import com.chaomeis.sparrowbeauty.mapper.TbUserPayRecordMapper;
import com.chaomeis.sparrowbeauty.utils.Md5Util;
import com.chaomeis.sparrowbeauty.wechat.*;
import com.chaomeis.sparrowbeauty.config.WechatInfoProperties;
import com.chaomeis.sparrowbeauty.entity.TbOrder;
import com.chaomeis.sparrowbeauty.entity.TbUserPayRecord;
import com.chaomeis.sparrowbeauty.utils.PriceCalculateUtil;
import com.thoughtworks.xstream.XStream;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.math.BigDecimal;
import java.util.*;

@Service
public class ApiPayService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiPayService.class);

    @Resource
    private WechatInfoProperties wechatInfoProperties;

    @Resource
    private WechatSendService wechatSendService;

    @Resource
    private TbUserPayRecordMapper tbUserPayRecordMapper;

    @Resource
    private TbOrderMapper tbOrderMapper;

    /**
     * 如果订单已经在微信创建支付订单，直接根据第一次返回的支付信息返回支付加密字符串
     * @param orderId 订单id
     * @return 返回支付需要的加密字符串
     */
    public Map<String, Object> payByOrderId(String orderId) {
        Map<String ,Object> resultMap = new HashMap<>();
        TbUserPayRecord tbUserPayRecord = tbUserPayRecordMapper.findPayRecordByOrderId(orderId);
        resultMap.put("nonce_str",tbUserPayRecord.getNonceStr());
        resultMap.put("prepay_id",tbUserPayRecord.getPrepayId());
        resultMap.put("appid",wechatInfoProperties.getAppId());
        String timeStamp = String.valueOf(System.currentTimeMillis() / 1000);
        resultMap.put("timeStamp",timeStamp);
        resultMap.put("signType",wechatInfoProperties.getSignType());
        String paySign = secondEncrypt(tbUserPayRecord,timeStamp);
        resultMap.put("paySign",paySign);
        return resultMap;
    }

    /**
     * 微信支付下单方法
     * @param tbOrder 平台订单信息
     * @return 返回微信支付下单结果
     * @throws Exception 异常抛出
     */
    public Map<String, Object> createPayOrderToWechat(TbOrder tbOrder) throws Exception{
        WechatCreateOrderRequest request = buildWechatCreateOrderRequest(tbOrder);
        String sendXml = getSendXml(request);
        Map<String,Object> body = new HashMap<>();
        body.put("body",sendXml);
        String wechatServerReturnResult = wechatSendService.sendDataToWechatServer(sendXml);
        if (StringUtils.isNotEmpty(wechatServerReturnResult)){
            Map<String, Object> resultMap = WechatXmlParser.getMapFromXML(wechatServerReturnResult);
            return resultMap;
        }
        return null;
    }

    /**
     * 二次加密
     * @param tbUserPayRecord 用户支付记录
     * @param timeStamp 时间戳
     * @return 返回二次加密字符串
     */
    public String secondEncrypt(TbUserPayRecord tbUserPayRecord, String timeStamp) {
        String appid = wechatInfoProperties.getAppId();
        String nonceStr = tbUserPayRecord.getNonceStr();
        String prepay_id = tbUserPayRecord.getPrepayId();
        String signType = wechatInfoProperties.getSignType();
        if (org.springframework.util.StringUtils.isEmpty(appid) || org.springframework.util.StringUtils.isEmpty(nonceStr) ||
                org.springframework.util.StringUtils.isEmpty(prepay_id) || org.springframework.util.StringUtils.isEmpty(signType) || org.springframework.util.StringUtils.isEmpty(timeStamp)){
            return null;
        }

        StringBuffer sb = new StringBuffer("appId=");
        sb.append(appid).append("&nonceStr=").append(nonceStr).append("&package=prepay_id=").append(prepay_id)
                .append("&signType=").append(wechatInfoProperties.getSignType()).append("&timeStamp=").append(timeStamp)
                .append("&key=").append(wechatInfoProperties.getApiKey());
        String notSignStr = sb.toString();
        String signStr = Md5Util.encryptMD5(notSignStr).toUpperCase();
        LOGGER.info("secondEncrypt notSignStr :{}---signStr : {}",notSignStr,signStr);
        return signStr;
    }

    /**
     * 根据订单信息构建微信支付下单报文
     * @param tbOrder 平台订单信息
     * @return 返回微信支付下单报文
     */
    private WechatCreateOrderRequest buildWechatCreateOrderRequest(TbOrder tbOrder) {
        Random random = new Random();
        WechatCreateOrderRequest request = new WechatCreateOrderRequest();
        request.setAppid(wechatInfoProperties.getAppId());
        request.setMch_id(wechatInfoProperties.getMchId());
        request.setNonce_str(tbOrder.getOrderId()+random.nextInt(100));
        String notifyUrl = wechatInfoProperties.getNotifyUrl();
        LOGGER.info("order pay notifyUrl : {}",notifyUrl);
        request.setNotify_url(notifyUrl);
        request.setSign_type(wechatInfoProperties.getSignType());
        request.setTotal_fee(PriceCalculateUtil.intOrderTbPrice(new BigDecimal(String.valueOf(tbOrder.getPaymentAmount()))));
        request.setTrade_type(wechatInfoProperties.getTradeType());
        request.setOut_trade_no(tbOrder.getOrderId());
        request.setSpbill_create_ip(wechatInfoProperties.getClientIp());
        request.setBody(tbOrder.getOrderName());
        request.setOpenid(tbOrder.getOpenId());
        return request;
    }

    /**
     * 将微信下单报文转xml格式
     * @param request 微信下单报文
     * @return 返回报文的xml格式
     */
    private String getSendXml(WechatCreateOrderRequest request) {
        String sign = WechatSignUtil.getSignForObject(request, wechatInfoProperties.getApiKey());
        request.setSign(sign);
        XStream st = XStreamFactory.getRequestXstream();
        String resultXml = st.toXML(request);
        return resultXml;
    }

    public boolean payCallbackHandle(HttpServletRequest request) {
        LOGGER.info("enter wechat pay callback......");
        String orderId = null;
        try {
            String xmlString = getXmlString(request);
            LOGGER.info("wechat callback result String" + xmlString);
            // 先解析返回的数据
            Map<String, String> resultMap = WxUtil.xmlToMap(xmlString);
            LOGGER.info("wechat callback params : {}" ,resultMap);
            String returnCode = resultMap.get("return_code");
            LOGGER.info("wechat pay callback return_code : {}",returnCode);
            // 通信成功
            if ("SUCCESS".equals(returnCode)) {
                String transactionId = resultMap.get("transaction_id");
                orderId = resultMap.get("out_trade_no");
                Map<String,Object> updateMap = new HashMap<>();
                updateMap.put("transactionId",transactionId);
                updateMap.put("orderId",orderId);
                updateMap.put("updateTime",new Date());
                if (resultMap.get("result_code").equals("SUCCESS")) {
                    LOGGER.info("current order orderId : {orderId} pay success",orderId);
                    TbOrder tbOrder = tbOrderMapper.selectByPrimaryKey(orderId);
                    //支付成功更新
                    //todo 1更新订单状态

                    //todo 2扣减库存

                    //todo 3更新支付记录状态

                    //如果订单使用优惠券 将优惠券的修改为已经使用
                    if (tbOrder.getApiUserCouponsId() != 0){
                       //todo 更新优惠券的使用状态为已经使用
                    }
                    //todo 订单支付完成后的处理方式 1.送券 2.代理商返现 等
                    LOGGER.info("pay call back print order success orderId : {}",tbOrder.getOrderId());
                }
                return true;
            }
            return false;
        }catch (Exception e){
            LOGGER.error("wechat pay success callback happen exception orderId : {}",orderId,e);
            return false;
        }
    }

    public String getXmlString(HttpServletRequest request) {
        BufferedReader reader ;
        String line;
        String xmlString;
        try {
            reader = request.getReader();
            StringBuffer inputString = new StringBuffer();

            while ((line = reader.readLine()) != null) {
                inputString.append(line);
            }
            xmlString = inputString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return xmlString;
    }
}
