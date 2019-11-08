package com.chaomeis.sparrowbeauty.api.service.calculate;

import com.chaomeis.sparrowbeauty.api.paramVo.GoodsVO;
import com.chaomeis.sparrowbeauty.api.paramVo.CartOrderParamVo;
import com.chaomeis.sparrowbeauty.api.paramVo.GoodsParamVO;
import com.chaomeis.sparrowbeauty.api.responseVo.CalculateGoodsReturnVO;
import com.chaomeis.sparrowbeauty.api.responseVo.CalculateReturnVo;
import com.chaomeis.sparrowbeauty.entity.*;
import com.chaomeis.sparrowbeauty.mapper.*;
import com.chaomeis.sparrowbeauty.utils.NumberUtil;
import com.sun.org.apache.regexp.internal.RE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CalculateService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculateService.class);
    @Resource
    private TbGoodsMapper tbGoodsMapper;
    @Resource
    private TbSkuDetailMapper tbSkuDetailMapper;
    @Resource
    private TbActivityMapper tbActivityMapper;
    @Resource
    private TbActivityGoodsMapper tbActivityGoodsMapper;
    @Resource
    private TbUserCouponsMapper tbUserCouponsMapper;
    @Resource
    private  TbCartMapper tbCartMapper;
    /**
     * 结算订单价格
     * @param goodsParamVO 创建订单的参数
     * @return 返回订单价格对象 返回对象待定义
     */
    public CalculateReturnVo calculateCartGoodsPrice(GoodsParamVO goodsParamVO){
        // 商品总支付金额
        BigDecimal goodsPayAmount = new BigDecimal("0");
        // 商品总金额
        BigDecimal goodsTotalAmount = new BigDecimal("0");
        // 优惠券金额
        BigDecimal goodsReduceAmount = new BigDecimal("0");
        GoodsVO goods = goodsParamVO.getGoods();
        TbGoods tbGoods = tbGoodsMapper.selectByPrimaryKey(goods.getGoodsId());
        String goodsPrice = tbGoods.getGoodsPrice();
        BigDecimal bidGoodsPrice = new BigDecimal(goodsPrice);
        BigDecimal goodsCount = new BigDecimal(goods.getGoodsCount()); // 商品数量
        // 商品原价
        BigDecimal originalPrice = bidGoodsPrice.multiply(goodsCount);
        // 活动优惠价格
        BigDecimal activityPrice = this.calculateActivityPrice(goodsParamVO.getGoods().getGoodsId(), goodsParamVO.getGoods().getGoodsCount());
        // 券优惠价格c
        BigDecimal couponsPrice = this.calculateCouponsPrice(goodsPayAmount, goodsParamVO.getUserCouponsId(), goodsParamVO.getOpenId());
        // sku价格
        BigDecimal skuPrice = new BigDecimal("0");
        if(!CollectionUtils.isEmpty(goods.getSkuDetailIdList())) {
            BigDecimal bigSkuDetailPrice= new BigDecimal ("0");
            for (int skuTypeId: goods.getSkuDetailIdList()) {
                // sku价格
                bigSkuDetailPrice = calculateSkuprice(skuTypeId);
                bigSkuDetailPrice = bigSkuDetailPrice.add(bigSkuDetailPrice);
            }
            skuPrice = bigSkuDetailPrice;
        }
        // 支付价格
        goodsPayAmount = originalPrice.subtract(activityPrice).subtract(couponsPrice).add(skuPrice);
        // 总金额
        goodsTotalAmount = originalPrice;
        // 优惠金额
        goodsReduceAmount = activityPrice.add(couponsPrice);

        CalculateReturnVo calculateReturn = new CalculateReturnVo();
        calculateReturn.setOrderTotalAmount(goodsTotalAmount.toString());
        calculateReturn.setOrderPayAmount(goodsPayAmount.toString());
        calculateReturn.setOrderReduceAmount(goodsReduceAmount.toString());
        // 订单邮费
        // 商品金额
        return calculateReturn;
    }
    public CalculateReturnVo calculateCartOrderPrice(CartOrderParamVo cartOrderParamVo){
        List<String> cartIdList = Arrays.asList(cartOrderParamVo.getCartItemIds().split(","));;
        // 商品总支付金额
        BigDecimal goodsPayAmount = new BigDecimal("0");
        // 商品总金额
        BigDecimal goodsTotalAmount = new BigDecimal("0");
        // 优惠券金额
        BigDecimal goodsReduceAmount = new BigDecimal("0");

        for (String cartId : cartIdList) {
            TbCart tbCart = tbCartMapper.selectByPrimaryKey(Integer.valueOf(cartId)); // 购物车信息
            TbGoods tbGoods = tbGoodsMapper.selectByPrimaryKey(tbCart.getGoodsId());
            String goodsPrice = tbGoods.getGoodsPrice();
            BigDecimal bidGoodsPrice = new BigDecimal(goodsPrice);
            BigDecimal goodsCount = new BigDecimal(tbCart.getGoodsCount()); // 商品数量
            // 商品原价
            goodsPayAmount = bidGoodsPrice.multiply(goodsCount);
            goodsTotalAmount = goodsPayAmount;

            // 计算活动价格
            TbActivity tbActivity= tbActivityMapper.selectValidActivityy();
            if (null != tbActivity) {
                if ("0".equals(tbActivity.getActivityType())) { // 全场折扣
                    BigDecimal ratio = new BigDecimal(tbActivity.getActivityRatio());
                    BigDecimal ratioyAmount = goodsPayAmount.multiply(ratio); // 折扣价格
                    goodsReduceAmount = goodsPayAmount.subtract(ratioyAmount); // 减免金额
                    goodsPayAmount = ratioyAmount; // 支付金额
                } else if ("1".equals(tbActivity.getActivityType())) { // 限时活动
                    // 限时活动时，查询商品是否在当前活动中
                    TbActivityGoods record = new TbActivityGoods();
                    record.setGoodsId(tbGoods.getId());
                    record.setActivityId(tbActivity.getId());
                    TbActivityGoods tbActivityGoods = tbActivityGoodsMapper.selectActivityGoods(record);
                    if (0 == tbActivityGoods.getPriceType()) { // 指定价格活动
                        BigDecimal activitAmount =  new BigDecimal(tbActivityGoods.getActivitPrice()).multiply(goodsCount); // 活动价格
                        goodsReduceAmount = goodsPayAmount.subtract(activitAmount); // 减免金额
                        goodsPayAmount = activitAmount; // 支付金额
                    } else if (1 == tbActivityGoods.getPriceType()) { // 折扣价格活动
                        BigDecimal ratio = new BigDecimal(tbActivityGoods.getActivityRatio());
                        BigDecimal ratioyAmount = goodsPayAmount.multiply(ratio); // 折扣价格
                        goodsReduceAmount =  goodsPayAmount.subtract(ratioyAmount); // 减免金额
                        goodsPayAmount = ratioyAmount; // 支付金额
                    }
                }
            }
        }

        // 代金券
        if (cartOrderParamVo.getUserCouponsId() > 0) {
            TbUserCoupons record = new TbUserCoupons();
            record.setOpenId(cartOrderParamVo.getOpenId());
            record.setId(cartOrderParamVo.getUserCouponsId());
            TbUserCoupons userCoupons = tbUserCouponsMapper.selectUserCoupons(record);
            if (1 == userCoupons.getCouponsType()) { // 折扣券
                BigDecimal ratio = new BigDecimal(userCoupons.getCouponsRatio());
                BigDecimal ratioyAmount = goodsPayAmount.multiply(ratio); // 折扣后价格
                goodsReduceAmount =  goodsPayAmount.subtract(ratioyAmount).add(goodsReduceAmount); // 减免金额
                goodsPayAmount = ratioyAmount; // 支付金额
            } else if (2 ==userCoupons.getCouponsType()) { // 满减券
                BigDecimal consumeAmount = new BigDecimal(userCoupons.getConsumeAmount()); // 消费金额
                int compareValue = goodsPayAmount.compareTo(consumeAmount);
                if (compareValue >= 0) { // 商品金额大于券消费金额满足活动
                    BigDecimal reduceAmount = new BigDecimal(userCoupons.getReduceAmount());
                    goodsPayAmount = goodsPayAmount.subtract(reduceAmount);
                    goodsReduceAmount = reduceAmount.add(goodsReduceAmount);
                }
            }
        }
        // sku价格
        for (String cartId : cartIdList) {
            TbCart tbCart = tbCartMapper.selectByPrimaryKey(Integer.valueOf(cartId)); // 购物车信息
            String skuDeList = tbCart.getSkuDetailIds();
            List<String> skuId = new ArrayList<>();
            if (!StringUtils.isEmpty(skuDeList)) {
                skuId = Arrays.asList(skuDeList.split(","));
            }
            for (String skuTypeId: skuId) {
                // 商品sku
                TbSkuDetail skuList = tbSkuDetailMapper.selectByPrimaryKey(Integer.valueOf(skuTypeId));
                BigDecimal goodsCount = new BigDecimal(tbCart.getGoodsCount());
                BigDecimal bigSkuDetailPrice = new BigDecimal(skuList.getSkuDetailPrice()).multiply(goodsCount);
                goodsPayAmount = goodsPayAmount.add(bigSkuDetailPrice); // 支付金额
                goodsTotalAmount = goodsTotalAmount.add(bigSkuDetailPrice); // 总价格
            }
        }
        CalculateReturnVo calculateReturn = new CalculateReturnVo();
        calculateReturn.setOrderTotalAmount(goodsTotalAmount.toString()); // 总金额
        calculateReturn.setOrderPayAmount(goodsPayAmount.toString()); // 支付金额
        calculateReturn.setOrderReduceAmount(goodsReduceAmount.toString()); // 减免金额
        // 订单邮费
        // 商品金额
        return calculateReturn;
    }

    /**
     * 计算活动优惠价格
     * @param goodsId
     * @param goodsCount
     * @return
     */
    public  BigDecimal calculateActivityPrice (Integer goodsId, Integer goodsCount) {
            // 活动优惠金额
            BigDecimal activityReduceAmount = new BigDecimal("0");
            TbGoods tbGoods = tbGoodsMapper.selectByPrimaryKey(goodsId);
            String goodsPrice = tbGoods.getGoodsPrice();
            BigDecimal bidGoodsPrice = new BigDecimal(goodsPrice);
            BigDecimal count = new BigDecimal(String.valueOf(goodsCount)); // 商品数量
            // 商品总金额
            BigDecimal totalAmount = bidGoodsPrice.multiply(count);
            // 计算活动价格
            TbActivity tbActivity= tbActivityMapper.selectValidActivityy();
            if (null != tbActivity) {
                if ("0".equals(tbActivity.getActivityType())) { // 全场折扣
                    BigDecimal ratio = new BigDecimal(tbActivity.getActivityRatio());
                    BigDecimal ratioyAmount = totalAmount.multiply(ratio); // 折扣价格
                    activityReduceAmount = totalAmount.subtract(ratioyAmount); // 减免金额
                } else if ("1".equals(tbActivity.getActivityType())) { // 限时活动
                    // 限时活动时，查询商品是否在当前活动中
                    TbActivityGoods record = new TbActivityGoods();
                    record.setGoodsId(goodsId);
                    record.setActivityId(tbActivity.getId());
                    TbActivityGoods tbActivityGoods = tbActivityGoodsMapper.selectActivityGoods(record);
                    if (0 == tbActivityGoods.getPriceType()) { // 指定价格活动
                        BigDecimal activitAmount =  new BigDecimal(tbActivityGoods.getActivitPrice()).multiply(count); // 活动价格
                        activityReduceAmount = totalAmount.subtract(activitAmount); // 减免金额
                    } else if (1 == tbActivityGoods.getPriceType()) { // 折扣价格活动
                        BigDecimal ratio = new BigDecimal(tbActivityGoods.getActivityRatio());
                        BigDecimal ratioyAmount = totalAmount.multiply(ratio); // 折扣价格
                        activityReduceAmount =  totalAmount.subtract(ratioyAmount); // 减免金额
                    }
                }
            }
        return activityReduceAmount;
    }

    /**
     * 计算券优惠价格
     * @param userCouponsId
     */
    public BigDecimal calculateCouponsPrice (BigDecimal goodsPayAmount, Integer userCouponsId, String openId) {
        // 优惠券金额
        BigDecimal couponsReduceAmount = new BigDecimal("0");
        // 代金券
        if (null != userCouponsId) {
            TbUserCoupons record = new TbUserCoupons();
            record.setOpenId(openId);
            record.setId(userCouponsId);
            TbUserCoupons userCoupons = tbUserCouponsMapper.selectUserCoupons(record);
            if (1 == userCoupons.getCouponsType()) { // 折扣券
                BigDecimal ratio = new BigDecimal(userCoupons.getCouponsRatio());
                BigDecimal ratioyAmount = goodsPayAmount.multiply(ratio); // 折扣后价格
                couponsReduceAmount =  goodsPayAmount.subtract(ratioyAmount); // 减免金额
            } else if (2 ==userCoupons.getCouponsType()) { // 满减券
                BigDecimal consumeAmount = new BigDecimal(userCoupons.getConsumeAmount()); // 消费金额
                int compareValue = goodsPayAmount.compareTo(consumeAmount);
                if (compareValue >= 0) { // 商品金额大于券消费金额满足活动
                    BigDecimal reduceAmount = new BigDecimal(userCoupons.getReduceAmount());
                    couponsReduceAmount = goodsPayAmount.subtract(reduceAmount);
                }
            }
        }
        return couponsReduceAmount;
    }

    /**
     * 商品sku价格
     * @param skuId
     * @return
     */
    public BigDecimal calculateSkuprice (Integer skuId) {
        // 商品sku
        TbSkuDetail skuPrice = tbSkuDetailMapper.selectByPrimaryKey(skuId);
        // sku金额
        BigDecimal bigSkuDetailPrice = new BigDecimal(skuPrice.getSkuDetailPrice());
        return bigSkuDetailPrice;
    }
}
