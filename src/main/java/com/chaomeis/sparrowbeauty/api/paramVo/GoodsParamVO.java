package com.chaomeis.sparrowbeauty.api.paramVo;

import java.util.List;

/**
 * 生成订单
 */
public class GoodsParamVO {
    // 订单id
    private String orderId;
    // 微信用户id
    private String openId;
    // 商品集合
    private GoodsVO goods;
    // 优惠券id
    private Integer userCouponsId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public GoodsVO getGoods() {
        return goods;
    }

    public void setGoods(GoodsVO goods) {
        this.goods = goods;
    }

    public Integer getUserCouponsId() {
        return userCouponsId;
    }

    public void setUserCouponsId(Integer userCouponsId) {
        this.userCouponsId = userCouponsId;
    }
}
