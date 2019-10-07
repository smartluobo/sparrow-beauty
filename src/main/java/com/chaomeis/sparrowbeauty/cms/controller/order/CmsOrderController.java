package com.chaomeis.sparrowbeauty.cms.controller.order;

import com.chaomeis.sparrowbeauty.cms.service.order.CmsOrderService;
import com.chaomeis.sparrowbeauty.common.BaseController;
import com.chaomeis.sparrowbeauty.common.PageReqVO;
import com.chaomeis.sparrowbeauty.common.PageRespDto;
import com.chaomeis.sparrowbeauty.entity.TbGoods;
import com.chaomeis.sparrowbeauty.entity.TbOrder;
import com.chaomeis.sparrowbeauty.response.ResultInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("cms/order")
public class CmsOrderController extends BaseController {
    @Resource
    private CmsOrderService cmsOrderService;

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
        return ResultInfo.newSuccessResultInfo();
    }

    @RequestMapping(value = "/delete")
    public ResultInfo deleteOrder (@RequestBody String orderId) {
        if (StringUtils.isBlank(orderId)) {
            return ResultInfo.newRepeatResultInfo("订单Id不能为空");
        }
        cmsOrderService.deleteOrder(orderId);
        return ResultInfo.newSuccessResultInfo();
    }

    @RequestMapping(value = "/findInfo")
    public ResultInfo findOrderInfo (@RequestBody String orderId) {
        if (StringUtils.isBlank(orderId)) {
            return ResultInfo.newRepeatResultInfo("订单Id不能为空");
        }
        cmsOrderService.findOrderInfo(orderId);
        return ResultInfo.newSuccessResultInfo();
    }
}
