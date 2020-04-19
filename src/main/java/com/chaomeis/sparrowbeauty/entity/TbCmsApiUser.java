package com.chaomeis.sparrowbeauty.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TbCmsApiUser {
    private Integer id;

    private String nickName;

    private String wechatNum;

    private String openId;

    private String wechatPhoneNum;

    private String userBindPhoneNum;

    private Date createTime;

    private Date updateTime;

    private String userHeadImage;

    private String referrerOpenId;

    private Integer giftReceiveStatus;

    private Integer isDealer;

    private Integer dealerLevelId;

}
