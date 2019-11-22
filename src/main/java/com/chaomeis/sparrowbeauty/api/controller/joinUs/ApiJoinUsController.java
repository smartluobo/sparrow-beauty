package com.chaomeis.sparrowbeauty.api.controller.joinUs;

import com.chaomeis.sparrowbeauty.config.CmsSysProperties;
import com.chaomeis.sparrowbeauty.response.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/joinUs")
public class ApiJoinUsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiJoinUsController.class);

    @Resource
    private CmsSysProperties cmsSysProperties;

    /**
     * 小程序首页点击加入我们icon 调用该接口返回静态图片，介绍加入我们流程
     * @param params 请求参数
     * @return 返回加入我们静态图片地址
     */
    @RequestMapping("/getJoinUsImage")
    public ResultInfo getJoinUsImage(@RequestBody Map<String,String> params){
        try {
            ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
            Map<String,Object> resultMap = new HashMap<>();
            String joinUsImage = cmsSysProperties.getImageUrlPrefix()+"page/joinUsImage.png";
            resultMap.put("joinUsImage",joinUsImage);
            resultInfo.setData(resultMap);
            return resultInfo;
        }catch (Exception e){
            LOGGER.error("findGoodsList happen exception ",e);
            return ResultInfo.newExceptionResultInfo();
        }
    }
}
