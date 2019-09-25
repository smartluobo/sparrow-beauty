package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbUserPayRecord;

public interface TbUserPayRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbUserPayRecord record);

    int insertSelective(TbUserPayRecord record);

    TbUserPayRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbUserPayRecord record);

    int updateByPrimaryKey(TbUserPayRecord record);
}