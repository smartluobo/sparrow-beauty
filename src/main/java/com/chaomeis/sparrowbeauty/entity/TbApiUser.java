package com.chaomeis.sparrowbeauty.entity;

import java.util.Date;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getWechatNum() {
        return wechatNum;
    }

    public void setWechatNum(String wechatNum) {
        this.wechatNum = wechatNum == null ? null : wechatNum.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getWechatPhoneNum() {
        return wechatPhoneNum;
    }

    public void setWechatPhoneNum(String wechatPhoneNum) {
        this.wechatPhoneNum = wechatPhoneNum == null ? null : wechatPhoneNum.trim();
    }

    public String getUserBindPhoneNum() {
        return userBindPhoneNum;
    }

    public void setUserBindPhoneNum(String userBindPhoneNum) {
        this.userBindPhoneNum = userBindPhoneNum == null ? null : userBindPhoneNum.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUserHeadImage() {
        return userHeadImage;
    }

    public void setUserHeadImage(String userHeadImage) {
        this.userHeadImage = userHeadImage == null ? null : userHeadImage.trim();
    }

    public String getReferrerOpenId() {
        return referrerOpenId;
    }

    public void setReferrerOpenId(String referrerOpenId) {
        this.referrerOpenId = referrerOpenId == null ? null : referrerOpenId.trim();
    }

    public int getGiftReceiveStatus() {
        return giftReceiveStatus;
    }

    public void setGiftReceiveStatus(int giftReceiveStatus) {
        this.giftReceiveStatus = giftReceiveStatus;
    }

    public int getIsDealer() {
        return isDealer;
    }

    public void setIsDealer(int isDealer) {
        this.isDealer = isDealer;
    }
}