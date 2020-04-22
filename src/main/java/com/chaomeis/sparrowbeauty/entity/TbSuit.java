package com.chaomeis.sparrowbeauty.entity;

import lombok.Data;

import java.util.Date;

@Data
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

}