package com.chaomeis.sparrowbeauty.api.service.goods;

import com.chaomeis.sparrowbeauty.entity.TbGoods;
import com.chaomeis.sparrowbeauty.entity.TbSkuDetail;
import com.chaomeis.sparrowbeauty.entity.TbSkuType;
import com.chaomeis.sparrowbeauty.entity.TbSuit;
import com.chaomeis.sparrowbeauty.mapper.TbGoodsMapper;
import com.chaomeis.sparrowbeauty.mapper.TbSkuDetailMapper;
import com.chaomeis.sparrowbeauty.mapper.TbSkuTypeMapper;
import com.chaomeis.sparrowbeauty.mapper.TbSuitMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class ApiGoodsService {

    @Resource
    private TbGoodsMapper tbGoodsMapper;

    @Resource
    private TbSuitMapper tbSuitMapper;

    @Resource
    private TbSkuTypeMapper tbSkuTypeMapper;

    @Resource
    private TbSkuDetailMapper tbSkuDetailMapper;

    public List<TbGoods> findGoodsList() {
        List<TbGoods> goodsList = tbGoodsMapper.findAll();
        //todo 判断是否需要重新计算显示价格,全场折扣需要重新计算价格
        return goodsList;
    }

    public List<TbSuit> findSuitList() {
        List<TbSuit> suitList = tbSuitMapper.findAll();
        //todo 判断是否需要重新计算套装价格，全场折扣需要重新计算价格
        return suitList;
    }

    private void buildSkuInfo(TbGoods tbGoods) {
        String skuTypeIds = tbGoods.getSkuTypeIds();
        if (StringUtils.isNotEmpty(skuTypeIds)){
            String defaultSkuDetailIds = tbGoods.getDefaultSkuDetailIds();
            List<String> defaultSkuDetailList = null;
            if (StringUtils.isNotEmpty(defaultSkuDetailIds)){
                defaultSkuDetailList = Arrays.asList(defaultSkuDetailIds.split(","));
            }
            List<TbSkuType> skuTypeList = tbSkuTypeMapper.findSkuTypeByIds(Arrays.asList(skuTypeIds.split(",")));
            if (!CollectionUtils.isEmpty(skuTypeList)){
                for (TbSkuType tbSkuType : skuTypeList) {
                    List<TbSkuDetail> skuDetailList = tbSkuDetailMapper.findSkuDetailBySkuTypeId(tbSkuType.getId());
                    if (!CollectionUtils.isEmpty(skuDetailList)){
                        if (!CollectionUtils.isEmpty(defaultSkuDetailList)){
                            for (TbSkuDetail tbSkuDetail : skuDetailList) {
                                for (String s : defaultSkuDetailList) {
                                    if (s.equals(tbSkuDetail.getId().toString())){
                                        tbSkuDetail.setIsSelect(1);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    tbSkuType.setSkuDetailList(skuDetailList);
                }
            }
            tbGoods.setSkuTypeList(skuTypeList);
        }
    }

    public TbSuit findSuitDetailById(Integer suitId) {
        return tbSuitMapper.selectByPrimaryKey(suitId);
    }

    public TbGoods findGoodsDetailById(Integer goodsId) {
        TbGoods tbGoods = tbGoodsMapper.selectByPrimaryKey(goodsId);
        buildSkuInfo(tbGoods);
        return tbGoods;
    }
}
