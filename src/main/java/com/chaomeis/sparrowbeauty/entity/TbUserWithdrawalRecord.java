package com.chaomeis.sparrowbeauty.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TbUserWithdrawalRecord {
    private Integer id;

    private String openId;

    private Integer apiUserId;

    private String withdrawalAmount;

    private Integer withdrawalStatus;

    private Integer auditorId;

    private String auditorName;

    private Date auditTime;

    private String auditRemark;

    private Date createTime;

    private Date updateTime;

    private String serialNo;

}