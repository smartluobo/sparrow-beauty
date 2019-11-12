package com.chaomeis.sparrowbeauty.cms.controller.sku;

import com.chaomeis.sparrowbeauty.cms.controller.login.CmsLoginController;
import com.chaomeis.sparrowbeauty.cms.service.sku.CmsSkuService;
import com.chaomeis.sparrowbeauty.entity.TbCmsUser;
import com.chaomeis.sparrowbeauty.entity.TbSkuDetail;
import com.chaomeis.sparrowbeauty.entity.TbSkuType;
import com.chaomeis.sparrowbeauty.response.ResultInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * sku管理
 */
@RestController
@CrossOrigin
@RequestMapping("cms/sku")
public class CmsSkuController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CmsLoginController.class);
    @Resource
    private CmsSkuService cmsSkuService;

    /**
     * 创建skutype类型
     * @param tbSkuType
     * @return
     */
    @RequestMapping(value = "/createType")
    public ResultInfo createSkuType(@RequestBody TbSkuType tbSkuType){
        if(StringUtils.isBlank(tbSkuType.getSkuTypeName())) {
            return ResultInfo.newRepeatResultInfo("sku名称不能为空");
        }
        cmsSkuService.createSkuType(tbSkuType);
        return ResultInfo.newSuccessResultInfo();
    }
    /**
     * 更新sku类型
     * @param tbSkuType
     * @return
     */
    @RequestMapping(value = "/updateType")
    public ResultInfo updateSkuType(@RequestBody TbSkuType tbSkuType){
        if(null == tbSkuType.getId()) {
            return ResultInfo.newRepeatResultInfo("skuid不能为空");
        }
        cmsSkuService.updateSkuType(tbSkuType);
        return ResultInfo.newSuccessResultInfo();
    }
    /**
     * 删除建sku类型
     * @param skuTypeId
     * @return
     */
    @RequestMapping(value = "/delteType")
    public ResultInfo deleteSkuType(@RequestBody Integer skuTypeId){
        if(null == skuTypeId) {
            return ResultInfo.newRepeatResultInfo("skuid不能为空");
        }
        cmsSkuService.deleteSkuType(skuTypeId);
        return ResultInfo.newSuccessResultInfo();
    }
    /**
     * 查询sut类型列表
     * @param tbSkuType
     * @return
     */
    @RequestMapping(value = "/findTypeList")
    public ResultInfo findSkuTypeList(@RequestBody TbSkuType tbSkuType){
        List<TbSkuType> typeList =  cmsSkuService.findSkuTypeList(tbSkuType);
         ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
        resultInfo.setData(typeList);
        return resultInfo;
    }

    /**
     * 创建skutdetail明细
     * @param tbSkuDetail
     * @return
     */
    @RequestMapping(value = "/createDetail")
    public ResultInfo createSkuDetail(@RequestBody TbSkuDetail tbSkuDetail){
        if(StringUtils.isBlank(tbSkuDetail.getSkuDetailName())) {
            return ResultInfo.newRepeatResultInfo("sku明细名称不能为空");
        }
        if(null == tbSkuDetail.getSkuTypeId()) {
            return ResultInfo.newRepeatResultInfo("skuTypeId不能为空");
        }
        cmsSkuService.createSkuDetail(tbSkuDetail);
        return ResultInfo.newSuccessResultInfo();
    }
    /**
     * 更新skutdetail明细
     * @param tbSkuDetail
     * @return
     */
    @RequestMapping(value = "/updateDetail")
    public ResultInfo uodateSkuDetail(@RequestBody TbSkuDetail tbSkuDetail){
        if(StringUtils.isBlank(tbSkuDetail.getSkuDetailName())) {
            return ResultInfo.newRepeatResultInfo("sku明细名称不能为空");
        }
        if(null == tbSkuDetail.getSkuTypeId()) {
            return ResultInfo.newRepeatResultInfo("skuTypeId不能为空");
        }
        cmsSkuService.createSkuDetail(tbSkuDetail);
        return ResultInfo.newSuccessResultInfo();
    }
    /**
     * 删除skutdetail明细
     * @param skuDetailId
     * @return
     */
    @RequestMapping(value = "/deleteDetail")
    public ResultInfo uodateSkuDetail(@RequestBody Integer skuDetailId){
        if(null == skuDetailId) {
            return ResultInfo.newRepeatResultInfo("skuDetailId不能为空");
        }
        cmsSkuService.deleteSkuDetail(skuDetailId);
        return ResultInfo.newSuccessResultInfo();
    }
    /**
     * 查询skutdetail列表
     * @param tbSkuDetail
     * @return
     */
    @RequestMapping(value = "/findDetailList")
    public ResultInfo findSkuDetailList(@RequestBody TbSkuDetail tbSkuDetail){
        List<TbSkuDetail> list = cmsSkuService.findSkuDetailList(tbSkuDetail);
        ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
        resultInfo.setData(list);
        return resultInfo;
    }
}
