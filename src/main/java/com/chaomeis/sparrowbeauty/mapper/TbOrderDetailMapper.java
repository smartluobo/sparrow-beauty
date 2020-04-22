package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbOrderDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbOrderDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbOrderDetail record);

    TbOrderDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(TbOrderDetail record);

    List<TbOrderDetail> findOrderDetailByOrderId(String orderId);
}