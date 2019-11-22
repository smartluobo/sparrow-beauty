package com.chaomeis.sparrowbeauty.api.controller.integral;

import com.chaomeis.sparrowbeauty.api.service.integral.ApiIntegralService;
import com.chaomeis.sparrowbeauty.entity.TbUserAccountChange;
import com.chaomeis.sparrowbeauty.response.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/integral")
public class ApiIntegralController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiIntegralController.class);

    @Resource
    private ApiIntegralService apiIntegralService;

    @RequestMapping("/getUserIntegralRecord")
    public ResultInfo getUserIntegralRecord(@RequestBody Map<String,String> params){
        try {
            if (CollectionUtils.isEmpty(params)){
                return ResultInfo.newEmptyParamsResultInfo();
            }

            ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
            String openId = params.get("openId");
            String direction = params.get("direction");
            List<TbUserAccountChange> userAccountRecords = apiIntegralService.getUserIntegralRecord(openId,direction);
            resultInfo.setData(userAccountRecords);
            return resultInfo;
        }catch (Exception e){
            LOGGER.error("findGoodsList happen exception ",e);
            return ResultInfo.newExceptionResultInfo();
        }
    }
}
