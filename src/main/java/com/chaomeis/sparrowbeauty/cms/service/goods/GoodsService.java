package com.chaomeis.sparrowbeauty.cms.service.goods;

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

    public void createGoods(TbGoods goods) {
        List<String> goodsCarouselImageList = goods.getGoodsCarouselImageList(); // 轮播
        if (!CollectionUtils.isEmpty(goods.getGoodsCarouselImageList())) { // 暂时取轮播的第一张作为商品海报
            goods.setGoodsPoster(goodsCarouselImageList.get(0)); // 海报
        }
        String goodsCarouselImage = this.commaSpliceStr(goodsCarouselImageList); // 轮播处理
        String goodsDetailImages = this.commaSpliceStr(goods.getGoodsDetailImagesList()); // 商品详情
        String skuTypeIds = this.skuTypeCommaSpliceIds(goods.getSkuTypeList()); // SKUtype处理
        String defaultSkuDetailIds = this.skuDetailCommaSpliceIds(goods.getSkuTypeList()); // sku明细处理
        goods.setGoodsCarouselImage(goodsCarouselImage);
        goods.setGoodsDetailImages(goodsDetailImages);
        goods.setSkuTypeIds(skuTypeIds);
        goods.setDefaultSkuDetailIds(defaultSkuDetailIds);
        tbGoodsMapper.insert(goods);
    }

    public void updateGoods(TbGoods goods) {
        tbGoodsMapper.updateByPrimaryKey(goods);
    }

    public TbGoods findGoods(int id) {
        TbGoods goods = tbGoodsMapper.selectByPrimaryKey(id);
        this.goodsImagePathSwap(goods);
        this.buildSkuInfo(goods);
        return goods;
    }

    public void deleteGoods(int id) {
        tbGoodsMapper.deleteByPrimaryKey(id);
    }

    public PageRespDto<TbGoods> findGoodsPageList(PageReqVO<TbGoods> page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<TbGoods> goodsPage = tbGoodsMapper.selectList(page.getCondition());
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
     * skuDetail 返回逗号拼接字符串id
     * @param skuTypeList
     * @return
     */
    public String skuDetailCommaSpliceIds (List<TbSkuType> skuTypeList) {
        if (CollectionUtils.isEmpty(skuTypeList)) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (TbSkuType skuType : skuTypeList) {
            if (!CollectionUtils.isEmpty(skuType.getSkuDetailList())) {
                for (TbSkuDetail detail: skuType.getSkuDetailList()) {
                    sb.append(detail.getId()).append(",");
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public void goodsImagePathSwap(TbGoods tbGoods){
        if (tbGoods == null){
            return;
        }

        String goodsCarouselImage = tbGoods.getGoodsCarouselImage();
        String goodsDetailImages = tbGoods.getGoodsDetailImages();
        if (StringUtils.isNotEmpty(goodsCarouselImage)){
            String[] split = goodsCarouselImage.split(",");
            List<String> goodsCarouselImageList = new ArrayList<>();
            for (String s : split) {
                goodsCarouselImageList.add(cmsSysProperties.getImageUrlPrefix()+s);
            }
            tbGoods.setGoodsCarouselImageList(goodsCarouselImageList);
        }

        if (StringUtils.isNotEmpty(goodsDetailImages)){
            String[] split = goodsDetailImages.split(",");
            List<String> goodsDetailImagesList = new ArrayList<>();
            for (String s : split) {
                goodsDetailImagesList.add(cmsSysProperties.getImageUrlPrefix()+s);
            }
            tbGoods.setGoodsDetailImagesList(goodsDetailImagesList);
        }

    }

    private List<TbSkuType> buildSkuInfo(TbGoods tbGoods) {
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
            return skuTypeList;
        }
        return  null;
    }
}
