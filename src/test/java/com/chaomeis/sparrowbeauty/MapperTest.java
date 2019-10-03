package com.chaomeis.sparrowbeauty;

import com.chaomeis.sparrowbeauty.api.controller.TestController;
import com.chaomeis.sparrowbeauty.common.BaseController;
import com.chaomeis.sparrowbeauty.entity.TbGoods;
import com.chaomeis.sparrowbeauty.mapper.TbGoodsMapper;
import org.junit.Test;

import javax.annotation.Resource;

public class MapperTest extends BaseTest {

    @Resource
    private TbGoodsMapper tbGoodsMapper;

    @Resource
    private TestController testController;


    @Test
    public void testMapper(){
        tbGoodsMapper.selectList(new TbGoods());
    }

    @Test
    public void testController(){
        testController.testcontroller(2,10,new TbGoods());
    }
}
