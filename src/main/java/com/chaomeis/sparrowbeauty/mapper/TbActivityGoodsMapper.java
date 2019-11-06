package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbActivityGoods;
import org.springframework.stereotype.Repository;

@Repository
public interface TbActivityGoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbActivityGoods record);

    int insertSelective(TbActivityGoods record);

    TbActivityGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbActivityGoods record);

    int updateByPrimaryKey(TbActivityGoods record);

    TbActivityGoods selectActivityGoods(TbActivityGoods record);
}