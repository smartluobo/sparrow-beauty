package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbApiUser;
import org.springframework.stereotype.Repository;

@Repository
public interface TbApiUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbApiUser record);

    TbApiUser selectByPrimaryKey(Integer id);

    int updateOpenIdSelective(TbApiUser record);

    int updateByPrimaryKey(TbApiUser record);

    TbApiUser selectByOpenId(String openId);
}
