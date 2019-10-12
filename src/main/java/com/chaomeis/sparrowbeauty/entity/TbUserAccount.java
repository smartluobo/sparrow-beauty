package com.chaomeis.sparrowbeauty.entity;

import java.util.Date;

public class TbUserAccount {
    private Integer id;

    private String openId;

    private Integer apiUserId;

    private String totalAmount;

    private String remainingAmount;

    private String withdrawalingAmount;

    private Date createTime;

    private Date updateTime;

    private String freezeAmount;

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

    public Integer getApiUserId() {
        return apiUserId;
    }

    public void setApiUserId(Integer apiUserId) {
        this.apiUserId = apiUserId;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount == null ? null : totalAmount.trim();
    }

    public String getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(String remainingAmount) {
        this.remainingAmount = remainingAmount == null ? null : remainingAmount.trim();
    }

    public String getWithdrawalingAmount() {
        return withdrawalingAmount;
    }

    public void setWithdrawalingAmount(String withdrawalingAmount) {
        this.withdrawalingAmount = withdrawalingAmount == null ? null : withdrawalingAmount.trim();
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

    public String getFreezeAmount() {
        return freezeAmount;
    }

    public void setFreezeAmount(String freezeAmount) {
        this.freezeAmount = freezeAmount == null ? null : freezeAmount.trim();
    }
}