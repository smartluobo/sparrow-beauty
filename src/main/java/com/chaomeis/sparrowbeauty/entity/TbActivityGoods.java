package com.chaomeis.sparrowbeauty.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TbActivityGoods {
    private int id;

    private Integer activityId;

    private String activityName;

    private Integer goodsId;

    private String goodsName;

    private int priceType;

    private String activityPrice;

    private String activityRatio;

    private Date createTime;

    private Date updateTime;

    private int cmsUserId;

    private String cmsUserName;
}