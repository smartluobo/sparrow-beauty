package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbActivity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbActivityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbActivity record);

    int insertSelective(TbActivity record);

    TbActivity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbActivity record);

    int updateByPrimaryKey(TbActivity record);
    // 查询当前时间内有效的活动,异常情况多个活动同时满足是取其中一个活动
    TbActivity selectValidActivityy();

    List<TbActivity> selectList(TbActivity record);
}