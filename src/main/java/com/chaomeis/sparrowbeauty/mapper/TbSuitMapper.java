package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbSuit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbSuitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbSuit record);

    int insertSelective(TbSuit record);

    TbSuit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbSuit record);

    int updateByPrimaryKey(TbSuit record);

    List<TbSuit> findAll();

}