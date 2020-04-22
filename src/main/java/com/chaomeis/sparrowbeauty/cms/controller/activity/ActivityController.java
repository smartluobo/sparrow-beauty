package com.chaomeis.sparrowbeauty.cms.controller.activity;

import com.chaomeis.sparrowbeauty.cms.service.activity.ActivityService;
import com.chaomeis.sparrowbeauty.cms.service.activity.GoodsActivityService;
import com.chaomeis.sparrowbeauty.common.BaseController;
import com.chaomeis.sparrowbeauty.common.PageReqVO;
import com.chaomeis.sparrowbeauty.common.PageRespDto;
import com.chaomeis.sparrowbeauty.entity.TbActivity;
import com.chaomeis.sparrowbeauty.entity.TbActivityGoods;
import com.chaomeis.sparrowbeauty.entity.TbGoods;
import com.chaomeis.sparrowbeauty.mapper.TbActivityGoodsMapper;
import com.chaomeis.sparrowbeauty.mapper.TbGoodsMapper;
import com.chaomeis.sparrowbeauty.response.ResultInfo;
import com.github.pagehelper.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("cms/activity")
public class ActivityController extends BaseController {
    @Resource
    private ActivityService activityService;
    @Resource
    private GoodsActivityService goodsActivityService;
    @Resource
    private TbActivityGoodsMapper tbActivityGoodsMapper;
    @Resource
    private TbGoodsMapper tbGoodsMapper;
    /**
     * 创建活动
     * @param activity
     * @return
     */
    @RequestMapping(value = "/create")
    public ResultInfo createActivity (@RequestBody TbActivity activity) {
        if(StringUtils.isBlank(activity.getActivityName())) {
            return ResultInfo.newRepeatResultInfo("活动名称不能为空");
        }
        if(StringUtils.isBlank(activity.getActivityType())) {
            return ResultInfo.newRepeatResultInfo("活动类型不能为空");
        }
        // 创建活动
        activityService.createActivity(activity);
        // 创建活动商品
        this.createGoodsActivity(activity);
        return ResultInfo.newSuccessResultInfo();
    }

    /**
     * 创建活动
     * @param record
     * @return
     */
    @RequestMapping(value = "/update")
    public ResultInfo updateActivity (@RequestBody TbActivity record) {
        if(null == record.getId()) {
            return ResultInfo.newRepeatResultInfo("id不能为空");
        }
        activityService.updateActivity(record);
        // 创建活动商品
        this.createGoodsActivity(record);
        return ResultInfo.newSuccessResultInfo();
    }
    private void createGoodsActivity(@RequestBody TbActivity activity) {
        // 活动商品
        List<TbGoods> goodsList = activity.getGoodsList();
        // 限时折扣时将产品加入到活动列表中
        if ("1".equals(activity.getActivityType())) {
            if (!CollectionUtils.isEmpty(goodsList)) {
                for (TbGoods goods : goodsList) {
                    TbActivityGoods record = new TbActivityGoods();
                    record.setActivityId(activity.getId());
                    record.setGoodsId(goods.getId());
                    record.setGoodsName(goods.getGoodsName());
                    record.setActivityName(activity.getActivityName());
                    if (!StringUtil.isEmpty(activity.getCouponsRatio())) { // 如果有折扣金额为折扣价
                        record.setPriceType(1); // 价格类型 0-指定价格 1-折扣价
                        record.setActivityRatio(activity.getCouponsRatio()); // 折扣比例
                    } else if (!StringUtil.isEmpty(activity.getReduceAmount())) { // 如果有减免金额为指定价格
                        record.setPriceType(0); // 价格类型 0-指定价格 1-折扣价
                        // 商品活动价格：商品金额-活动价格。
                        // 商品原价
                        BigDecimal goodsPrice = new BigDecimal(goods.getGoodsPrice());
                        // 减免金额金额
                        BigDecimal reduceAmount = new BigDecimal(activity.getReduceAmount());
                        // 活动价格
                        BigDecimal activitPrice = goodsPrice.subtract(reduceAmount);
                        // 当金额小于0时商品价格为0
                        if (activitPrice.compareTo(new BigDecimal("0")) <= 0) {
                            activitPrice = new BigDecimal("0");
                        }
                        record.setActivityPrice(activitPrice.toString());
                    }
                    tbActivityGoodsMapper.deleteGoodsId(goods.getId()); // 删除商品对应的活动一个商品只能存在一个活动中
                    goodsActivityService.createGoodsActivity(record);
                }
            }
        }
    }
    /**
     * 删除活动
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete")
    public ResultInfo deleteActivity (Integer id) {
        if(null == id) {
            return ResultInfo.newRepeatResultInfo("id不能为空");
        }
        activityService.deleteActivity(id);
        return ResultInfo.newSuccessResultInfo();
    }
    /**
     * 查询活动详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/findInfo")
    public ResultInfo findActivity (Integer id) {
        if(null == id) {
            return ResultInfo.newRepeatResultInfo("id不能为空");
        }
        TbActivity activity = activityService.findActivity(id);
        List<TbGoods> goodsList= tbGoodsMapper.findActivityGoods(id);
        activity.setGoodsList(goodsList);
        ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
        resultInfo.setData(activity);
        return resultInfo;
    }

    /**
     * 分页查询活动列表
     * @param page
     * @return
     */
    @RequestMapping(value = "/findPage")
    public PageRespDto<TbActivity> findGoodsPageList (@RequestBody PageReqVO<TbActivity> page) {
        return activityService.findGoodsPageList(page);
    }
}
