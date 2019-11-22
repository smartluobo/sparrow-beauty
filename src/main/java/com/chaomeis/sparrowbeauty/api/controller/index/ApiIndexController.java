package com.chaomeis.sparrowbeauty.api.controller.index;

import com.chaomeis.sparrowbeauty.api.service.index.ApiIndexService;
import com.chaomeis.sparrowbeauty.response.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/api/index")
public class ApiIndexController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiIndexController.class);

    @Resource
    private ApiIndexService apiIndexService;

    @RequestMapping("/getIndexInfo")
    public ResultInfo getIndexInfo(@RequestBody Map<String,String> params){
        try {
            ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
            Map<String,Object> resultMap = apiIndexService.getIndexInfo(params);
            resultInfo.setData(resultMap);
            return resultInfo;
        }catch (Exception e){
            LOGGER.error("findGoodsList happen exception ",e);
            return ResultInfo.newExceptionResultInfo();
        }
    }
}
