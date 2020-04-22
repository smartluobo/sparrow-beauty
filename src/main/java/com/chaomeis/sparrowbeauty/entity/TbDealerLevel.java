package com.chaomeis.sparrowbeauty.entity;

import lombok.Data;

import java.util.Date;

@Data
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

}