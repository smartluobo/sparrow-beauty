package com.chaomeis.sparrowbeauty.cms.controller.sku;

import com.chaomeis.sparrowbeauty.cms.controller.login.CmsLoginController;
import com.chaomeis.sparrowbeauty.cms.service.sku.CmsSkuService;
import com.chaomeis.sparrowbeauty.entity.TbCmsUser;
import com.chaomeis.sparrowbeauty.entity.TbSkuDetail;
import com.chaomeis.sparrowbeauty.entity.TbSkuType;
import com.chaomeis.sparrowbeauty.mapper.TbSkuDetailMapper;
import com.chaomeis.sparrowbeauty.mapper.TbSkuTypeMapper;
import com.chaomeis.sparrowbeauty.response.ResultInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

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
    @Resource
    private TbSkuDetailMapper tbSkuDetailMapper;
    @Resource
    private TbSkuTypeMapper tbSkuTypeMapper;

    /**
     * 创建skutype类型
     * @param tbSkuType
     * @return
     */
    @RequestMapping(value = "/createType")
    public ResultInfo createSkuType(@RequestBody TbSkuType tbSkuType){
        if (StringUtils.isBlank(tbSkuType.getSkuTypeName())) {
            return ResultInfo.newRepeatResultInfo("sku名称不能为空");
        }
        if (CollectionUtils.isEmpty(tbSkuType.getSkuDetailList())) {
            return ResultInfo.newRepeatResultInfo("skuDetailList不能为空");
        }
        boolean isOccupied = cmsSkuService.skuTypeNameOccupied(tbSkuType);
        if (isOccupied) {
            return ResultInfo.newRepeatResultInfo(String.format("也有名称为 %s 的选项", tbSkuType.getSkuTypeName()));
        }
        cmsSkuService.createSkuType(tbSkuType);
        for (TbSkuDetail skuDetail : tbSkuType.getSkuDetailList()) {
            skuDetail.setSkuTypeId(tbSkuType.getId());
            tbSkuDetailMapper.insert(skuDetail);
        }
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
        if (CollectionUtils.isEmpty(tbSkuType.getSkuDetailList())) {
            return ResultInfo.newRepeatResultInfo("skuDetailList不能为空");
        }
        boolean isOccupied = cmsSkuService.skuTypeNameOccupied(tbSkuType);
        if (isOccupied) {
            return ResultInfo.newRepeatResultInfo(String.format("也有名称为 %s 的选项", tbSkuType.getSkuTypeName()));
        }
        cmsSkuService.updateSkuType(tbSkuType);

        // 需要删除的明细
        List<TbSkuDetail> skuDetailList = tbSkuDetailMapper.findSkuDetailBySkuTypeId(tbSkuType.getId());
        List<TbSkuDetail> deletList= removeAll(skuDetailList,tbSkuType.getSkuDetailList());
        for (TbSkuDetail delete : deletList) {
            tbSkuDetailMapper.deleteByPrimaryKey(delete.getId());
        }
        // 需要删除或者插入的明细
        for (TbSkuDetail skuDetail : tbSkuType.getSkuDetailList()) {
            if (null != skuDetail.getId()) {
                TbSkuDetail findSkuDetail = tbSkuDetailMapper.selectByPrimaryKey(skuDetail.getId());
                if (null != findSkuDetail) { // 如果数据库存在该数据则更新
                    skuDetail.setSkuTypeId(tbSkuType.getId());
                    tbSkuDetailMapper.updateByPrimaryKey(skuDetail);
                }
            } else {
                skuDetail.setSkuTypeId(tbSkuType.getId()); // 如果数据库不存在该数据则插入
                tbSkuDetailMapper.insert(skuDetail);
            }
        }

        return ResultInfo.newSuccessResultInfo();
    }

    // 删除左边重复的元素，返回左边
    private List<TbSkuDetail> removeAll(List<TbSkuDetail> left, List<TbSkuDetail> right){
        List<TbSkuDetail> res = new LinkedList<>(left);
        Set<Integer> set = new HashSet<>();
        for(TbSkuDetail dataPermission : right){
            set.add(dataPermission.getId());
        }
        Iterator<TbSkuDetail> iter = res.iterator();
        while(iter.hasNext()){
            if(set.contains(iter.next().getId())){
                iter.remove();
            }
        }
        return res;
    }
    /**
     * 删除建sku类型
     * @param skuTypeId
     * @return
     */
    @RequestMapping(value = "/delteType")
    public ResultInfo deleteSkuType(@RequestParam Integer skuTypeId){
        if(null == skuTypeId) {
            return ResultInfo.newRepeatResultInfo("skuTypeId不能为空");
        }
        cmsSkuService.deleteSkuType(skuTypeId);
        // 删除明细记录
        tbSkuDetailMapper.deleteSkuTypeId(skuTypeId);
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
        for (TbSkuType skuType : typeList) {
            List<TbSkuDetail> detailList = tbSkuDetailMapper.findSkuDetailBySkuTypeId(skuType.getId());
            skuType.setSkuDetailList(detailList);
        }
         ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
        resultInfo.setData(typeList);
        return resultInfo;
    }

    /**
     * 查询suy明细
     * @param skuTypeId
     * @return
     */
    @RequestMapping(value = "/findTypeInfo")
    public ResultInfo findSkuTypeInfo(@RequestParam Integer skuTypeId){
        if(null == skuTypeId) {
            return ResultInfo.newRepeatResultInfo("skuTypeId不能为空");
        }
        TbSkuType type =  cmsSkuService.findSkuTypeInfo(skuTypeId);
        if (null != type) {
            List<TbSkuDetail> detailList = tbSkuDetailMapper.findSkuDetailBySkuTypeId(skuTypeId);
            type.setSkuDetailList(detailList);
        }
        ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
        resultInfo.setData(type);
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
        if(null == tbSkuDetail.getId()) {
            return ResultInfo.newRepeatResultInfo("Id不能为空");
        }
        cmsSkuService.updateSkuDetail(tbSkuDetail);
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
