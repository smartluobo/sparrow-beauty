package com.chaomeis.sparrowbeauty.entity;

public class TbOrderDetail {
    private Integer id;

    private String orderId;

    private int goodsId;

    private String skuTypeIds;

    private String defaultSkuDetailIds;

    private int goodsNum;

    private String goodsName;

    private String goodsPrice;

    private String goodsTotalAmount;

    private String skuDetailDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getSkuTypeIds() {
        return skuTypeIds;
    }

    public void setSkuTypeIds(String skuTypeIds) {
        this.skuTypeIds = skuTypeIds == null ? null : skuTypeIds.trim();
    }

    public String getDefaultSkuDetailIds() {
        return defaultSkuDetailIds;
    }

    public void setDefaultSkuDetailIds(String defaultSkuDetailIds) {
        this.defaultSkuDetailIds = defaultSkuDetailIds == null ? null : defaultSkuDetailIds.trim();
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice == null ? null : goodsPrice.trim();
    }

    public String getGoodsTotalAmount() {
        return goodsTotalAmount;
    }

    public void setGoodsTotalAmount(String goodsTotalAmount) {
        this.goodsTotalAmount = goodsTotalAmount == null ? null : goodsTotalAmount.trim();
    }

    public String getSkuDetailDesc() {
        return skuDetailDesc;
    }

    public void setSkuDetailDesc(String skuDetailDesc) {
        this.skuDetailDesc = skuDetailDesc == null ? null : skuDetailDesc.trim();
    }
}