package com.chaomeis.sparrowbeauty.api.controller.coupons;

import com.chaomeis.sparrowbeauty.api.service.coupons.ApiCouponsService;
import com.chaomeis.sparrowbeauty.common.PageReqVO;
import com.chaomeis.sparrowbeauty.common.PageRespDto;
import com.chaomeis.sparrowbeauty.entity.TbUserCoupons;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/coupons")
public class ApiCouponsController {
    @Resource
    private ApiCouponsService apiCouponsService;

    /**
     * 查询优惠券列表
     * @param page 参数
     * @return 分页列表数据
     */
    @RequestMapping(value = "/findPage")
    public PageRespDto<TbUserCoupons> findUserCouponsPageList (@RequestBody PageReqVO<TbUserCoupons> page) {
        TbUserCoupons userCoupons = page.getCondition();
        if (StringUtils.isEmpty(userCoupons.getOpenId())) {
            // openId不能为空
           return new PageRespDto(null);
        }
       return apiCouponsService.findUserCouponsPageList(page);
    }
}
