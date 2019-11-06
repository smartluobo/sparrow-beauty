package com.chaomeis.sparrowbeauty.api.service.calculate;

import com.chaomeis.sparrowbeauty.api.paramVo.GoodsVO;
import com.chaomeis.sparrowbeauty.api.paramVo.CartOrderParamVo;
import com.chaomeis.sparrowbeauty.api.paramVo.GoodsParamVO;
import com.chaomeis.sparrowbeauty.api.responseVo.CalculateGoodsReturnVO;
import com.chaomeis.sparrowbeauty.api.responseVo.CalculateReturnVo;
import com.chaomeis.sparrowbeauty.entity.*;
import com.chaomeis.sparrowbeauty.mapper.*;
import com.chaomeis.sparrowbeauty.utils.NumberUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import javax.annotation.Resource;
import java.math.BigDecimal;

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
    /**
     * 结算订单价格
     * @param goodsParamVO 创建订单的参数
     * @return 返回订单价格对象 返回对象待定义
     */
    public CalculateGoodsReturnVO calculateCartGoodsPrice(GoodsParamVO goodsParamVO){
        // 商品总金额=(商品金额+sku价格)x数量
        BigDecimal goodsTotalAmount = new BigDecimal("0");
        GoodsVO goods = goodsParamVO.getGoods();
        TbGoods tbGoods = tbGoodsMapper.selectByPrimaryKey(goods.getGoodsId());
        String goodsPrice = tbGoods.getGoodsPrice();
        BigDecimal bidGoodsPrice = new BigDecimal(goodsPrice);
        BigDecimal goodsCount = new BigDecimal(goods.getGoodsCount()); // 商品数量
        // 商品原价
        goodsTotalAmount = bidGoodsPrice.multiply(goodsCount);

        // 计算活动价格
        TbActivity tbActivity= tbActivityMapper.selectValidActivityy();
        if (null != tbActivity) {
            if ("0".equals(tbActivity.getActivityType())) { // 全场折扣
                BigDecimal ratio = new BigDecimal(tbActivity.getActivityRatio());
                goodsTotalAmount = goodsTotalAmount.multiply(ratio).multiply(goodsCount); // 折扣后价格
            } else if ("1".equals(tbActivity.getActivityType())) { // 限时活动
                // 限时活动时，查询商品是否在当前活动中
                TbActivityGoods record = new TbActivityGoods();
                record.setGoodsId(goods.getGoodsId());
                record.setActivityId(tbActivity.getId());
                TbActivityGoods tbActivityGoods = tbActivityGoodsMapper.selectActivityGoods(record);
                if ("0".equals(tbActivityGoods.getPriceType())) { // 指定价格活动
                    goodsTotalAmount =  new BigDecimal(tbActivityGoods.getActivitPrice());
                } else if ("1".equals(tbActivityGoods.getPriceType())) { // 折扣价格活动
                    BigDecimal ratio = new BigDecimal(tbActivityGoods.getActivityRatio());
                    goodsTotalAmount = goodsTotalAmount.multiply(ratio).multiply(goodsCount); // 折扣后价格
                }
            }
        }

        // sku价格
       if(!CollectionUtils.isEmpty(goods.getSkuDetailIdList())) {
           for (int skuTypeId: goods.getSkuDetailIdList()) {
               // 商品sku
               TbSkuDetail skuList = tbSkuDetailMapper.selectByPrimaryKey(skuTypeId);
               BigDecimal bigSkuDetailPrice = new BigDecimal(skuList.getSkuDetailPrice());
               goodsTotalAmount = goodsTotalAmount.add(bigSkuDetailPrice); // 单件sku价格
               goodsTotalAmount = goodsTotalAmount.multiply(goodsCount); // 商品数量
           }
       }

        // 代金券
        if (null != goodsParamVO.getUserCouponsId()) {
            TbUserCoupons record = new TbUserCoupons();
            record.setOpenId(goodsParamVO.getOpenId());
            record.setId(goodsParamVO.getUserCouponsId());
            TbUserCoupons userCoupons = tbUserCouponsMapper.selectUserCoupons(record);
            if ("1".equals(userCoupons.getCouponsType())) { // 折扣券
                BigDecimal ratio = new BigDecimal(userCoupons.getCouponsRatio());
                goodsTotalAmount = goodsTotalAmount.multiply(ratio); // 折扣后价格
            } else if ("2".equals(userCoupons.getCouponsType())) { // 满减券
                BigDecimal consumeAmount = new BigDecimal(userCoupons.getConsumeAmount()); // 消费金额
                int compareValue = goodsTotalAmount.compareTo(consumeAmount);
                if (compareValue >= 0) { // 商品金额大于券消费金额满足活动
                    BigDecimal reduceAmount = new BigDecimal(userCoupons.getReduceAmount());
                    goodsTotalAmount = goodsTotalAmount.subtract(reduceAmount);
                }
            }
        }

        CalculateGoodsReturnVO calculateReturn = new CalculateGoodsReturnVO();
        calculateReturn.setGoodsTotalAmount(goodsTotalAmount.toString());
        // 订单邮费

        // 商品金额

        return calculateReturn;
    }
    public CalculateReturnVo calculateCartOrderPrice(CartOrderParamVo cartOrderParamVo){
        return new CalculateReturnVo();
    }
}
