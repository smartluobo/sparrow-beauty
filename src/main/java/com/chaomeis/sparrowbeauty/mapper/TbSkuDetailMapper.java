package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbSkuDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbSkuDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbSkuDetail record);

    int insertSelective(TbSkuDetail record);

    TbSkuDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbSkuDetail record);

    int updateByPrimaryKey(TbSkuDetail record);

    List<TbSkuDetail> findSkuDetailBySkuTypeId(Integer id);
}