package com.chaomeis.sparrowbeauty.cms.controller.apiUser;

import com.chaomeis.sparrowbeauty.cms.service.apiUser.CmsApiUserService;
import com.chaomeis.sparrowbeauty.common.PageReqVO;
import com.chaomeis.sparrowbeauty.common.PageRespDto;
import com.chaomeis.sparrowbeauty.entity.TbCmsApiUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("cms/apiUser")
@Slf4j
public class CmsApiUserController {

    @Resource
    private CmsApiUserService cmsApiUserService;


    @RequestMapping(value = "/findPage")
    public PageRespDto<TbCmsApiUser> findCouponsPageList (HttpServletRequest request, HttpServletResponse response, @RequestBody PageReqVO<TbCmsApiUser> page) {
        response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
        return cmsApiUserService.findCouponsPageList(page);
    }
}
