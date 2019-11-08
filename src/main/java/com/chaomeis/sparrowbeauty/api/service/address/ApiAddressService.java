package com.chaomeis.sparrowbeauty.api.service.address;

import com.chaomeis.sparrowbeauty.entity.TbAddress;
import com.chaomeis.sparrowbeauty.mapper.TbAddressMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ApiAddressService {

    @Resource
    private TbAddressMapper tbAddressMapper;

    /**
     * 创建收货地址
     * @param address
     */
    public void createAddress (TbAddress address){
        tbAddressMapper.insert(address);
    }

    /**
     *  修改收货地址
     * @param address
     */
    public void updateUserAddress (TbAddress address){
        tbAddressMapper.updateUserAddress(address);
    }

    /**
     * 删除收货地址 根据openId 和 addressId 地址id
     * @param params
     */
    public void deleteAddress (Map<String,String> params){
        tbAddressMapper.deleteUserAddress(params);
    }
    /**
     * 查询用户货地址
     * @param openId
     */
    public List<TbAddress> selectAddress (String openId){
        List<TbAddress> userAddressList = tbAddressMapper.selectUserAddressList(openId);
        return userAddressList;
    }
}
