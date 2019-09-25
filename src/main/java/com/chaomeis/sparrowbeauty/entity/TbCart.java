package com.chaomeis.sparrowbeauty.entity;

import java.util.Date;

public class TbCart {
    private int id;

    private String oppenId;

    private int goodsId;

    private Double showPrice;

    private String skuDetailIds;

    private Date createTime;

    private int goodsCount;

    private String skuDetailDesc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOppenId() {
        return oppenId;
    }

    public void setOppenId(String oppenId) {
        this.oppenId = oppenId == null ? null : oppenId.trim();
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public Double getShowPrice() {
        return showPrice;
    }

    public void setShowPrice(Double showPrice) {
        this.showPrice = showPrice;
    }

    public String getSkuDetailIds() {
        return skuDetailIds;
    }

    public void setSkuDetailIds(String skuDetailIds) {
        this.skuDetailIds = skuDetailIds == null ? null : skuDetailIds.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getSkuDetailDesc() {
        return skuDetailDesc;
    }

    public void setSkuDetailDesc(String skuDetailDesc) {
        this.skuDetailDesc = skuDetailDesc == null ? null : skuDetailDesc.trim();
    }
}