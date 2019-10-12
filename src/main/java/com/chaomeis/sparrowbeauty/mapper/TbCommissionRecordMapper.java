package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbCommissionRecord;

public interface TbCommissionRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbCommissionRecord record);

    int insertSelective(TbCommissionRecord record);

    TbCommissionRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbCommissionRecord record);

    int updateByPrimaryKey(TbCommissionRecord record);
}