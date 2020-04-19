package com.chaomeis.sparrowbeauty.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TbOrder {
    private String orderId;

    private String orderName;

    private String orderAmount;

    private String paymentAmount;

    private Integer paymentChannel;

    private Integer orderStatus;

    private String orderPostageAmount;

    private String goodsAmount;

    private String couponsReduceAmount;

    private Date paymentTime;

    private Date deliveryTime;

    private String logisticsName;

    private String logisticsCode;

    private Integer apiUserId;

    private String apiUserMessage;

    private String apiUserNick;

    private String openId;

    private String address;

    private String phoneNum;

    private String posterUrl;

    private String goodsTotalCount;

    private Integer apiUserCouponsId;

    private String apiUserCouponsName;

    private Integer apiUserAddressId;

    private Integer isFirstOrder;

    private Date createTime;

    private Date updateTime;

    private String createDateStr;

    private List<TbOrderDetail> orderDetails;

    private String userBindPhone;


}
