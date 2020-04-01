package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbCoupons;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TbCouponsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbCoupons record);

    TbCoupons selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(TbCoupons record);

    List<TbCoupons> findAll();

    List<TbCoupons> selectCouponsList(TbCoupons tbCoupons);
}
