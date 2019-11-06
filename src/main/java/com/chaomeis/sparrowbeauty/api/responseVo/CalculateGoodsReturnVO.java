package com.chaomeis.sparrowbeauty.api.responseVo;

public class CalculateGoodsReturnVO {
    // 商品支付金额
    private String goodsPayAmount;
    //商品总金额
    private String goodsTotalAmount;
    //订单优惠金额
    private String goodsReduceAmount;
    //优惠策略名称
    private String couponsName;
    //0-无优惠 1 满五赠一系列 2 满减系列 3 优惠券 4新用户
    private int couponsType;
    // 优惠券id
    private int userCouponsId;
    // 优惠券id
    private String userCouponsName;
    // 邮费
    private String postFee;
    // 电话号码
    private String phoneNum;

    public String getGoodsPayAmount() {
        return goodsPayAmount;
    }

    public void setGoodsPayAmount(String goodsPayAmount) {
        this.goodsPayAmount = goodsPayAmount;
    }

    public String getGoodsTotalAmount() {
        return goodsTotalAmount;
    }

    public void setGoodsTotalAmount(String goodsTotalAmount) {
        this.goodsTotalAmount = goodsTotalAmount;
    }

    public String getGoodsReduceAmount() {
        return goodsReduceAmount;
    }

    public void setGoodsReduceAmount(String goodsReduceAmount) {
        this.goodsReduceAmount = goodsReduceAmount;
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

    public String getPostFee() {
        return postFee;
    }

    public void setPostFee(String postFee) {
        this.postFee = postFee;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
