package com.chaomeis.sparrowbeauty.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TbCoupons {
    private Integer id;

    private Integer couponsType;

    private String couponsName;

    private String couponsRatio;

    private Integer consumeAmount;

    private Integer reduceAmount;

    private Integer consumeCount;

    private Integer giveCount;

    private Date createTime;

    private Date updateTime;

    private String couponsPoster;

    private String useRules;

    private String useScope;

    private String couponsListPoster;

}
