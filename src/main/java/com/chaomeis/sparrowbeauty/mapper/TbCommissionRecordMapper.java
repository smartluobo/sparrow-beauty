package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbCommissionRecord;

public interface TbCommissionRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbCommissionRecord record);

    TbCommissionRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(TbCommissionRecord record);
}