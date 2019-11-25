package com.chaomeis.sparrowbeauty.cms.service.sku;

import com.chaomeis.sparrowbeauty.entity.TbSkuDetail;
import com.chaomeis.sparrowbeauty.entity.TbSkuType;
import com.chaomeis.sparrowbeauty.mapper.TbSkuDetailMapper;
import com.chaomeis.sparrowbeauty.mapper.TbSkuTypeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CmsSkuService {
    @Resource
    private TbSkuTypeMapper tbSkuTypeMapper;
    @Resource
    private TbSkuDetailMapper tbSkuDetailMapper;

    /**
     * 创建skuType
     * @param tbSkuType
     */
    public void createSkuType(TbSkuType tbSkuType) {
        tbSkuTypeMapper.insert(tbSkuType);
    }
    /**
     * 更新skuType
     * @param tbSkuType
     */
    public void updateSkuType(TbSkuType tbSkuType) {
        tbSkuTypeMapper.updateByPrimaryKey(tbSkuType);
    }
    /**
     * 删除skuType
     * @param skuTypeId
     */
    public void deleteSkuType(Integer skuTypeId) {
        tbSkuTypeMapper.deleteByPrimaryKey(skuTypeId);
    }
    /**
     * 查询skuType列表
     * @param tbSkuType
     */
    public List<TbSkuType> findSkuTypeList(TbSkuType tbSkuType) {
        return tbSkuTypeMapper.findSkuTypeList(tbSkuType);
    }
    /**
     * 查询skuType明细
     * @param skuTypeId
     */
    public TbSkuType findSkuTypeInfo(Integer skuTypeId) {
        return tbSkuTypeMapper.selectByPrimaryKey(skuTypeId);
    }
    /**
     * 查询名称是否被占用
     * @param tbSkuType sku了下对象
     * @return boolean true:占用 false:没占用
  */
    public boolean skuTypeNameOccupied(TbSkuType tbSkuType) {
        TbSkuType fiandSkuType = new TbSkuType();
        fiandSkuType.setSkuTypeName(tbSkuType.getSkuTypeName());
        List<TbSkuType> list = tbSkuTypeMapper.findSkuTypeList(fiandSkuType);
        if (list.size() > 1) {
            return true;
        }
        if (list.size() == 1) {
            for (TbSkuType skuType : list) {
                if (!skuType.getId().equals(tbSkuType.getId())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 创建sku明细记录
     * @param tbSkuDetail
     */
    public void createSkuDetail(TbSkuDetail tbSkuDetail) {
        tbSkuDetailMapper.insert(tbSkuDetail);
    }

    /**
     * 更新sku明细记录
     * @param tbSkuDetail
     */
    public void updateSkuDetail(TbSkuDetail tbSkuDetail) {
        tbSkuDetailMapper.updateByPrimaryKey(tbSkuDetail);
    }
    /**
     * 删除sku明细记录
     * @param tbSkuDetail
     */
    public void deleteSkuDetail(Integer tbSkuDetail) {
        tbSkuDetailMapper.deleteByPrimaryKey(tbSkuDetail);
    }

    /**
     * 查询sku明细记录
     * @param tbSkuDetail
     * @return
     */
    public List<TbSkuDetail> findSkuDetailList (TbSkuDetail tbSkuDetail) {
       return tbSkuDetailMapper.findSkuDetailBySkuTypeId(tbSkuDetail.getSkuTypeId());
    }
}
