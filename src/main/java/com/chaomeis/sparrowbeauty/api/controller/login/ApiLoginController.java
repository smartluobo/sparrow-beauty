package com.chaomeis.sparrowbeauty.api.controller.login;

import com.chaomeis.sparrowbeauty.api.service.login.ApiLoginService;
import com.chaomeis.sparrowbeauty.api.service.user.ApiUserService;
import com.chaomeis.sparrowbeauty.response.ResultInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("api/user")
public class ApiLoginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiLoginController.class);

    @Resource
    private ApiLoginService apiLoginService;
    @Resource
    private ApiUserService apiUserService;
    @RequestMapping("/login")
    public ResultInfo login(@RequestBody Map<String,String> codeParam){
        LOGGER.info("api user login call.....");
        String code = null;
        try {
            if (CollectionUtils.isEmpty(codeParam)){
                return ResultInfo.newEmptyResultInfo();
            }
            code = codeParam.get("code");
            if (StringUtils.isEmpty(code)){
                return ResultInfo.newEmptyResultInfo();
            }
            ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
            String oppenId = apiLoginService.login(code);
            String referrerOppenId = codeParam.get("referrerOppenId");
            if (!StringUtils.isEmpty(oppenId)){
                // TODO: 2019/9/28 该openId 为微信用户openId 使用该openId组装一个user对象插入表，返回openId给前端
                apiUserService.saveApiUser(oppenId, referrerOppenId);
                resultInfo.setData(oppenId);
                return resultInfo;
            }
            return ResultInfo.newFailResultInfo();
        }catch (Exception e){
            LOGGER.error("login happen exception code : {}",code,e);
            return ResultInfo.newExceptionResultInfo();
        }
    }
}
