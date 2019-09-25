package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbActivity;

public interface TbActivityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbActivity record);

    int insertSelective(TbActivity record);

    TbActivity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbActivity record);

    int updateByPrimaryKey(TbActivity record);
}