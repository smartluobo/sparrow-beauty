package com.chaomeis.sparrowbeauty.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class TbSkuType {
    private Integer id;

    private String skuTypeName;

    private String remark;

    private Integer cmsUserId;

    private String cmsUserName;

    private Date createTime;

    private Date updateTime;

    private String cmsView;

    private List<TbSkuDetail> skuDetailList;

}