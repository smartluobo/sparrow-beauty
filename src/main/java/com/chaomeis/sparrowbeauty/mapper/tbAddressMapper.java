package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.tbAddress;

public interface tbAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(tbAddress record);

    int insertSelective(tbAddress record);

    tbAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(tbAddress record);

    int updateByPrimaryKey(tbAddress record);
}