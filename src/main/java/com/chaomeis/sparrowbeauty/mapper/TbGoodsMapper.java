package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbGoods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbGoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbGoods record);

    int insertSelective(TbGoods record);

    TbGoods selectByPrimaryKey(Integer id);

    List<TbGoods> selectList(TbGoods record);

    int updateByPrimaryKeySelective(TbGoods record);

    int updateByPrimaryKey(TbGoods record);
}