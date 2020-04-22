package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbUserWithdrawalRecord;

public interface TbUserWithdrawalRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbUserWithdrawalRecord record);

    TbUserWithdrawalRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(TbUserWithdrawalRecord record);
}