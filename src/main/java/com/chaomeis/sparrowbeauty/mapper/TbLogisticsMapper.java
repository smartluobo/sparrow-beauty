package com.chaomeis.sparrowbeauty.mapper;


import com.chaomeis.sparrowbeauty.entity.TbLogistics;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbLogisticsMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(TbLogistics record);

    TbLogistics selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(TbLogistics record);

    List<TbLogistics> findAll();

    List<TbLogistics> selectList();
}
