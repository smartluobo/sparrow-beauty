package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbAddress;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbAddress record);

    int insertSelective(TbAddress record);

    TbAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbAddress record);

    int updateByPrimaryKey(TbAddress record);

    List<TbAddress> selectUserAddressList(String openId);
}