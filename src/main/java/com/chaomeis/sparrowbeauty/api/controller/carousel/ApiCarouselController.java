package com.chaomeis.sparrowbeauty.api.controller.carousel;

import com.chaomeis.sparrowbeauty.api.service.carousel.ApiCarouselService;
import com.chaomeis.sparrowbeauty.response.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/api/carousel")
public class ApiCarouselController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiCarouselController.class);

    @Resource
    private ApiCarouselService apiCarouselService;

    @RequestMapping("/findCarouselList")
    public ResultInfo findCarouselList(@RequestBody Map<String,String> params){
        try {
            ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
            resultInfo.setData(apiCarouselService.findAll());
            return resultInfo;
        }catch (Exception e){
            LOGGER.error("findCarouselList happen exception",e);
            return ResultInfo.newExceptionResultInfo();
        }
    }
}
