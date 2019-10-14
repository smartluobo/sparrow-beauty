package com.chaomeis.sparrowbeauty.common;

public class SparrowBeautyConstant {
    //#######################################活动类型######################################################
    //活动类型 全场折扣
    public static final int ACTIVITY_TYPE_FULL_RATIO = 0;
    //活动类型 限时折扣
    public static final int ACTIVITY_TYPE_TIME_LIMIT = 1;

    //#######################################价格类型######################################################
    //价格类型 指定价格
    public static final int PRICE_TYPE_SPECIFIED = 0;
    //价格类型 折扣计算方式
    public static final int PRICE_TYPE_RATIO_CALCULATE = 1;

    //######################################新人礼包领取状态######################################################
    //新人礼包领取状态  未领取
    public static final int GIFT_BAG_RECEIVE_STATUS_NO = 0;
    //新人礼包领取状态 已领取
    public static final int GIFT_BAG_RECEIVE_STATUS_SUCCESS = 1;

    //#######################################是否是经销商######################################################
    //是否是经销商 不是
    public static final int IS_DEALER_NO = 0;
    //是否是经销商 是
    public static final int IS_DEALER_YES = 1;

    //#######################################佣金来源######################################################
    //佣金来源 一级分销佣金
    public static final int CONSUMER_SOURCE_FIRST = 0;
    //佣金来源 二级分销佣金
    public static final int CONSUMER_SOURCE_SECOND = 1;

    //#######################################优惠券类型######################################################
    //优惠券类型 折扣券
    public static final int COUPONS_TYPE_RATIO = 1;
    //优惠券类型 满减券
    public static final int COUPONS_TYPE_FULL_REDUCE = 2;
    //优惠券类型 团购券
    public static final int COUPONS_TYPE_GROUP = 3;

    //#######################################经销商等级条件逻辑关系######################################################
    //经销商等级条件逻辑关系 同时满足所有条件
    public static final int DEALER_LEVEL_CONDITION_ALL = 0;
    //经销商等级条件逻辑关系 满足其中一个条件
    public static final int DEALER_LEVEL_CONDITION_OR = 1;

    //#######################################商品上下架状态######################################################
    //商品上下架状态 下架
    public static final int GOODS_STATUS_ONLINE = 0;
    //商品上下架状态 商家
    public static final int GOODS_STATUS_OFFLINE = 1;

    //#######################################商品是否是试用装######################################################
    //商品是否是试用装 不是
    public static final int IS_TRIAL_NO = 0;
    //商品是否是试用装 是
    public static final int IS_TRIAL_YES = 1;

    //#######################################积分来源######################################################
    //积分来源 消费获得积分
    public static final int INTEGRAL_SOURCE_CONSUME = 0;
    //积分来源 活动赠送
    public static final int INTEGRAL_SOURCE_ACTIVITY_GIVE = 1;
    //积分来源 分享获得积分
    public static final int INTEGRAL_SOURCE_SHARE = 2;
    //积分来源 做任务
    public static final int INTEGRAL_SOURCE_TASK = 3;

    //#######################################支付渠道######################################################
    //支付渠道 微信支付
    public static final int PAYMENT_CHANNEL_WECHAT = 0;

    //#######################################订单状态######################################################
    //订单状态 未支付
    public static final int ORDER_STATUS_NO_PAY = 0;
    //订单状态 支付成功待发货
    public static final int ORDER_STATUS_PAY_SUCCESS = 1;
    //订单状态 已发货
    public static final int ORDER_STATUS_DELIVERED = 2;
    //订单状态 已签收
    public static final int ORDER_STATUS_SIGNED = 3;
    //订单状态 订单未支付超时关闭
    public static final int ORDER_STATUS_TIME_OUT_CLOSE = 4;
    //订单状态 订单取消
    public static final int ORDER_STATUS_CANCEL = 5;
    //订单状态 订单完成
    public static final int ORDER_STATUS_COMPLETE = 6;

    //#######################################现金方向######################################################
    //现金方向 流出 用户账户金额减少
    public static final int CASH_DIRECTION_OUT = 0;
    //现金方向 流入 用户账户金额增加
    public static final int CASH_DIRECTION_IN = 1;

    //#######################################账户变动交易来源######################################################
    //账户变动交易来源 提现
    public static final int ACCOUNT_CHANGE_TRADING_SOURCE_WITHDRAWAL = 0;
    //账户变动交易来源 佣金结算
    public static final int ACCOUNT_CHANGE_TRADING_SOURCE_COMMISSION = 1;

    //#######################################优惠券使用状态######################################################
    //优惠券使用状态 未使用
    public static final int COUPONS_STATUS_NO_USE = 0;
    //优惠券使用状态 锁定中
    public static final int COUPONS_STATUS_LOCKING = 1;
    //优惠券使用状态 已经使用
    public static final int COUPONS_STATUS_USED = 2;

    //#######################################用户优惠券来源######################################################
    //用户优惠券来源 幸运抽奖
    public static final int COUPONS_SOURCE_LUCKY_DRAW = 0;
    //用户优惠券来源 分享专属
    public static final int COUPONS_SOURCE_SHARE = 1;
    //用户优惠券来源 新人礼包
    public static final int COUPONS_SOURCE_USER_GIFT_BAG = 2;
    //用户优惠券来源 系统派发
    public static final int COUPONS_SOURCE_SYS = 3;

    //#######################################优惠券过期类型######################################################
    //优惠券过期类型 默认为过期日期过期
    public static final int COUPONS_EXPIRE_TYPE_DEFAULT = 0;
    //优惠券过期类型 当日有效
    public static final int COUPONS_EXPIRE_TYPE_SAME_DAY = 1;
    //优惠券过期类型 悠久有效
    public static final int COUPONS_EXPIRE_TYPE_FOREVER = 2;

    //#######################################支付记录支付状态######################################################
    //支付记录支付状态 新生成
    public static final int PAY_RECORD_STATUS_NEW = 0;
    //支付记录支付状态 支付成功
    public static final int PAY_RECORD_STATUS_SUCCESS = 1;
    //支付记录支付状态 支付失败
    public static final int PAY_RECORD_STATUS_FAIL = 2;
    //支付记录支付状态 超时关闭
    public static final int PAY_RECORD_STATUS_TIME_OUT_CLOSE = 3;


    //#######################################提现状态######################################################
    //提现状态 用户提交
    public static final int WITHDRAWAL_STATUS_USER_COMMIT = 0;
    //提现状态 支付成功
    public static final int WITHDRAWAL_STATUS_AUDIT_PASS = 1;
    //提现状态 支付失败
    public static final int WITHDRAWAL_STATUS_AUDIT_FAIL = 2;
    //提现状态 超时关闭
    public static final int WITHDRAWAL_STATUS_COMPLETE = 3;









}
