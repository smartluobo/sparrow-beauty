package com.chaomeis.sparrowbeauty.mapper;

import com.chaomeis.sparrowbeauty.entity.TbDealerLevel;

public interface TbDealerLevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbDealerLevel record);

    TbDealerLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(TbDealerLevel record);
}