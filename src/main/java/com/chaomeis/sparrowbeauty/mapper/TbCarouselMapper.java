package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbCarousel;

public interface TbCarouselMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbCarousel record);

    int insertSelective(TbCarousel record);

    TbCarousel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbCarousel record);

    int updateByPrimaryKey(TbCarousel record);
}