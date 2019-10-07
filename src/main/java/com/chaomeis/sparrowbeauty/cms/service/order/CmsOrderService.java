package com.chaomeis.sparrowbeauty.cms.service.order;

import com.chaomeis.sparrowbeauty.common.PageReqVO;
import com.chaomeis.sparrowbeauty.common.PageRespDto;
import com.chaomeis.sparrowbeauty.entity.TbOrder;
import com.chaomeis.sparrowbeauty.mapper.TbOrderMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CmsOrderService {
    @Resource
    private TbOrderMapper tbOrderMapper;

    /**
     * 查询订单列表
     * @param page 分页参数
     * @return 分页信息
     */
    public PageRespDto<TbOrder> findOrderPageList(PageReqVO<TbOrder> page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<TbOrder> orderPage = tbOrderMapper.selectList(page.getCondition());
        PageRespDto<TbOrder> pageList = new PageRespDto(orderPage);
        return pageList;
    }

    /**
     * 查询订单详情
     * @param orderId 订单id
     * @return 订单信息
     */
    public TbOrder findOrderInfo (String orderId) {
        return tbOrderMapper.selectByPrimaryKey(orderId);
    }

    /**
     * 根据订单id更新订单
     * @param order 订单信息
     */
    public void updateOrder (TbOrder order) {
        tbOrderMapper.updateByPrimaryKey(order);
    }

    /**
     * 根据订单Id删除订单
     * @param orderId 订单id
     */
    public void deleteOrder (String orderId) {
        tbOrderMapper.deleteByPrimaryKey(orderId);
    }

}
