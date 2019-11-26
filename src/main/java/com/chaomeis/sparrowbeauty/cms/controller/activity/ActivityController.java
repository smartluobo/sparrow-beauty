package com.chaomeis.sparrowbeauty.cms.controller.activity;

import com.chaomeis.sparrowbeauty.cms.service.activity.ActivityService;
import com.chaomeis.sparrowbeauty.cms.service.activity.GoodsActivityService;
import com.chaomeis.sparrowbeauty.common.PageReqVO;
import com.chaomeis.sparrowbeauty.common.PageRespDto;
import com.chaomeis.sparrowbeauty.entity.TbActivity;
import com.chaomeis.sparrowbeauty.entity.TbActivityGoods;
import com.chaomeis.sparrowbeauty.entity.TbGoods;
import com.chaomeis.sparrowbeauty.response.ResultInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("cms/activity")
public class ActivityController {
    @Resource
    private ActivityService activityService;

    /**
     * 创建活动
     * @param record
     * @return
     */
    @RequestMapping(value = "/create")
    public ResultInfo createActivity (@RequestBody TbActivity record) {
        if(StringUtils.isBlank(record.getActivityName())) {
            return ResultInfo.newRepeatResultInfo("活动名称不能为空");
        }
        if(StringUtils.isBlank(record.getActivityType())) {
            return ResultInfo.newRepeatResultInfo("活动类型不能为空");
        }
        activityService.createActivity(record);
        return ResultInfo.newSuccessResultInfo();
    }
    /**
     * 创建活动
     * @param record
     * @return
     */
    @RequestMapping(value = "/update")
    public ResultInfo updateActivity (@RequestBody TbActivity record) {
        if(record.getId() <= 0) {
            return ResultInfo.newRepeatResultInfo("id不能为空");
        }
        activityService.updateActivity(record);
        return ResultInfo.newSuccessResultInfo();
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
