package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbActivityGoods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbActivityGoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteGoodsId(Integer goodId);

    int insert(TbActivityGoods record);

    TbActivityGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(TbActivityGoods record);

    TbActivityGoods selectActivityGoods(TbActivityGoods record);

    List<TbActivityGoods> selectActivityGoodsList(TbActivityGoods record);
}