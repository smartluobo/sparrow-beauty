package com.chaomeis.sparrowbeauty.api.paramVo;

import java.util.List;

public class GoodsVO {
    // 商品id
    private int goodsId;
    // 商品数量
    private int goodsCount;
    // 商品sku集合
    private List<Integer>  skuDetailIdList;

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public List<Integer> getSkuDetailIdList() {
        return skuDetailIdList;
    }

    public void setSkuDetailIdList(List<Integer> skuDetailIdList) {
        this.skuDetailIdList = skuDetailIdList;
    }
}
