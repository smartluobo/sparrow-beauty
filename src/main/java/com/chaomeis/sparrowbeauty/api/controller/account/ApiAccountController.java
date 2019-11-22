package com.chaomeis.sparrowbeauty.api.controller.account;

import com.chaomeis.sparrowbeauty.api.service.account.ApiAccountService;
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
@RequestMapping("/api/account")
public class ApiAccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiAccountController.class);

    @Resource
    private ApiAccountService apiAccountService;


    @RequestMapping("/getUserAccountRecord")
    public ResultInfo getUserAccountRecord(@RequestBody Map<String,String> params){
        try {
            if (CollectionUtils.isEmpty(params)){
                return ResultInfo.newEmptyParamsResultInfo();
            }

            ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
            String openId = params.get("openId");
            String direction = params.get("direction");
           List<TbUserAccountChange> userAccountRecords = apiAccountService.getUserAccountRecord(openId,direction);
            resultInfo.setData(userAccountRecords);
            return resultInfo;
        }catch (Exception e){
            LOGGER.error("findGoodsList happen exception ",e);
            return ResultInfo.newExceptionResultInfo();
        }
    }
}
