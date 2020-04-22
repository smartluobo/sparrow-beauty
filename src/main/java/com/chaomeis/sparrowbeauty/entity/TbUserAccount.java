package com.chaomeis.sparrowbeauty.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TbUserAccount {
    private Integer id;

    private String openId;

    private Integer apiUserId;

    private String totalAmount;

    private String remainingAmount;

    private String withdrawalingAmount;

    private Date createTime;

    private Date updateTime;

    private String freezeAmount;

}