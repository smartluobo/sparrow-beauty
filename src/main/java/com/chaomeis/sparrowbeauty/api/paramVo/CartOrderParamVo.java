package com.chaomeis.sparrowbeauty.api.paramVo;


import lombok.Data;

@Data
public class CartOrderParamVo {

    private String openId;
    private String cartItemIds;
    private int userCouponsId;
    private int addressId;
    private int selfGet;
    private int storeId;
    private String orderId;
    private String buyerMessage;




}
