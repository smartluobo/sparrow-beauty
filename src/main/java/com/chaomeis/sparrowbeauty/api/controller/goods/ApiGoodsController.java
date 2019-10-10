package com.chaomeis.sparrowbeauty.api.controller.goods;

import com.chaomeis.sparrowbeauty.api.service.goods.ApiGoodsService;
import com.chaomeis.sparrowbeauty.entity.TbGoods;
import com.chaomeis.sparrowbeauty.entity.TbSuit;
import com.chaomeis.sparrowbeauty.response.ResultInfo;
import org.apache.commons.lang3.StringUtils;
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
@RequestMapping("/api/goods")
public class ApiGoodsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiGoodsController.class);

    @Resource
    private ApiGoodsService apiGoodsService;

    @RequestMapping("/findGoodsList")
    public ResultInfo findGoodsList(){
        try {
            ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
            List<TbGoods> goodsList = apiGoodsService.findGoodsList();
            resultInfo.setData(goodsList);
            return resultInfo;
        }catch (Exception e){
            LOGGER.error("findGoodsList happen exception ",e);
            return ResultInfo.newExceptionResultInfo();
        }
    }

    @RequestMapping("/findSuitList")
    public ResultInfo findSuitList(){
       try {
           ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
           List<TbSuit> suitList = apiGoodsService.findSuitList();
           resultInfo.setData(suitList);
           return resultInfo;
       }catch (Exception e){
           LOGGER.error("findSuitList happen exception",e);
           return ResultInfo.newExceptionResultInfo();
       }
    }

    @RequestMapping("/findGoodsDetailById")
    public ResultInfo findGoodsDetailById(@RequestBody Map<String,String> params){
        try {
            if (CollectionUtils.isEmpty(params) || StringUtils.isEmpty(params.get("goodsId"))){
                return ResultInfo.newEmptyParamsResultInfo();
            }
            ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
            TbGoods goodsInfo = apiGoodsService.findGoodsDetailById(Integer.valueOf(params.get("goodsId")));
            resultInfo.setData(goodsInfo);
            return resultInfo;
        }catch (Exception e){
            LOGGER.error("findGoodsList happen exception ",e);
            return ResultInfo.newExceptionResultInfo();
        }
    }

    @RequestMapping("/findSuitDetailById")
    public ResultInfo findSuitDetailById(@RequestBody Map<String,String> params){
        try {
            if (CollectionUtils.isEmpty(params) || StringUtils.isEmpty(params.get("suitId"))){
                return ResultInfo.newEmptyParamsResultInfo();
            }
            ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
            TbSuit suitInfo = apiGoodsService.findSuitDetailById(Integer.valueOf(params.get("suitId")));
            resultInfo.setData(suitInfo);
            return resultInfo;
        }catch (Exception e){
            LOGGER.error("findSuitList happen exception",e);
            return ResultInfo.newExceptionResultInfo();
        }
    }
}
