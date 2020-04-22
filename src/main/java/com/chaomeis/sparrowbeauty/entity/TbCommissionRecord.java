package com.chaomeis.sparrowbeauty.entity;

import lombok.Data;

import java.util.Date;
@Data
public class TbCommissionRecord {
    private Integer id;

    private String openId;

    private String tradingId;

    private String tradingAmount;

    private String consumerOpenId;

    private String commissionRatio;

    private Integer settlementStatus;

    private Date createTime;

    private Date updateTime;

    private Integer consumerSource;

    private String serialNo;

    private Integer apiUserId;

    private String commissionAmount;

}