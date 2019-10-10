package com.chaomeis.sparrowbeauty.entity;

import java.util.Date;
import java.util.List;

public class TbSkuType {
    private Integer id;

    private String skuTypeName;

    private String remark;

    private Integer cmsUserId;

    private String cmsUserName;

    private Date createTime;

    private Date updateTime;

    private String cmsView;

    private List<TbSkuDetail> skuDetailList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkuTypeName() {
        return skuTypeName;
    }

    public void setSkuTypeName(String skuTypeName) {
        this.skuTypeName = skuTypeName == null ? null : skuTypeName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public String getCmsView() {
        return cmsView;
    }

    public void setCmsView(String cmsView) {
        this.cmsView = cmsView == null ? null : cmsView.trim();
    }

    public List<TbSkuDetail> getSkuDetailList() {
        return skuDetailList;
    }

    public void setSkuDetailList(List<TbSkuDetail> skuDetailList) {
        this.skuDetailList = skuDetailList;
    }
}