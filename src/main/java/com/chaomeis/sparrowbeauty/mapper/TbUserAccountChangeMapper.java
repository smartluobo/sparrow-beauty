package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbUserAccountChange;

public interface TbUserAccountChangeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbUserAccountChange record);

    int insertSelective(TbUserAccountChange record);

    TbUserAccountChange selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbUserAccountChange record);

    int updateByPrimaryKey(TbUserAccountChange record);
}