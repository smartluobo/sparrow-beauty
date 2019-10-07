package com.chaomeis.sparrowbeauty.cms.service.activity;

import com.chaomeis.sparrowbeauty.entity.TbActivityGoods;
import com.chaomeis.sparrowbeauty.mapper.TbActivityGoodsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GoodsActivityService {
    @Resource
    private TbActivityGoodsMapper tbActivityGoodsMapper;

    public void createGoodsActivity (TbActivityGoods record) {
        tbActivityGoodsMapper.insertSelective(record);
    }
}
