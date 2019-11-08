package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbCart;
import org.springframework.stereotype.Repository;

@Repository
public interface TbCartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbCart record);

    int insertSelective(TbCart record);

    TbCart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbCart record);

    int updateByPrimaryKey(TbCart record);
}