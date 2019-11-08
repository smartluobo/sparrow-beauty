package com.chaomeis.sparrowbeauty.api.controller.address;

import com.chaomeis.sparrowbeauty.api.paramVo.CartOrderParamVo;
import com.chaomeis.sparrowbeauty.api.service.address.ApiAddressService;
import com.chaomeis.sparrowbeauty.entity.TbAddress;
import com.chaomeis.sparrowbeauty.response.ResultInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
        apiAddressService.updateUserAddress(address);
        return ResultInfo.newSuccessResultInfo();
    }
    /**
     * 删除
     * @param params 地址信息 根据用户和地址id删除
     * @return
     */
    @RequestMapping("/deleteAddress")
    public ResultInfo deleteAddress(@RequestParam Map<String,String> params){

        if (CollectionUtils.isEmpty(params) || StringUtils.isEmpty(params.get("addressId"))
                || StringUtils.isEmpty(params.get("openId"))){
            LOGGER.error("deleteAddress params is null");
            return ResultInfo.newEmptyParamsResultInfo();
        }
        apiAddressService.deleteAddress(params);
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
