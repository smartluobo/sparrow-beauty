package com.chaomeis.sparrowbeauty.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TbIntegralRecord {
    private Integer id;

    private String openId;

    private Integer integralSource;

    private String tradingId;

    private Date createTime;

    private Date expireTime;

    private Integer integralAmount;

    private Integer apiUserId;

    private String integralId;

}