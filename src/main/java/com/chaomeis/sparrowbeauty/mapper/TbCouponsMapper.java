package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbCoupons;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TbCouponsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbCoupons record);

    int insertSelective(TbCoupons record);

    TbCoupons selectByPrimaryKey(Integer id);

    List<TbCoupons> selectCouponsList(TbCoupons record);

    int updateByPrimaryKeySelective(TbCoupons record);

    int updateByPrimaryKey(TbCoupons record);
}