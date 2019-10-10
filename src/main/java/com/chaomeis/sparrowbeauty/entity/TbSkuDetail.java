package com.chaomeis.sparrowbeauty.entity;

import java.util.Date;

public class TbSkuDetail {
    private Integer id;

    private Integer skuTypeId;

    private String skuDetailName;

    private String skuDetailPrice;

    private String cmsView;

    private String remark;

    private Integer cmsUserId;

    private String cmsUserName;

    private Date createTime;

    private Date updateTime;

    // 是否选中 0 未选中 1选中
    private int isSelect ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSkuTypeId() {
        return skuTypeId;
    }

    public void setSkuTypeId(Integer skuTypeId) {
        this.skuTypeId = skuTypeId;
    }

    public String getSkuDetailName() {
        return skuDetailName;
    }

    public void setSkuDetailName(String skuDetailName) {
        this.skuDetailName = skuDetailName == null ? null : skuDetailName.trim();
    }

    public String getSkuDetailPrice() {
        return skuDetailPrice;
    }

    public void setSkuDetailPrice(String skuDetailPrice) {
        this.skuDetailPrice = skuDetailPrice == null ? null : skuDetailPrice.trim();
    }

    public String getCmsView() {
        return cmsView;
    }

    public void setCmsView(String cmsView) {
        this.cmsView = cmsView == null ? null : cmsView.trim();
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

    public int getIsSelect() {
        return isSelect;
    }

    public void setIsSelect(int isSelect) {
        this.isSelect = isSelect;
    }
}