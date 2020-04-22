package com.chaomeis.sparrowbeauty.entity;

import lombok.Data;

@Data
public class TbOrderDetail {
    private Integer id;

    private String orderId;

    private int goodsId;

    private String skuTypeIds;

    private String defaultSkuDetailIds;

    private int goodsNum;

    private String goodsName;

    private String goodsPrice;

    private String goodsTotalAmount;

    private String skuDetailDesc;
}