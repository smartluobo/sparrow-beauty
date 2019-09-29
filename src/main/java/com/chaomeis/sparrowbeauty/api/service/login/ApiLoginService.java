package com.chaomeis.sparrowbeauty.api.service.login;

import com.alibaba.fastjson.JSONObject;
import com.chaomeis.sparrowbeauty.config.WechatInfoProperties;
import com.chaomeis.sparrowbeauty.utils.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ApiLoginService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiLoginService.class);

    @Resource
    private WechatInfoProperties wechatPayProperties;


    public String login(String code) {

        // 根据appid、secret、js_code、grant_type调用微信官方接口，获取openid
        String loginUrl = wechatPayProperties.getLoginUrl()
                +"appid="+wechatPayProperties.getAppId()
                +"&secret="+wechatPayProperties.getSecret()
                +"&js_code="+code;
        LOGGER.info("loginUrl : {}",loginUrl);

        String result = HttpUtil.get(loginUrl);
        LOGGER.info("result:{}", result);

        // 发送请求并解析
        JSONObject jsonObject = JSONObject.parseObject(result);
        Object openId = jsonObject.get("openid");
        if (openId != null){
            return openId.toString();
        }
        return null;
    }
}
