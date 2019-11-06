package com.chaomeis.sparrowbeauty.api.responseVo;

import java.math.BigDecimal;

public class CalculateReturnVo {
    //订单总金额
    private String orderTotalAmount;
    //订单支付金额
    private String orderPayAmount;
    //订单优惠金额
    private String orderReduceAmount;
    //优惠策略名称
    private String couponsName;
    //0-无优惠 1 满五赠一系列 2 满减系列 3 优惠券 4新用户
    private int couponsType;

    private int userCouponsId;

    private String userCouponsName;

    private String phoneNum;

    private String postFee;

    public String getOrderTotalAmount() {
        return orderTotalAmount;
    }

    public void setOrderTotalAmount(String orderTotalAmount) {
        this.orderTotalAmount = orderTotalAmount;
    }

    public String getOrderPayAmount() {
        return orderPayAmount;
    }

    public void setOrderPayAmount(String orderPayAmount) {
        this.orderPayAmount = orderPayAmount;
    }

    public String getOrderReduceAmount() {
        return orderReduceAmount;
    }

    public void setOrderReduceAmount(String orderReduceAmount) {
        this.orderReduceAmount = orderReduceAmount;
    }

    public String getCouponsName() {
        return couponsName;
    }

    public void setCouponsName(String couponsName) {
        this.couponsName = couponsName;
    }

    public int getCouponsType() {
        return couponsType;
    }

    public void setCouponsType(int couponsType) {
        this.couponsType = couponsType;
    }

    public int getUserCouponsId() {
        return userCouponsId;
    }

    public void setUserCouponsId(int userCouponsId) {
        this.userCouponsId = userCouponsId;
    }

    public String getUserCouponsName() {
        return userCouponsName;
    }

    public void setUserCouponsName(String userCouponsName) {
        this.userCouponsName = userCouponsName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPostFee() {
        return postFee;
    }

    public void setPostFee(String postFee) {
        this.postFee = postFee;
    }

}
