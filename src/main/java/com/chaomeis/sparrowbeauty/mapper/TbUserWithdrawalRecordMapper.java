package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbUserWithdrawalRecord;

public interface TbUserWithdrawalRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbUserWithdrawalRecord record);

    int insertSelective(TbUserWithdrawalRecord record);

    TbUserWithdrawalRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbUserWithdrawalRecord record);

    int updateByPrimaryKey(TbUserWithdrawalRecord record);
}