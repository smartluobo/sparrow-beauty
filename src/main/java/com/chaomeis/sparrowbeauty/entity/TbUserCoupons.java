package com.chaomeis.sparrowbeauty.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TbUserCoupons {
    private Integer id;

    private String openId;

    private Integer couponsId;

    private String couponsName;

    private Integer receiveDate;

    private Date createTime;

    private Integer status;

    private String couponsPoster;

    private Date expireDate;

    private Integer isReferrer;

    private String couponsRatio;

    private String consumeAmount; // 消费金额

    private String reduceAmount; // 减免金额

    private Integer couponsType;

    private String useRules;

    private String useScope;

    private Integer couponsSource;

    private String sourceName;

    private Integer activityId;

    private Integer useWay;

    private Integer expireType;

    private String cashAmount;

    private Integer apiUserId;

}