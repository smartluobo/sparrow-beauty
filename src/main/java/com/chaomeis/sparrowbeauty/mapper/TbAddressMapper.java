package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbAddress;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TbAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteUserAddress(Map<String,String> params);

    int insert(TbAddress record);

    TbAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(TbAddress record);

    int updateUserAddress(TbAddress record);

    List<TbAddress> selectUserAddressList(String openId);
}