package com.chaomeis.sparrowbeauty.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TbUserAccountChange {
    private Integer id;

    private String openId;

    private Integer apiUserId;

    private Integer cashDirection;

    private String cashAmount;

    private Integer tradingSource;

    private String tradingId;

    private String serialNo;

    private Date createTime;

    private Date updateTime;

}