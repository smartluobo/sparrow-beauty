package com.chaomeis.sparrowbeauty;

import com.chaomeis.sparrowbeauty.entity.TbGoods;
import com.chaomeis.sparrowbeauty.mapper.TbGoodsMapper;
import org.junit.Test;

import javax.annotation.Resource;

public class MapperTest extends BaseTest {

    @Resource
    private TbGoodsMapper tbGoodsMapper;


    @Test
    public void testMapper(){
        tbGoodsMapper.selectList(new TbGoods());
    }

}
