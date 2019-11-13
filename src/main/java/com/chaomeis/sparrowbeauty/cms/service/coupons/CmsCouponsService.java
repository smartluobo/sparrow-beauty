package com.chaomeis.sparrowbeauty.cms.service.coupons;

import com.chaomeis.sparrowbeauty.common.PageReqVO;
import com.chaomeis.sparrowbeauty.common.PageRespDto;
import com.chaomeis.sparrowbeauty.entity.TbCoupons;
import com.chaomeis.sparrowbeauty.entity.TbGoods;
import com.chaomeis.sparrowbeauty.mapper.TbCouponsMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 券管理
 */
@Service
public class CmsCouponsService {
    @Resource
    private TbCouponsMapper tbCouponsMapper;

    /**
     * 创建活动券
     * @param coupons
     */
    public void createCoupons (TbCoupons coupons) {
        tbCouponsMapper.insert(coupons);
    }

    /**
     * 更新活动券
     * @param coupons
     */
    public void updateCoupons(TbCoupons coupons) {
        tbCouponsMapper.updateByPrimaryKey(coupons);
    }

    /**
     * 查询活动券详情
     * @param couponsId
     * @return
     */
    public TbCoupons findCouponsInfo (Integer couponsId) {
        TbCoupons coupons = tbCouponsMapper.selectByPrimaryKey(couponsId);
        return coupons;
    }

    /**
     * 删除活动券
     */
    public void deleteCoupons(Integer couponsId) {
        tbCouponsMapper.deleteByPrimaryKey(couponsId);
    }

    /**
     * 分页查询活动列表
     * @param page
     * @return
     */
    public PageRespDto<TbCoupons> findCouponsPageList(PageReqVO<TbCoupons> page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<TbCoupons> couponsPage = tbCouponsMapper.selectCouponsList(page.getCondition());
        PageRespDto<TbCoupons> pageList = new PageRespDto(couponsPage);
        return pageList;
    }

}
