package com.chaomeis.sparrowbeauty.cms.service.carousel;

import com.chaomeis.sparrowbeauty.common.PageReqVO;
import com.chaomeis.sparrowbeauty.common.PageRespDto;
import com.chaomeis.sparrowbeauty.entity.TbCarousel;
import com.chaomeis.sparrowbeauty.entity.TbGoods;
import com.chaomeis.sparrowbeauty.mapper.TbCarouselMapper;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CmsCarouselService {

    @Resource
    private TbCarouselMapper tbCarouselMapper;
    public PageRespDto<TbCarousel> findCarouselPageList(PageReqVO<TbCarousel> page) {

        PageHelper.startPage(page.getPageNum(), page.getPageSize());

        List<TbCarousel> carouselPage = tbCarouselMapper.selectList();

        PageRespDto<TbCarousel> pageList = new PageRespDto(carouselPage);
        return pageList;

    }

    public void createCarousel(TbCarousel carousel) {
        tbCarouselMapper.insert(carousel);
    }

    public void updateGoods(TbCarousel carousel) {
        tbCarouselMapper.updateByPrimaryKey(carousel);
    }

    public TbCarousel findCarouselById(int id) {
        return tbCarouselMapper.selectByPrimaryKey(id);
    }

    public void deleteCarousel(Integer id) {
        tbCarouselMapper.deleteByPrimaryKey(id);
    }
}
