package com.chaomeis.sparrowbeauty.cms.service.activity;

import com.chaomeis.sparrowbeauty.common.PageReqVO;
import com.chaomeis.sparrowbeauty.common.PageRespDto;
import com.chaomeis.sparrowbeauty.entity.TbActivity;
import com.chaomeis.sparrowbeauty.entity.TbActivityGoods;
import com.chaomeis.sparrowbeauty.entity.TbGoods;
import com.chaomeis.sparrowbeauty.mapper.TbActivityGoodsMapper;
import com.chaomeis.sparrowbeauty.mapper.TbActivityMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ActivityService {
    @Resource
    private TbActivityMapper tbActivityMapper;

    /**
     * 创建活动
     * @param record
     */
    public void createActivity (TbActivity record) {
        tbActivityMapper.insertSelective(record);
    }
    /**
     * 更新活动
     * @param record
     */
    public void updateActivity (TbActivity record) {
        tbActivityMapper.updateByPrimaryKeySelective(record);
    }
    /**
     * 删除活动
     * @param id
     */
    public void deleteActivity (Integer id) {
        tbActivityMapper.deleteByPrimaryKey(id);
    }
    /**
     * 活动详情
     * @param id
     */
    public TbActivity findActivity (Integer id) {
        TbActivity activity = tbActivityMapper.selectByPrimaryKey(id);
        return activity;
    }

    /**
     * 查询活动列表分页
     * @param page
     * @return
     */
    public PageRespDto<TbActivity> findGoodsPageList(PageReqVO<TbActivity> page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<TbActivity> goodsPage = tbActivityMapper.selectList(page.getCondition());
        PageRespDto<TbActivity> pageList = new PageRespDto(goodsPage);
        return pageList;
    }
}
