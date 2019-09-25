package com.chaomeis.sparrowbeauty.entity;

import java.util.Date;

public class TbActivityGoods {
    private int id;

    private int activityId;

    private String activityName;

    private int goodsId;

    private String goodsName;

    private int priceType;

    private String activitPrice;

    private String activityRatio;

    private Date createTime;

    private Date updateTime;

    private int cmsUserId;

    private String cmsUserName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public int getPriceType() {
        return priceType;
    }

    public void setPriceType(int priceType) {
        this.priceType = priceType;
    }

    public String getActivitPrice() {
        return activitPrice;
    }

    public void setActivitPrice(String activitPrice) {
        this.activitPrice = activitPrice == null ? null : activitPrice.trim();
    }

    public String getActivityRatio() {
        return activityRatio;
    }

    public void setActivityRatio(String activityRatio) {
        this.activityRatio = activityRatio == null ? null : activityRatio.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getCmsUserId() {
        return cmsUserId;
    }

    public void setCmsUserId(int cmsUserId) {
        this.cmsUserId = cmsUserId;
    }

    public String getCmsUserName() {
        return cmsUserName;
    }

    public void setCmsUserName(String cmsUserName) {
        this.cmsUserName = cmsUserName == null ? null : cmsUserName.trim();
    }
}