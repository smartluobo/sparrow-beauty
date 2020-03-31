package com.chaomeis.sparrowbeauty.cms.controller.carousel;

import com.chaomeis.sparrowbeauty.cms.service.carousel.CmsCarouselService;
import com.chaomeis.sparrowbeauty.common.PageReqVO;
import com.chaomeis.sparrowbeauty.common.PageRespDto;
import com.chaomeis.sparrowbeauty.entity.TbCarousel;
import com.chaomeis.sparrowbeauty.entity.TbGoods;
import com.chaomeis.sparrowbeauty.response.ResultInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@RestController
@RequestMapping("cms/carousel")
@Slf4j
public class CmsCarouselController {
    @Resource
    private CmsCarouselService cmsCarouselService;

    @RequestMapping(value = "/findPage")
    public PageRespDto<TbCarousel> findCarouselPageList (HttpServletRequest request, HttpServletResponse response, @RequestBody PageReqVO<TbCarousel> page) {
        response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
        return cmsCarouselService.findCarouselPageList(page);
    }

    @RequestMapping(value = "/create")
    public ResultInfo createCarousel (HttpServletRequest request, HttpServletResponse response, @RequestBody TbCarousel carousel) {
        try {
            response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
            if(StringUtils.isBlank(carousel.getImageUrl())) {
                return ResultInfo.newRepeatResultInfo("轮播图不能为空");
            }
            cmsCarouselService.createCarousel(carousel);
            return ResultInfo.newSuccessResultInfo();
        }catch (Exception e){
            log.info("createCarousel happen exception",e);
            return ResultInfo.newExceptionResultInfo();
        }

    }

    @RequestMapping(value = "/update")
    public ResultInfo updateCarousel (HttpServletRequest request, HttpServletResponse response,@RequestBody TbCarousel carousel) {
        try {
            response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
            if(carousel.getId() == 0) {
                return ResultInfo.newRepeatResultInfo("轮播Id不能为空");
            }
            carousel.setUpdateTime(new Date());
            cmsCarouselService.updateGoods(carousel);
            return ResultInfo.newSuccessResultInfo();
        }catch (Exception e){
            log.error("updateCarousel happen exception ",e);
            return ResultInfo.newExceptionResultInfo();
        }

    }

    @RequestMapping(value = "/findInfo")
    public ResultInfo findCarouselById (HttpServletRequest request, HttpServletResponse response,int id) {
        try {
            response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
            if(id == 0) {
                return ResultInfo.newRepeatResultInfo("轮播Id不能为空");
            }
            TbCarousel carousel = cmsCarouselService.findCarouselById(id);
            ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
            resultInfo.setData(carousel);
            return resultInfo;
        }catch (Exception e){
            log.error("findCarouselById happen exception",e);
            return ResultInfo.newExceptionResultInfo();
        }

    }

    @RequestMapping(value = "/delete")
    public ResultInfo deleteCarousel (HttpServletRequest request, HttpServletResponse response,Integer id) {
        try {
            response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
            if(id == 0) {
                return ResultInfo.newRepeatResultInfo("商品Id不能为空");
            }

            cmsCarouselService.deleteCarousel(id);
            return ResultInfo.newSuccessResultInfo();
        }catch (Exception e){
            log.error("deleteCarousel happen exception",e);
            return ResultInfo.newExceptionResultInfo();
        }

    }


}
