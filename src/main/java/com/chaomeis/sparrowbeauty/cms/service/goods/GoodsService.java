package com.chaomeis.sparrowbeauty.cms.service.goods;

import com.chaomeis.sparrowbeauty.cms.service.sku.CmsSkuService;
import com.chaomeis.sparrowbeauty.common.PageReqVO;
import com.chaomeis.sparrowbeauty.common.PageRespDto;
import com.chaomeis.sparrowbeauty.config.CmsSysProperties;
import com.chaomeis.sparrowbeauty.entity.TbGoods;
import com.chaomeis.sparrowbeauty.entity.TbSkuDetail;
import com.chaomeis.sparrowbeauty.entity.TbSkuType;
import com.chaomeis.sparrowbeauty.mapper.TbGoodsMapper;
import com.chaomeis.sparrowbeauty.mapper.TbSkuDetailMapper;
import com.chaomeis.sparrowbeauty.mapper.TbSkuTypeMapper;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GoodsService {
    @Resource
    private TbGoodsMapper tbGoodsMapper;
    @Resource
    private TbSkuTypeMapper tbSkuTypeMapper;
    @Resource
    private TbSkuDetailMapper tbSkuDetailMapper;
    @Resource
    private CmsSysProperties cmsSysProperties;
    @Resource
    private CmsSkuService cmsSkuService;

    public void createGoods(TbGoods goods) {
        this.goodParam(goods);
        tbGoodsMapper.insert(goods);
    }

    public void updateGoods(TbGoods goods) {
        this.goodParam(goods);
        tbGoodsMapper.updateByPrimaryKey(goods);
    }

    /**
     * 商品参数处理
     * @param goods
     */
    private void goodParam(TbGoods goods) {
        this.skuCommaSpliceIds(goods.getSkuTypeList(), goods);// SKU明细和类型处理处理
    }

    public TbGoods findGoods(int id) {
        TbGoods goods = tbGoodsMapper.selectByPrimaryKey(id);
        this.goodsImagePathSwap(goods);
        List<TbSkuType> skuTypeList = this.buildSkuInfo(goods);
        goods.setSkuTypeList(skuTypeList);
        return goods;
    }

    public void deleteGoods(int id) {
        tbGoodsMapper.deleteByPrimaryKey(id);
    }

    public PageRespDto<TbGoods> findGoodsPageList(PageReqVO<TbGoods> page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        TbGoods tbGoods = page.getCondition();
        if (tbGoods != null){
            if (StringUtils.isNotEmpty(tbGoods.getGoodsName())){
                String goodsName = tbGoods.getGoodsName().toUpperCase();
                goodsName = "%"+goodsName+"%";
                tbGoods.setGoodsName(goodsName);
            }
        }
        List<TbGoods> goodsPage = tbGoodsMapper.selectList(tbGoods);
        for (TbGoods goods : goodsPage) {
           this.goodsImagePathSwap(goods);
        }
        PageRespDto<TbGoods> pageList = new PageRespDto(goodsPage);
        return pageList;
    }

    /**
     * 处理List数据返回字符串逗号拼接
     * @param stringList
     * @return
     */
    public String commaSpliceStr (List<String> stringList) {
        if (CollectionUtils.isEmpty(stringList)) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (String string : stringList) {
            string = this.imageUrl(string);
            sb.append(string).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * skuType 返回逗号拼接字符串id
     * @param skuTypeList
     * @return
     */
    public String skuTypeCommaSpliceIds (List<TbSkuType> skuTypeList) {
        if (CollectionUtils.isEmpty(skuTypeList)) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (TbSkuType skuType : skuTypeList) {
            sb.append(skuType.getId()).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * sku类型和明细处理，返回逗号拼接字符串id
     * skuDetail 返回逗号拼接字符串id
     * @param skuTypeList
     * @return
     */
    public void skuCommaSpliceIds (List<TbSkuType> skuTypeList, TbGoods goods) {
        if(CollectionUtils.isEmpty(skuTypeList)) {
            return;
        }
        StringBuffer detailStr = new StringBuffer(); // sku明细
        StringBuffer typeStr = new StringBuffer(); // sku类型
        for (TbSkuType skuType : skuTypeList) {
            if (!CollectionUtils.isEmpty(skuType.getSkuDetailList())) {
                for (TbSkuDetail detail: skuType.getSkuDetailList()) {
                    if(1 == detail.getIsSelect()) { // 选中的
                        detailStr.append(detail.getId()).append(",");
                        typeStr.append(skuType.getId()).append(",");
                    }
                }
            }
        }
        if (detailStr.length()>1) {
            detailStr.deleteCharAt(detailStr.length() - 1);
        }
        if(typeStr.length()>1) {
            typeStr.deleteCharAt(typeStr.length() - 1);
        }
        goods.setSkuTypeIds(typeStr.toString());
        goods.setDefaultSkuDetailIds(detailStr.toString());
    }

    public void goodsImagePathSwap(TbGoods tbGoods){
        if (tbGoods == null){
            return;
        }
    }

    private List<TbSkuType> buildSkuInfo(TbGoods tbGoods) {
        String skuTypeIds = tbGoods.getSkuTypeIds();
        String defaultSkuDetailIds = tbGoods.getDefaultSkuDetailIds();
        List<String> defaultSkuDetailList = null;
        if (StringUtils.isNotEmpty(defaultSkuDetailIds)){
            defaultSkuDetailList = Arrays.asList(defaultSkuDetailIds.split(","));
        }

        List<TbSkuType> skuTypeList = cmsSkuService.findSkuTypeList(new TbSkuType());
        //List<TbSkuType> skuTypeList = tbSkuTypeMapper.findSkuTypeByIds(Arrays.asList(skuTypeIds.split(",")));
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
        return skuTypeList;
    }

    public String imageUrl (String url) {
        url = url.replaceAll(cmsSysProperties.getImageUrlPrefix(),"");
        return url;
    }
}
