package com.chaomeis.sparrowbeauty.api.service.address;

import com.chaomeis.sparrowbeauty.entity.TbAddress;
import com.chaomeis.sparrowbeauty.mapper.TbAddressMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ApiAddressService {

    @Resource
    private TbAddressMapper TbAddressMapper;

    /**
     * 创建收货地址
     * @param address
     */
    public void createAddress (TbAddress address){
        TbAddressMapper.insert(address);
    }

    /**
     *  修改收货地址
     * @param address
     */
    public void updateAddress (TbAddress address){
        TbAddressMapper.updateByPrimaryKey(address);
    }

    /**
     * 删除收货地址
     * @param addressId
     */
    public void deleteAddress (Integer addressId){
        TbAddressMapper.deleteByPrimaryKey(addressId);
    }
    /**
     * 查询用户货地址
     * @param openId
     */
    public List<TbAddress> selectAddress (String openId){
        List<TbAddress> userAddressList = TbAddressMapper.selectUserAddressList(openId);
        return userAddressList;
    }
}
