package com.chaomeis.sparrowbeauty.api.controller.sign;

import com.chaomeis.sparrowbeauty.api.service.sign.ApiSignInService;
import com.chaomeis.sparrowbeauty.api.service.user.ApiUserService;
import com.chaomeis.sparrowbeauty.entity.TbApiUser;
import com.chaomeis.sparrowbeauty.response.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/api/sign")
public class ApiSignInController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiSignInController.class);

    @Resource
    private ApiSignInService apiSignInService;

    @Resource
    private ApiUserService apiUserService;

    /**
     * 首页点击签到icon调用该接口，第一期不做连续签到积分倍增功能，无需判断用户是否连续签到。直接返回静态图片。
     * @param params 请求参数
     * @return 返回静态图片地址
     */

    @RequestMapping("/getSignInImage")
    public ResultInfo getSignInImage(@RequestBody Map<String,String> params){
        try {
            ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
            Map<String,Object> resultMap = apiSignInService.getSignInImage(params);
            resultInfo.setData(resultMap);
            return resultInfo;
        }catch (Exception e){
            LOGGER.error("findGoodsList happen exception ",e);
            return ResultInfo.newExceptionResultInfo();
        }
    }

    @RequestMapping("/userSignIn")
    public ResultInfo userSignIn(@RequestBody Map<String,String> params){
        try {
            ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();

            if (CollectionUtils.isEmpty(params)){
                return ResultInfo.newEmptyParamsResultInfo();
            }

            TbApiUser user = apiUserService.findApiUserByOpenId(params.get("openId"));
            if (user == null){
                LOGGER.error("findApiUserByOpenId result is null openId : {}",params.get("openId"));
                return ResultInfo.newEmptyResultInfo();
            }

            Map<String,Object> resultMap = apiSignInService.userSignIn(params);
            resultInfo.setData(resultMap);
            return resultInfo;
        }catch (Exception e){
            LOGGER.error("findGoodsList happen exception ",e);
            return ResultInfo.newExceptionResultInfo();
        }
    }

}
