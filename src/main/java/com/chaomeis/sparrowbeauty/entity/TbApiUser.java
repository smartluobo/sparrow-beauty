package com.chaomeis.sparrowbeauty.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TbApiUser {
    private int id;

    private String nickName;

    private String wechatNum;

    private String openId;

    private String wechatPhoneNum;

    private String userBindPhoneNum;

    private Date createTime;

    private Date updateTime;

    private String userHeadImage;

    private String referrerOpenId;

    private int giftReceiveStatus;
    //是否是经销商 0 不是 1 是
    private int isDealer;

}