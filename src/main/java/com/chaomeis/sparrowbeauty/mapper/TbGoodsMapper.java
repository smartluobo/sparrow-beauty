package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbGoods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbGoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbGoods record);

    TbGoods selectByPrimaryKey(Integer id);

    List<TbGoods> selectList(TbGoods record);

    int updateByPrimaryKey(TbGoods record);

    List<TbGoods> findAll();

    /**
     * 查询参加活动的商品列表
     * @param activityId 活动id
     * @return
     */
    List<TbGoods> findActivityGoods(Integer activityId);
}
