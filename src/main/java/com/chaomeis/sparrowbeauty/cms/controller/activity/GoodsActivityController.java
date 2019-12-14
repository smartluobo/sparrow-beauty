package com.chaomeis.sparrowbeauty.cms.controller.activity;

import com.chaomeis.sparrowbeauty.cms.service.activity.GoodsActivityService;
import com.chaomeis.sparrowbeauty.common.BaseController;
import com.chaomeis.sparrowbeauty.entity.TbActivityGoods;
import com.chaomeis.sparrowbeauty.entity.TbGoods;
import com.chaomeis.sparrowbeauty.response.ResultInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 商品活动
 */
@RestController
@RequestMapping("cms/activity")
public class GoodsActivityController extends BaseController {
    @Resource
    private GoodsActivityService goodsActivityService;
    /**
     * 将商品添加到活动中
     */
    @RequestMapping(value = "/goods/create")
    public ResultInfo createGoods (@RequestBody TbActivityGoods record) {
        if(0 == record.getActivityId()) {
            return ResultInfo.newRepeatResultInfo("活动id不能为空");
        }
        if(null == record.getGoodsId()) {
            return ResultInfo.newRepeatResultInfo("商品id不能为空");
        }
        goodsActivityService.createGoodsActivity(record);
        return ResultInfo.newSuccessResultInfo();
    }
}
