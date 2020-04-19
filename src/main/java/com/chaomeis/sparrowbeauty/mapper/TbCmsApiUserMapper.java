package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbCmsApiUser;
import com.chaomeis.sparrowbeauty.entity.TbGoods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbCmsApiUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbCmsApiUser record);

    TbCmsApiUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(TbCmsApiUser record);

    List<TbCmsApiUser> selectList(TbCmsApiUser condition);
}
