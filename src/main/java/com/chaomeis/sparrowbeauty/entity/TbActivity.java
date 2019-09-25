package com.chaomeis.sparrowbeauty.entity;

import java.util.Date;

public class TbActivity {
    private int id;

    private String activityName;

    private String activityType;

    private Date startDate;

    private Date endDate;

    private int startHour;

    private int endHour;

    private String activityPoster;

    private Date createTime;

    private Date updateTime;

    private String activityRatio;

    private int cmsUserId;

    private String cmsUserName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
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