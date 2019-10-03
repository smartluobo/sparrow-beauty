package com.chaomeis.sparrowbeauty.api.controller;

import com.chaomeis.sparrowbeauty.common.BaseController;
import com.chaomeis.sparrowbeauty.common.PageRespDto;
import com.chaomeis.sparrowbeauty.entity.TbGoods;
import com.chaomeis.sparrowbeauty.mapper.TbGoodsMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController extends BaseController {

    @Autowired
    private TbGoodsMapper tbGoodsMapper;

    @RequestMapping("/test")
    public PageRespDto<TbGoods> testcontroller (Integer pageNum, Integer pageSize,TbGoods tgoods) {
        PageHelper.startPage(pageNum, pageSize);
        List<TbGoods> goods =  tbGoodsMapper.selectList(tgoods);
        PageRespDto<TbGoods> list = new PageRespDto(goods);
        return list;
    }
}
