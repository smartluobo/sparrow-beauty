package com.chaomeis.sparrowbeauty.entity;

import java.util.Date;
import java.util.List;

public class TbActivity {
    private Integer id;

    private String activityName;

    private String activityType; // 0 全场折扣 1 限时活动

    private Date startDate;

    private Date endDate;

    private Integer startHour;

    private Integer endHour;

    private String activityPoster;

    private Date createTime;

    private Date updateTime;

    private String activityRatio;

    private Integer cmsUserId;

    private String cmsUserName;
    /*折扣比例*/
    private String couponsRatio;
    /*减免金额*/
    private String reduceAmount;
    /*活动对应的商品*/
    private List<TbGoods> goodsList;

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType == null ? null : activityType.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    public String getActivityPoster() {
        return activityPoster;
    }

    public void setActivityPoster(String activityPoster) {
        this.activityPoster = activityPoster == null ? null : activityPoster.trim();
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

    public String getActivityRatio() {
        return activityRatio;
    }

    public void setActivityRatio(String activityRatio) {
        this.activityRatio = activityRatio == null ? null : activityRatio.trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStartHour() {
        return startHour;
    }

    public void setStartHour(Integer startHour) {
        this.startHour = startHour;
    }

    public Integer getEndHour() {
        return endHour;
    }

    public void setEndHour(Integer endHour) {
        this.endHour = endHour;
    }

    public Integer getCmsUserId() {
        return cmsUserId;
    }

    public void setCmsUserId(Integer cmsUserId) {
        this.cmsUserId = cmsUserId;
    }

    public String getCmsUserName() {
        return cmsUserName;
    }

    public void setCmsUserName(String cmsUserName) {
        this.cmsUserName = cmsUserName == null ? null : cmsUserName.trim();
    }

    public String getCouponsRatio() {
        return couponsRatio;
    }

    public void setCouponsRatio(String couponsRatio) {
        this.couponsRatio = couponsRatio;
    }

    public String getReduceAmount() {
        return reduceAmount;
    }

    public void setReduceAmount(String reduceAmount) {
        this.reduceAmount = reduceAmount;
    }

    public List<TbGoods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<TbGoods> goodsList) {
        this.goodsList = goodsList;
    }
}