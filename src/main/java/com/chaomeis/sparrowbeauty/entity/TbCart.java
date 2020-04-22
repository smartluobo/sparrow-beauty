package com.chaomeis.sparrowbeauty.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TbCart {
    private int id;

    private String oppenId;

    private int goodsId;

    private Double showPrice;

    private String skuDetailIds;

    private Date createTime;

    private int goodsCount;

    private String skuDetailDesc;

}