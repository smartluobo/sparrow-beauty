package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbCart;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TbCartMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteUserCart(Map<String,String> params);

    int insert(TbCart record);

    TbCart selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(TbCart record);

    int updateUserCart(TbCart record);

    List<TbCart> selectUserCartList(String openId);
}