package com.chaomeis.sparrowbeauty.api.service.coupons;

import com.chaomeis.sparrowbeauty.common.PageReqVO;
import com.chaomeis.sparrowbeauty.common.PageRespDto;
import com.chaomeis.sparrowbeauty.entity.TbActivity;
import com.chaomeis.sparrowbeauty.entity.TbUserCoupons;
import com.chaomeis.sparrowbeauty.mapper.TbUserCouponsMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ApiCouponsService {
    @Resource
    private TbUserCouponsMapper tbUserCouponsMapper;

    public PageRespDto<TbUserCoupons> findUserCouponsPageList (PageReqVO<TbUserCoupons> page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<TbUserCoupons> list = tbUserCouponsMapper.selectPageList(page.getCondition());
        PageRespDto<TbUserCoupons> pageList = new PageRespDto(list);
        return pageList;
    }
}
