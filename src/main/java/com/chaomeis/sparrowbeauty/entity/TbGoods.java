package com.chaomeis.sparrowbeauty.entity;

import java.util.Date;
import java.util.List;

public class TbGoods {
    private int id;
    //商品名称
    private String goodsName;
    //商品卖点
    private String sellingPoint;
    //商品价格
    private String goodsPrice;
    //商品库存
    private String goodsInventory;
    //商品状态 0下架 1上架
    private int goodsStatus;
    //商品封面
    private String goodsPoster;
    //商品详情页轮播图片
    private String goodsCarouselImage;
    //商品详情图片
    private String goodsDetailImages;
    //是否未赠品
    private int isTrial;
    //商品sku类型
    private String skuTypeIds;
    //默认商品skuDetailId
    private String defaultSkuDetailIds;
    //简单描述
    private String simpleDesc;

    private Date createTime;

    private Date updateTime;
    //创建者id
    private int cmsUserId;
    //创建者姓名
    private String cmsUserName;

    private List<TbSkuType> skuTypeList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getSellingPoint() {
        return sellingPoint;
    }

    public void setSellingPoint(String sellingPoint) {
        this.sellingPoint = sellingPoint == null ? null : sellingPoint.trim();
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice == null ? null : goodsPrice.trim();
    }

    public String getGoodsInventory() {
        return goodsInventory;
    }

    public void setGoodsInventory(String goodsInventory) {
        this.goodsInventory = goodsInventory == null ? null : goodsInventory.trim();
    }

    public int getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(int goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public String getGoodsPoster() {
        return goodsPoster;
    }

    public void setGoodsPoster(String goodsPoster) {
        this.goodsPoster = goodsPoster == null ? null : goodsPoster.trim();
    }

    public String getGoodsCarouselImage() {
        return goodsCarouselImage;
    }

    public void setGoodsCarouselImage(String goodsCarouselImage) {
        this.goodsCarouselImage = goodsCarouselImage == null ? null : goodsCarouselImage.trim();
    }

    public String getGoodsDetailImages() {
        return goodsDetailImages;
    }

    public void setGoodsDetailImages(String goodsDetailImages) {
        this.goodsDetailImages = goodsDetailImages == null ? null : goodsDetailImages.trim();
    }

    public int getIsTrial() {
        return isTrial;
    }

    public void setIsTrial(int isTrial) {
        this.isTrial = isTrial;
    }

    public String getSkuTypeIds() {
        return skuTypeIds;
    }

    public void setSkuTypeIds(String skuTypeIds) {
        this.skuTypeIds = skuTypeIds == null ? null : skuTypeIds.trim();
    }

    public String getDefaultSkuDetailIds() {
        return defaultSkuDetailIds;
    }

    public void setDefaultSkuDetailIds(String defaultSkuDetailIds) {
        this.defaultSkuDetailIds = defaultSkuDetailIds == null ? null : defaultSkuDetailIds.trim();
    }

    public String getSimpleDesc() {
        return simpleDesc;
    }

    public void setSimpleDesc(String simpleDesc) {
        this.simpleDesc = simpleDesc == null ? null : simpleDesc.trim();
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

    public List<TbSkuType> getSkuTypeList() {
        return skuTypeList;
    }

    public void setSkuTypeList(List<TbSkuType> skuTypeList) {
        this.skuTypeList = skuTypeList;
    }
}