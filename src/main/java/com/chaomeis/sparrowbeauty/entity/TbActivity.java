package com.chaomeis.sparrowbeauty.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TbActivity {
    private Integer id;

    private String activityName;

    private String activityType; // 0 全场折扣 1 限时活动

    private Date startDate;

    private Date endDate;

    private Integer startHour;

    private Integer endHour;

    private String activityPoster;

    private Date createTime;

    private Date updateTime;

    private String activityRatio;

    private Integer cmsUserId;

    private String cmsUserName;
    /*折扣比例*/
    private String couponsRatio;
    /*减免金额*/
    private String reduceAmount;
    /*活动对应的商品*/
    private List<TbGoods> goodsList;
}