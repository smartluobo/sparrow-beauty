package com.chaomeis.sparrowbeauty.entity;

import java.util.Date;

public class TbDealerLevel {
    private Integer id;

    private String name;

    private Integer shareCount;

    private Integer sellAmount;

    private Integer logicalRelation;

    private String commissionRatio;

    private Date createTime;

    private Date updateTime;

    private Integer cmsUserId;

    private String cmsUserName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getShareCount() {
        return shareCount;
    }

    public void setShareCount(Integer shareCount) {
        this.shareCount = shareCount;
    }

    public Integer getSellAmount() {
        return sellAmount;
    }

    public void setSellAmount(Integer sellAmount) {
        this.sellAmount = sellAmount;
    }

    public Integer getLogicalRelation() {
        return logicalRelation;
    }

    public void setLogicalRelation(Integer logicalRelation) {
        this.logicalRelation = logicalRelation;
    }

    public String getCommissionRatio() {
        return commissionRatio;
    }

    public void setCommissionRatio(String commissionRatio) {
        this.commissionRatio = commissionRatio == null ? null : commissionRatio.trim();
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
}