package com.chaomeis.sparrowbeauty.cms.controller.coupons;

import com.chaomeis.sparrowbeauty.cms.service.coupons.CmsCouponsService;
import com.chaomeis.sparrowbeauty.common.BaseController;
import com.chaomeis.sparrowbeauty.common.PageReqVO;
import com.chaomeis.sparrowbeauty.common.PageRespDto;
import com.chaomeis.sparrowbeauty.entity.TbCoupons;
import com.chaomeis.sparrowbeauty.response.ResultInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 优惠券
 */
@RestController
@CrossOrigin
@RequestMapping("cms/coupons")
public class CmsCouponsController extends BaseController {
    @Resource
    private CmsCouponsService cmsCouponsService;

    @RequestMapping(value = "/create")
    public ResultInfo createCoupons (@RequestBody TbCoupons coupons) {
        if(StringUtils.isBlank(coupons.getCouponsName())) {
            return ResultInfo.newRepeatResultInfo("优惠券名称");
        }
        cmsCouponsService.createCoupons(coupons);
        return ResultInfo.newSuccessResultInfo();
    }
    @RequestMapping(value = "/update")
    public ResultInfo updateCoupons (@RequestBody TbCoupons coupons) {
        if(null == coupons.getId()) {
            return ResultInfo.newRepeatResultInfo("优惠券id");
        }
        cmsCouponsService.updateCoupons(coupons);
        return ResultInfo.newSuccessResultInfo();
    }
    @RequestMapping(value = "/delete")
    public ResultInfo deleteCoupons (Integer id) {
        if(null == id) {
            return ResultInfo.newRepeatResultInfo("优惠券id");
        }
        cmsCouponsService.deleteCoupons(id);
        return ResultInfo.newSuccessResultInfo();
    }
    @RequestMapping(value = "/findInfo")
    public ResultInfo findInfoCoupons (Integer id) {
        if(null == id) {
            return ResultInfo.newRepeatResultInfo("优惠券id");
        }
        cmsCouponsService.findCouponsInfo(id);
        return ResultInfo.newSuccessResultInfo();
    }
    @RequestMapping(value = "/findPage")
    public PageRespDto<TbCoupons> findCouponsPageList (@RequestBody PageReqVO<TbCoupons> page) {
        return cmsCouponsService.findCouponsPageList(page);
    }
}
