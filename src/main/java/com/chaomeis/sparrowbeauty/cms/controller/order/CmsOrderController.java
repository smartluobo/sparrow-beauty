package com.chaomeis.sparrowbeauty.cms.controller.order;

import com.chaomeis.sparrowbeauty.cms.service.order.CmsOrderService;
import com.chaomeis.sparrowbeauty.common.BaseController;
import com.chaomeis.sparrowbeauty.common.PageReqVO;
import com.chaomeis.sparrowbeauty.common.PageRespDto;
import com.chaomeis.sparrowbeauty.entity.TbGoods;
import com.chaomeis.sparrowbeauty.entity.TbOrder;
import com.chaomeis.sparrowbeauty.entity.TbOrderDetail;
import com.chaomeis.sparrowbeauty.entity.TbSkuDetail;
import com.chaomeis.sparrowbeauty.mapper.TbOrderDetailMapper;
import com.chaomeis.sparrowbeauty.response.ResultInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping("cms/order")
public class CmsOrderController extends BaseController {
    @Resource
    private CmsOrderService cmsOrderService;
    @Resource
    private TbOrderDetailMapper tbOrderDetailMapper;
    /**
     * 查询订单列表
     * @param page
     * @return 订单分页列表信息
     */
    @RequestMapping("/findPage")
    public PageRespDto<TbOrder> findOrderPageList (PageReqVO<TbOrder> page) {
        return cmsOrderService.findOrderPageList(page);
    }

    @RequestMapping(value = "/update")
    public ResultInfo updateOrder (@RequestBody TbOrder order) {
        if (StringUtils.isBlank(order.getOrderId())) {
            return ResultInfo.newRepeatResultInfo("订单Id不能为空");
        }
        cmsOrderService.updateOrder(order);
        // 查询某个订单明细
        List<TbOrderDetail> orderDetailList = tbOrderDetailMapper.findOrderDetailByOrderId(order.getOrderId());
        // 筛选出需要删除的订单明细
        List<TbOrderDetail> deletList = removeAll(orderDetailList,order.getOrderDetails());
        for (TbOrderDetail delete : deletList) {
            tbOrderDetailMapper.deleteByPrimaryKey(delete.getId());
        }
        if (!CollectionUtils.isEmpty(order.getOrderDetails())) {
            // 需要更新或者插入的明细
            for (TbOrderDetail orderDetail : order.getOrderDetails()) {
                if (null != orderDetail.getId()) {
                    TbOrderDetail findorderDetail = tbOrderDetailMapper.selectByPrimaryKey(orderDetail.getId());
                    if (null != findorderDetail) { // 如果数据库存在该数据则更新
                        orderDetail.setOrderId(order.getOrderId());
                        tbOrderDetailMapper.updateByPrimaryKey(orderDetail);
                    }
                } else {
                    orderDetail.setOrderId(order.getOrderId()); // 如果数据库不存在该数据则插入
                    tbOrderDetailMapper.insert(orderDetail);
                }
            }
        }
        return ResultInfo.newSuccessResultInfo();
    }

    @RequestMapping(value = "/delete")
    public ResultInfo deleteOrder (String orderId) {
        if (StringUtils.isBlank(orderId)) {
            return ResultInfo.newRepeatResultInfo("订单Id不能为空");
        }
        cmsOrderService.deleteOrder(orderId);
        return ResultInfo.newSuccessResultInfo();
    }

    @RequestMapping(value = "/findInfo")
    public ResultInfo findOrderInfo (String orderId) {
        if (StringUtils.isBlank(orderId)) {
            return ResultInfo.newRepeatResultInfo("订单Id不能为空");
        }
        TbOrder Order= cmsOrderService.findOrderInfo(orderId);
        ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
        resultInfo.setData(Order);
        return resultInfo;
    }

    // 删除左边重复的元素，返回左边
    private List<TbOrderDetail> removeAll(List<TbOrderDetail> left, List<TbOrderDetail> right){
        List<TbOrderDetail> res = new LinkedList<>(left);
        Set<Integer> set = new HashSet<>();
        for(TbOrderDetail dataPermission : right){
            set.add(dataPermission.getId());
        }
        Iterator<TbOrderDetail> iter = res.iterator();
        while(iter.hasNext()){
            if(set.contains(iter.next().getId())){
                iter.remove();
            }
        }
        return res;
    }
}
