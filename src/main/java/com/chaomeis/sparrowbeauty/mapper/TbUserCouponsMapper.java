package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbUserCoupons;

public interface TbUserCouponsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbUserCoupons record);

    int insertSelective(TbUserCoupons record);

    TbUserCoupons selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbUserCoupons record);

    int updateByPrimaryKey(TbUserCoupons record);
}