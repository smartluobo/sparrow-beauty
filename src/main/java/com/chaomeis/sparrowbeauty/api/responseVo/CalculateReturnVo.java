package com.chaomeis.sparrowbeauty.api.responseVo;

import java.math.BigDecimal;

public class CalculateReturnVo {
    //订单总金额
    private double orderTotalAmount;
    //订单支付金额
    private double orderPayAmount;
    //订单优惠金额
    private double orderReduceAmount;
    //优惠策略名称
    private String couponsName;
    //0-无优惠 1 满五赠一系列 2 满减系列 3 优惠券 4新用户
    private int couponsType;

    private int userCouponsId;

    private String userCouponsName;

    private String phoneNum;

    private double postFee;

    public double getOrderTotalAmount() {
        return orderTotalAmount;
    }

    public void setOrderTotalAmount(double orderTotalAmount) {
        BigDecimal b = new BigDecimal(orderTotalAmount);

        this.orderTotalAmount = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public double getOrderPayAmount() {
        return orderPayAmount;
    }

    public void setOrderPayAmount(double orderPayAmount) {
        BigDecimal b = new BigDecimal(orderPayAmount);
        this.orderPayAmount = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public double getOrderReduceAmount() {
        return orderReduceAmount;
    }

    public void setOrderReduceAmount(double orderReduceAmount) {
        BigDecimal b = new BigDecimal(orderReduceAmount);
        this.orderReduceAmount = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
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

    public double getPostFee() {
        return postFee;
    }

    public void setPostFee(double postFee) {
        this.postFee = postFee;
    }

    @Override
    public String toString() {
        return "CalculateReturnVo{" +
                "orderTotalAmount=" + orderTotalAmount +
                ", orderPayAmount=" + orderPayAmount +
                ", orderReduceAmount=" + orderReduceAmount +
                ", couponsName='" + couponsName + '\'' +
                ", couponsType=" + couponsType +
                ", userCouponsId=" + userCouponsId +
                ", userCouponsName='" + userCouponsName + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
