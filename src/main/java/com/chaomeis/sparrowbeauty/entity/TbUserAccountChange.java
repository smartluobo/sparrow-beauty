package com.chaomeis.sparrowbeauty.entity;

import java.util.Date;

public class TbUserAccountChange {
    private Integer id;

    private String openId;

    private Integer apiUserId;

    private Integer cashDirection;

    private String cashAmount;

    private Integer tradingSource;

    private String tradingId;

    private String serialNo;

    private Date createTime;

    private Date updateTime;

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

    public Integer getCashDirection() {
        return cashDirection;
    }

    public void setCashDirection(Integer cashDirection) {
        this.cashDirection = cashDirection;
    }

    public String getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(String cashAmount) {
        this.cashAmount = cashAmount == null ? null : cashAmount.trim();
    }

    public Integer getTradingSource() {
        return tradingSource;
    }

    public void setTradingSource(Integer tradingSource) {
        this.tradingSource = tradingSource;
    }

    public String getTradingId() {
        return tradingId;
    }

    public void setTradingId(String tradingId) {
        this.tradingId = tradingId == null ? null : tradingId.trim();
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo == null ? null : serialNo.trim();
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
}