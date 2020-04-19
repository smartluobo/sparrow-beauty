package com.chaomeis.sparrowbeauty.api.paramVo;


import lombok.Data;

import java.util.List;

/**
 * 生成订单
 */
@Data
public class GoodsParamVO {
    // 订单id
    private String orderId;
    // 微信用户id
    private String openId;
    // 优惠券id
    private int userCouponsId;

    private int addressId;

    private String buyerMessage;

    private int goodsId;

    private List<Integer> skuDetailIdList;

    private  int logisticsId;

    private int goodsCount;

}
