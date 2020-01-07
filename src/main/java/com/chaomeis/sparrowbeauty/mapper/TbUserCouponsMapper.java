package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbUserCoupons;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbUserCouponsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbUserCoupons record);

    int insertSelective(TbUserCoupons record);

    TbUserCoupons selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbUserCoupons record);

    int updateByPrimaryKey(TbUserCoupons record);

    TbUserCoupons selectUserCoupons(TbUserCoupons record);

    List<TbUserCoupons> selectPageList(TbUserCoupons record);
}