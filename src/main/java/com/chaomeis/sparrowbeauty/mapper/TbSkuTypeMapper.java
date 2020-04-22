package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbSkuType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbSkuTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbSkuType record);

    TbSkuType selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(TbSkuType record);

    List<TbSkuType> findSkuTypeByIds(List<String> ids);

    List<TbSkuType> findSkuTypeList(TbSkuType record);
}