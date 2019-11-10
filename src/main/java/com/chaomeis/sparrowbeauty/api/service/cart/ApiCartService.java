package com.chaomeis.sparrowbeauty.api.service.cart;

import com.chaomeis.sparrowbeauty.entity.TbCart;
import com.chaomeis.sparrowbeauty.mapper.TbCartMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ApiCartService {
    @Resource
    private TbCartMapper tbCartMapper;

    public void createUserCart (TbCart cart) {
        tbCartMapper.insert(cart);
    }
    /**
     * 删除用户购物车
     * @param params
     */
    public void deleteUserCart (Map<String,String> params) {
        tbCartMapper.deleteUserCart(params);
    }

    /**
     * 查询用户购物车列表
     */
    public List<TbCart> findUserCartList (String openId) {
        List<TbCart> userCartList = tbCartMapper.selectUserCartList(openId);
        return userCartList;
    }

    /**
     * 修改用户购物车
     */
    public void updateUserCartList (TbCart cart) {
        tbCartMapper.updateByPrimaryKey(cart);
    }
}
