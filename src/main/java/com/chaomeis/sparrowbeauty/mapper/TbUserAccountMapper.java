package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbUserAccount;

public interface TbUserAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbUserAccount record);

    TbUserAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(TbUserAccount record);
}