package com.chaomeis.sparrowbeauty.api.service.integral;

import com.chaomeis.sparrowbeauty.entity.TbUserAccountChange;
import com.chaomeis.sparrowbeauty.mapper.TbIntegralRecordMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ApiIntegralService {

    @Resource
    private TbIntegralRecordMapper tbIntegralRecordMapper;

    public void countUserIntegralByOpenId(String openId) {
        //todo 根据用户openId查询用户的积分信息 需要返回可用积分和冻结积分两个字段
        return;
    }

    public List<TbUserAccountChange> getUserIntegralRecord(String openId, String direction) {
        return null;
    }
}
