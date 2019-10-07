package com.chaomeis.sparrowbeauty.api.service.calculate;

import com.chaomeis.sparrowbeauty.api.paramVo.CartOrderParamVo;
import com.chaomeis.sparrowbeauty.api.responseVo.CalculateReturnVo;
import org.springframework.stereotype.Service;


@Service
public class CalculateService {
    /**
     * 结算订单价格
     * @param cartOrderParamVo 创建订单的参数
     * @return 返回订单价格对象
     */
    public CalculateReturnVo calculateCartOrderPrice(CartOrderParamVo cartOrderParamVo) {
        return new CalculateReturnVo();
    }
}
