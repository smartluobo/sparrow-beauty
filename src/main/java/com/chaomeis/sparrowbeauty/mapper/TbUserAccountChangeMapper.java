package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbUserAccountChange;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TbUserAccountChangeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbUserAccountChange record);

    TbUserAccountChange selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(TbUserAccountChange record);

    List<TbUserAccountChange> getUserAccountRecord(@Param("openId") String openId, @Param("direction") String direction);
}