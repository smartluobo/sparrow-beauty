package com.chaomeis.sparrowbeauty;

import com.chaomeis.sparrowbeauty.api.paramVo.GoodsParamVO;
import com.chaomeis.sparrowbeauty.api.service.calculate.CalculateService;
import org.junit.Test;

import javax.annotation.Resource;

public class ServiceTest extends BaseTest {
    @Resource
    private CalculateService calculateService;
    @Test
    public void calculateCartGoodsPrice () {
        GoodsParamVO createOrder = new GoodsParamVO();
        calculateService.calculateCartGoodsPrice(createOrder);
    }

}
