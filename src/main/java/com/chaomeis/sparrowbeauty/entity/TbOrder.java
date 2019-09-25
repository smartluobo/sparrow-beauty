package com.chaomeis.sparrowbeauty.entity;

import java.util.Date;

public class TbOrder {
    private String orderId;

    private String orderName;

    private String orderAmount;

    private String paymentAmount;

    private int paymentChannel;

    private int orderStatus;

    private String orderPostageAmount;

    private String goodsAmount;

    private String couponsReduceAmount;

    private Date paymentTime;

    private Date deliveryTime;

    private String logisticsName;

    private String logisticsCode;

    private int apiUserId;

    private String apiUserMessage;

    private String apiUserNick;

    private String openId;

    private String address;

    private String phoneNum;

    private String posterUrl;

    private String goodsTotalCount;

    private int apiUserCouponsId;

    private String apiUserCouponsName;

    private int apiUserAddressId;

    private int isFirstOrder;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName == null ? null : orderName.trim();
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount == null ? null : orderAmount.trim();
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount == null ? null : paymentAmount.trim();
    }

    public int getPaymentChannel() {
        return paymentChannel;
    }

    public void setPaymentChannel(int paymentChannel) {
        this.paymentChannel = paymentChannel;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderPostageAmount() {
        return orderPostageAmount;
    }

    public void setOrderPostageAmount(String orderPostageAmount) {
        this.orderPostageAmount = orderPostageAmount == null ? null : orderPostageAmount.trim();
    }

    public String getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(String goodsAmount) {
        this.goodsAmount = goodsAmount == null ? null : goodsAmount.trim();
    }

    public String getCouponsReduceAmount() {
        return couponsReduceAmount;
    }

    public void setCouponsReduceAmount(String couponsReduceAmount) {
        this.couponsReduceAmount = couponsReduceAmount == null ? null : couponsReduceAmount.trim();
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getLogisticsName() {
        return logisticsName;
    }

    public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName == null ? null : logisticsName.trim();
    }

    public String getLogisticsCode() {
        return logisticsCode;
    }

    public void setLogisticsCode(String logisticsCode) {
        this.logisticsCode = logisticsCode == null ? null : logisticsCode.trim();
    }

    public int getApiUserId() {
        return apiUserId;
    }

    public void setApiUserId(int apiUserId) {
        this.apiUserId = apiUserId;
    }

    public String getApiUserMessage() {
        return apiUserMessage;
    }

    public void setApiUserMessage(String apiUserMessage) {
        this.apiUserMessage = apiUserMessage == null ? null : apiUserMessage.trim();
    }

    public String getApiUserNick() {
        return apiUserNick;
    }

    public void setApiUserNick(String apiUserNick) {
        this.apiUserNick = apiUserNick == null ? null : apiUserNick.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl == null ? null : posterUrl.trim();
    }

    public String getGoodsTotalCount() {
        return goodsTotalCount;
    }

    public void setGoodsTotalCount(String goodsTotalCount) {
        this.goodsTotalCount = goodsTotalCount == null ? null : goodsTotalCount.trim();
    }

    public int getApiUserCouponsId() {
        return apiUserCouponsId;
    }

    public void setApiUserCouponsId(int apiUserCouponsId) {
        this.apiUserCouponsId = apiUserCouponsId;
    }

    public String getApiUserCouponsName() {
        return apiUserCouponsName;
    }

    public void setApiUserCouponsName(String apiUserCouponsName) {
        this.apiUserCouponsName = apiUserCouponsName == null ? null : apiUserCouponsName.trim();
    }

    public int getApiUserAddressId() {
        return apiUserAddressId;
    }

    public void setApiUserAddressId(int apiUserAddressId) {
        this.apiUserAddressId = apiUserAddressId;
    }

    public int getIsFirstOrder() {
        return isFirstOrder;
    }

    public void setIsFirstOrder(int isFirstOrder) {
        this.isFirstOrder = isFirstOrder;
    }
}