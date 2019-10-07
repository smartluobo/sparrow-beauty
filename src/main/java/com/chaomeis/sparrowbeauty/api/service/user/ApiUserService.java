package com.chaomeis.sparrowbeauty.api.service.user;

import com.chaomeis.sparrowbeauty.entity.TbApiUser;
import com.chaomeis.sparrowbeauty.mapper.TbApiUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ApiUserService {

    @Resource
    private TbApiUserMapper tbApiUserMapper;

    public TbApiUser findApiUserByOpenId(String openId){
        return tbApiUserMapper.tbApiUserMapper(openId);
    }
}
