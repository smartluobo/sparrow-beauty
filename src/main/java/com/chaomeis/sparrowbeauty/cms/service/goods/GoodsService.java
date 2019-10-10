package com.chaomeis.sparrowbeauty.cms.service.goods;

import com.chaomeis.sparrowbeauty.common.PageReqVO;
import com.chaomeis.sparrowbeauty.common.PageRespDto;
import com.chaomeis.sparrowbeauty.entity.TbGoods;
import com.chaomeis.sparrowbeauty.mapper.TbGoodsMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsService {
    @Resource
    private TbGoodsMapper tbGoodsMapper;

    public void createGoods(TbGoods goods) {
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
}
