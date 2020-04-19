package com.chaomeis.sparrowbeauty.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TbUserPayRecord {
    private int id;

    private int apiUserId;

    private String openId;

    private String orderId;

    private String orderAmount;

    private String paymentAmount;

    private String nonceStr;

    private String prepayId;

    private int payStatus;

    private String transactionId;

    private Date createTime;

    private Date updateTime;

    private String businessId;
}
