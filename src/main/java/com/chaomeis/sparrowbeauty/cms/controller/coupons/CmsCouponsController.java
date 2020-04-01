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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public ResultInfo createCoupons (HttpServletRequest request, HttpServletResponse response, @RequestBody TbCoupons coupons) {
        response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
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
    public ResultInfo deleteCoupons (HttpServletRequest request, HttpServletResponse response,Integer id) {
        response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
        if(null == id) {
            return ResultInfo.newRepeatResultInfo("优惠券id");
        }
        cmsCouponsService.deleteCoupons(id);
        return ResultInfo.newSuccessResultInfo();
    }
    @RequestMapping(value = "/findById")
    public ResultInfo findInfoCoupons (HttpServletRequest request, HttpServletResponse response, Integer id) {
        response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
        if(null == id) {
            return ResultInfo.newRepeatResultInfo("优惠券id");
        }
        TbCoupons coupons = cmsCouponsService.findCouponsInfo(id);
        ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
        resultInfo.setData(coupons);
        return resultInfo;
    }
    @RequestMapping(value = "/findPage")
    public PageRespDto<TbCoupons> findCouponsPageList (HttpServletRequest request, HttpServletResponse response, @RequestBody PageReqVO<TbCoupons> page) {
        response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
        return cmsCouponsService.findCouponsPageList(page);
    }
}
