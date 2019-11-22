package com.chaomeis.sparrowbeauty.api.service.sign;

import com.chaomeis.sparrowbeauty.config.CmsSysProperties;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class ApiSignInService {

    @Resource
    private CmsSysProperties cmsSysProperties;

    public Map<String, Object> getSignInImage(Map<String, String> params) {
        Map<String,Object> resultMap = new HashMap<>();
        String signInImageUrl = cmsSysProperties.getImageUrlPrefix()+"page/signInImage.png";
        resultMap.put("signInImageUrl",signInImageUrl);
        return resultMap;
    }

    public Map<String, Object> userSignIn(Map<String, String> params) {
        //todo 执行用户签到获取积分操作，若用户当日已经签到不可重复签到
        return null;
    }
}
