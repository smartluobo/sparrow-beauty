package com.chaomeis.sparrowbeauty.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TbAddress {
    private Integer id;

    private String openId;

    private String consigneeName;

    private String consigneePhone;

    private String province;

    private String city;

    private String district;

    private String detailedAddress;

    private String shippingAddress;

    private Integer isDefault;

    private Date createTime;

    private Date updateTime;
}