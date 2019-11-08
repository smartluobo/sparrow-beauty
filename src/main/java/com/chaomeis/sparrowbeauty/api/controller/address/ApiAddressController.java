package com.chaomeis.sparrowbeauty.api.controller.address;

import com.chaomeis.sparrowbeauty.api.paramVo.CartOrderParamVo;
import com.chaomeis.sparrowbeauty.api.service.address.ApiAddressService;
import com.chaomeis.sparrowbeauty.entity.TbAddress;
import com.chaomeis.sparrowbeauty.response.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户收货地址
 */
@RestController
@RequestMapping("api/address")
public class ApiAddressController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiAddressController.class);

    @Resource
    private ApiAddressService apiAddressService;
    /**
     * 创建收货地址
     * @param address 地址信息
     * @return
     */
    @RequestMapping("/createAddress")
    public ResultInfo createAddress(@RequestBody TbAddress address){
        if (address == null){
            LOGGER.error("createOrderByCart cartOrderParamVo is null");
            return ResultInfo.newEmptyParamsResultInfo();
        }
        apiAddressService.createAddress(address);
        return ResultInfo.newSuccessResultInfo();
    }

    /**
     * 修改收货地址
     * @param address 地址信息
     * @return
     */
    @RequestMapping("/updateAddress")
    public ResultInfo updateAddress(@RequestBody TbAddress address){
        if (address == null){
            LOGGER.error("createOrderByCart cartOrderParamVo is null");
            return ResultInfo.newEmptyParamsResultInfo();
        }
        apiAddressService.updateAddress(address);
        return ResultInfo.newSuccessResultInfo();
    }
    /**
     * 删除
     * @param addressId 地址信息
     * @return
     */
    @RequestMapping("/deleteAddress")
    public ResultInfo deleteAddress(Integer addressId){
        if (addressId == null){
            LOGGER.error("createOrderByCart cartOrderParamVo is null");
            return ResultInfo.newEmptyParamsResultInfo();
        }
        apiAddressService.deleteAddress(addressId);
        return ResultInfo.newSuccessResultInfo();
    }
    /**
     * 查询用户收货地址列表
     * @param openId 用户openId
     * @return 返回收货地址列表
     */
    @RequestMapping("/findUserAddress")
    public ResultInfo findUserAddress(String openId){
        if (openId == null){
            LOGGER.error("createOrderByCart cartOrderParamVo is null");
            return ResultInfo.newEmptyParamsResultInfo();
        }
        List<TbAddress> userAddressList = apiAddressService.selectAddress(openId);
        ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
        resultInfo.setData(userAddressList);
        return resultInfo;
    }
}
