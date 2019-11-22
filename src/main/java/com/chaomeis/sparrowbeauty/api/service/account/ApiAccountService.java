package com.chaomeis.sparrowbeauty.api.service.account;

import com.chaomeis.sparrowbeauty.entity.TbUserAccountChange;
import com.chaomeis.sparrowbeauty.mapper.TbUserAccountChangeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ApiAccountService {

    @Resource
    private TbUserAccountChangeMapper tbUserAccountChangeMapper;

    public void findUserAccountInfoByOpenId(String openId) {
        //todo 根据用户openId查询用户的账户信息，需要返回可提现金额和冻结金额
        return;
    }

    public List<TbUserAccountChange> getUserAccountRecord(String openId,String direction) {
        //todo 查询语句还未写,按照创建日期逆序排序，第一期可以不考虑做分页
        return tbUserAccountChangeMapper.getUserAccountRecord(openId,direction);
    }
}
