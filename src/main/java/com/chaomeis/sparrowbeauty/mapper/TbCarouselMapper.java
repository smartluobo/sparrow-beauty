package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbCarousel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbCarouselMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbCarousel record);

    TbCarousel selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(TbCarousel record);

    List<TbCarousel> findAll();

    List<TbCarousel> selectList();

}
