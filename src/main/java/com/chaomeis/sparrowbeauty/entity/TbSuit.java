package com.chaomeis.sparrowbeauty.entity;

import java.util.Date;

public class TbSuit {
    private Integer id;

    private String firstName;

    private String secondName;

    private String suitPrice;

    private String skuDetailIds;

    private String skuDetailDescs;

    private String suitCover;

    private String suitDetailPoster;

    private Date createTime;

    private Date updateTime;

    private Integer cmsUserId;

    private String cmsUserName;

    private String simpleDesc;

    private String secondDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? null : firstName.trim();
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName == null ? null : secondName.trim();
    }

    public String getSuitPrice() {
        return suitPrice;
    }

    public void setSuitPrice(String suitPrice) {
        this.suitPrice = suitPrice == null ? null : suitPrice.trim();
    }

    public String getSkuDetailIds() {
        return skuDetailIds;
    }

    public void setSkuDetailIds(String skuDetailIds) {
        this.skuDetailIds = skuDetailIds == null ? null : skuDetailIds.trim();
    }

    public String getSkuDetailDescs() {
        return skuDetailDescs;
    }

    public void setSkuDetailDescs(String skuDetailDescs) {
        this.skuDetailDescs = skuDetailDescs == null ? null : skuDetailDescs.trim();
    }

    public String getSuitCover() {
        return suitCover;
    }

    public void setSuitCover(String suitCover) {
        this.suitCover = suitCover == null ? null : suitCover.trim();
    }

    public String getSuitDetailPoster() {
        return suitDetailPoster;
    }

    public void setSuitDetailPoster(String suitDetailPoster) {
        this.suitDetailPoster = suitDetailPoster == null ? null : suitDetailPoster.trim();
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

    public String getSimpleDesc() {
        return simpleDesc;
    }

    public void setSimpleDesc(String simpleDesc) {
        this.simpleDesc = simpleDesc == null ? null : simpleDesc.trim();
    }

    public String getSecondDesc() {
        return secondDesc;
    }

    public void setSecondDesc(String secondDesc) {
        this.secondDesc = secondDesc == null ? null : secondDesc.trim();
    }
}