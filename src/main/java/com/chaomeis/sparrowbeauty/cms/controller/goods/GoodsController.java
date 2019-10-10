package com.chaomeis.sparrowbeauty.cms.controller.goods;

import com.chaomeis.sparrowbeauty.cms.service.goods.GoodsService;
import com.chaomeis.sparrowbeauty.common.BaseController;
import com.chaomeis.sparrowbeauty.common.PageReqVO;
import com.chaomeis.sparrowbeauty.common.PageRespDto;
import com.chaomeis.sparrowbeauty.entity.TbGoods;
import com.chaomeis.sparrowbeauty.response.ResultInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 商品
 */
@RestController
@CrossOrigin
@RequestMapping("cms/goods")
public class GoodsController extends BaseController {
    @Resource
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

    @RequestMapping(value = "/findInfo")
    public ResultInfo findInfo (int id) {
        if(id == 0) {
            return ResultInfo.newRepeatResultInfo("商品Id不能为空");
        }
        TbGoods goods = goodsService.findGoods(id);
        ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
        resultInfo.setData(goods);
        return resultInfo;
    }

    @RequestMapping(value = "/delete")
    public ResultInfo deleteGoods (int id) {
        if(id == 0) {
            return ResultInfo.newRepeatResultInfo("商品Id不能为空");
        }
        goodsService.deleteGoods(id);
        return ResultInfo.newSuccessResultInfo();
    }

    @RequestMapping(value = "/findPage")
    public PageRespDto<TbGoods> findGoodsPageList (@RequestBody PageReqVO<TbGoods> page) {
        return goodsService.findGoodsPageList(page);
    }
}
