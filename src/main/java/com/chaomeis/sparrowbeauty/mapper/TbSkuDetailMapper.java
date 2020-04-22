package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbSkuDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbSkuDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteSkuTypeId(Integer skuTypeId);

    int insert(TbSkuDetail record);

    TbSkuDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(TbSkuDetail record);

    List<TbSkuDetail> findSkuDetailBySkuTypeId(Integer id);
}