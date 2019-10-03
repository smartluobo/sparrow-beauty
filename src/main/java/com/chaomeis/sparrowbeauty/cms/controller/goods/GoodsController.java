package com.chaomeis.sparrowbeauty.cms.controller.goods;

import com.chaomeis.sparrowbeauty.cms.service.goods.GoodsService;
import com.chaomeis.sparrowbeauty.common.BaseController;
import com.chaomeis.sparrowbeauty.common.PageReqVO;
import com.chaomeis.sparrowbeauty.common.PageRespDto;
import com.chaomeis.sparrowbeauty.entity.TbGoods;
import com.chaomeis.sparrowbeauty.response.ResultInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
public class GoodsController extends BaseController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/create")
    public ResultInfo createGoods (@RequestBody TbGoods goods) {
        if(StringUtils.isBlank(goods.getGoodsName())) {
            return ResultInfo.newRepeatResultInfo("商品名称不能为空");
        }
        goodsService.createGoods(goods);
        return ResultInfo.newSuccessResultInfo();
    }
    @RequestMapping(value = "/update")
    public ResultInfo updateGoods (@RequestBody TbGoods goods) {
        if(goods.getId() == 0) {
            return ResultInfo.newRepeatResultInfo("商品Id不能为空");
        }
        goodsService.updateGoods(goods);
        return ResultInfo.newSuccessResultInfo();
    }
    @RequestMapping(value = "/findPage")
    public PageRespDto<TbGoods> findGoodsPageList (@RequestBody PageReqVO<TbGoods> page) {
        return goodsService.findGoodsPageList(page);
    }
}
