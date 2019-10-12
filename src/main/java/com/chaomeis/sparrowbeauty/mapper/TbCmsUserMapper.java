package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbCmsUser;
import org.springframework.stereotype.Repository;

@Repository
public interface TbCmsUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbCmsUser record);

    int insertSelective(TbCmsUser record);

    TbCmsUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbCmsUser record);

    int updateByPrimaryKey(TbCmsUser record);

    TbCmsUser findUserByLoginName(String loginName);
}