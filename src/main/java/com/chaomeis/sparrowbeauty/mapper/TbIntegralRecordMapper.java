package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbIntegralRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface TbIntegralRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbIntegralRecord record);

    int insertSelective(TbIntegralRecord record);

    TbIntegralRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbIntegralRecord record);

    int updateByPrimaryKey(TbIntegralRecord record);
}