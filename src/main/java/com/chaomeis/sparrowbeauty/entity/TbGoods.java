package com.chaomeis.sparrowbeauty.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TbGoods {
    private int id;

    private String goodsName;

    private String sellingPoint;

    private String goodsPrice;

    private String goodsInventory;

    private int goodsStatus;

    private String goodsPosters;

    private String goodsCarouselImages;

    private String goodsDetailImages;

    private List<String> goodsDetailImagesList;
    private int isTrial;

    private String skuTypeIds;

    private String defaultSkuDetailIds;

    private String simpleDesc;

    private Date createTime;

    private Date updateTime;

    private int cmsUserId;

    private String cmsUserName;

    private List<TbSkuType> skuTypeList;

    private int commissionType;

    private String commissionAmount;

    private int buyLimit;

    private int receiveFlag;
}
