package com.chaomeis.sparrowbeauty.cms.service.goods;

import com.chaomeis.sparrowbeauty.common.PageReqVO;
import com.chaomeis.sparrowbeauty.common.PageRespDto;
import com.chaomeis.sparrowbeauty.entity.TbGoods;
import com.chaomeis.sparrowbeauty.entity.TbSkuDetail;
import com.chaomeis.sparrowbeauty.entity.TbSkuType;
import com.chaomeis.sparrowbeauty.mapper.TbGoodsMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsService {
    @Resource
    private TbGoodsMapper tbGoodsMapper;

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
       return tbGoodsMapper.selectByPrimaryKey(id);
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

}
