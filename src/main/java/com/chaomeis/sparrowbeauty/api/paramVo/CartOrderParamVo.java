package com.chaomeis.sparrowbeauty.api.paramVo;

import java.util.List;

public class CartOrderParamVo {

    private String openId;
    private String cartItemIds;
    private int userCouponsId;
    private int addressId;
    private int selfGet;
    private int storeId;
    private String orderId;
    private String buyerMessage;


    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getCartItemIds() {
        return cartItemIds;
    }

    public void setCartItemIds(String cartItemIds) {
        this.cartItemIds = cartItemIds;
    }

    public int getUserCouponsId() {
        return userCouponsId;
    }

    public void setUserCouponsId(int userCouponsId) {
        this.userCouponsId = userCouponsId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getSelfGet() {
        return selfGet;
    }

    public void setSelfGet(int selfGet) {
        this.selfGet = selfGet;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBuyerMessage() {
        return buyerMessage;
    }

    public void setBuyerMessage(String buyerMessage) {
        this.buyerMessage = buyerMessage;
    }

}
