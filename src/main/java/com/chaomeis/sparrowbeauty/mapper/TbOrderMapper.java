package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbOrderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(TbOrder record);

    TbOrder selectByPrimaryKey(String orderId);

    int updateByPrimaryKey(TbOrder record);

    List<TbOrder> findOrderByOpenId(String openId);

    void cancelOrder(@Param("openId") String openId, @Param("orderId") String orderId);

    List<TbOrder> selectList (TbOrder record);

    TbOrder findOrderDetail(TbOrder record);
}