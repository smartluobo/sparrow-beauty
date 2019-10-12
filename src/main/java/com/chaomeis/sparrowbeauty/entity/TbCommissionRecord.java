package com.chaomeis.sparrowbeauty.entity;

import java.util.Date;

public class TbCommissionRecord {
    private Integer id;

    private String openId;

    private String tradingId;

    private String tradingAmount;

    private String consumerOpenId;

    private String commissionRatio;

    private Integer settlementStatus;

    private Date createTime;

    private Date updateTime;

    private Integer consumerSource;

    private String serialNo;

    private Integer apiUserId;

    private String commissionAmount;

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

    public String getTradingId() {
        return tradingId;
    }

    public void setTradingId(String tradingId) {
        this.tradingId = tradingId == null ? null : tradingId.trim();
    }

    public String getTradingAmount() {
        return tradingAmount;
    }

    public void setTradingAmount(String tradingAmount) {
        this.tradingAmount = tradingAmount == null ? null : tradingAmount.trim();
    }

    public String getConsumerOpenId() {
        return consumerOpenId;
    }

    public void setConsumerOpenId(String consumerOpenId) {
        this.consumerOpenId = consumerOpenId == null ? null : consumerOpenId.trim();
    }

    public String getCommissionRatio() {
        return commissionRatio;
    }

    public void setCommissionRatio(String commissionRatio) {
        this.commissionRatio = commissionRatio == null ? null : commissionRatio.trim();
    }

    public Integer getSettlementStatus() {
        return settlementStatus;
    }

    public void setSettlementStatus(Integer settlementStatus) {
        this.settlementStatus = settlementStatus;
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

    public Integer getConsumerSource() {
        return consumerSource;
    }

    public void setConsumerSource(Integer consumerSource) {
        this.consumerSource = consumerSource;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo == null ? null : serialNo.trim();
    }

    public Integer getApiUserId() {
        return apiUserId;
    }

    public void setApiUserId(Integer apiUserId) {
        this.apiUserId = apiUserId;
    }

    public String getCommissionAmount() {
        return commissionAmount;
    }

    public void setCommissionAmount(String commissionAmount) {
        this.commissionAmount = commissionAmount == null ? null : commissionAmount.trim();
    }
}