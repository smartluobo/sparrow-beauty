package com.chaomeis.sparrowbeauty.entity;

import java.util.Date;

public class TbUserCoupons {
    private Integer id;

    private String openId;

    private Integer couponsId;

    private String couponsName;

    private Integer receiveDate;

    private Date createTime;

    private Integer status;

    private String couponsPoster;

    private Date expireDate;

    private Integer isReferrer;

    private String couponsRatio;

    private Integer couponsType;

    private String useRules;

    private String useScope;

    private Integer couponsSource;

    private String sourceName;

    private Integer activityId;

    private Integer useWay;

    private Integer expireType;

    private String cashAmount;

    private Integer apiUserId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public Integer getCouponsId() {
        return couponsId;
    }

    public void setCouponsId(Integer couponsId) {
        this.couponsId = couponsId;
    }

    public String getCouponsName() {
        return couponsName;
    }

    public void setCouponsName(String couponsName) {
        this.couponsName = couponsName == null ? null : couponsName.trim();
    }

    public Integer getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Integer receiveDate) {
        this.receiveDate = receiveDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCouponsPoster() {
        return couponsPoster;
    }

    public void setCouponsPoster(String couponsPoster) {
        this.couponsPoster = couponsPoster == null ? null : couponsPoster.trim();
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Integer getIsReferrer() {
        return isReferrer;
    }

    public void setIsReferrer(Integer isReferrer) {
        this.isReferrer = isReferrer;
    }

    public String getCouponsRatio() {
        return couponsRatio;
    }

    public void setCouponsRatio(String couponsRatio) {
        this.couponsRatio = couponsRatio == null ? null : couponsRatio.trim();
    }

    public Integer getCouponsType() {
        return couponsType;
    }

    public void setCouponsType(Integer couponsType) {
        this.couponsType = couponsType;
    }

    public String getUseRules() {
        return useRules;
    }

    public void setUseRules(String useRules) {
        this.useRules = useRules == null ? null : useRules.trim();
    }

    public String getUseScope() {
        return useScope;
    }

    public void setUseScope(String useScope) {
        this.useScope = useScope == null ? null : useScope.trim();
    }

    public Integer getCouponsSource() {
        return couponsSource;
    }

    public void setCouponsSource(Integer couponsSource) {
        this.couponsSource = couponsSource;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName == null ? null : sourceName.trim();
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getUseWay() {
        return useWay;
    }

    public void setUseWay(Integer useWay) {
        this.useWay = useWay;
    }

    public Integer getExpireType() {
        return expireType;
    }

    public void setExpireType(Integer expireType) {
        this.expireType = expireType;
    }

    public String getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(String cashAmount) {
        this.cashAmount = cashAmount == null ? null : cashAmount.trim();
    }

    public Integer getApiUserId() {
        return apiUserId;
    }

    public void setApiUserId(Integer apiUserId) {
        this.apiUserId = apiUserId;
    }
}