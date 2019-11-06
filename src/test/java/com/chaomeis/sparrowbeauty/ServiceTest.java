package com.chaomeis.sparrowbeauty;

import com.alibaba.fastjson.JSONObject;
import com.chaomeis.sparrowbeauty.api.paramVo.GoodsParamVO;
import com.chaomeis.sparrowbeauty.api.paramVo.GoodsVO;
import com.chaomeis.sparrowbeauty.api.responseVo.CalculateGoodsReturnVO;
import com.chaomeis.sparrowbeauty.api.responseVo.CalculateReturnVo;
import com.chaomeis.sparrowbeauty.api.service.calculate.CalculateService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class ServiceTest extends BaseTest {
    @Resource
    private CalculateService calculateService;
    @Test
    public void calculateCartGoodsPrice () {
        GoodsParamVO createOrder = new GoodsParamVO();
        GoodsVO goods = new GoodsVO();
        goods.setGoodsId(1);
        goods.setGoodsCount(5);
        List<Integer> skuDetailIdList = new ArrayList<Integer>();
        skuDetailIdList.add(1);
        skuDetailIdList.add(2);
        goods.setSkuDetailIdList(skuDetailIdList);
        createOrder.setGoods(goods);
        createOrder.setOpenId("123456");
        createOrder.setUserCouponsId(2);
        CalculateReturnVo returnVO = calculateService.calculateCartGoodsPrice(createOrder);
        System.out.println(JSONObject.toJSONString(returnVO));
    }

}
