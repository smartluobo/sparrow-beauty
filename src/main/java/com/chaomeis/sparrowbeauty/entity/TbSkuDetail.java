package com.chaomeis.sparrowbeauty.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TbSkuDetail {
    private Integer id;

    private Integer skuTypeId;

    private String skuDetailName;

    private String skuDetailPrice;

    private String cmsView;

    private String remark;

    private Integer cmsUserId;

    private String cmsUserName;

    private Date createTime;

    private Date updateTime;

    // 是否选中 0 未选中 1选中
    private int isSelect ;

}