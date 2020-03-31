package com.chaomeis.sparrowbeauty.cms.controller.login;

import com.chaomeis.sparrowbeauty.cms.service.login.CmsLoginService;
import com.chaomeis.sparrowbeauty.entity.TbCmsUser;
import com.chaomeis.sparrowbeauty.response.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("cms/login")
public class CmsLoginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CmsLoginController.class);

    @Resource
    private CmsLoginService cmsLoginService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public ResultInfo login(HttpServletRequest request, HttpServletResponse response, @RequestBody TbCmsUser tbCmsUser){
        response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
        if (tbCmsUser == null){
            LOGGER.error("login user info is null");
            return ResultInfo.newEmptyParamsResultInfo();
        }
        try {
            LOGGER.error("login user info :{}",tbCmsUser);
            TbCmsUser dbUser = cmsLoginService.login(tbCmsUser);
            if (dbUser == null){
                return ResultInfo.newFailResultInfo("登录名或密码不正确");
            }
            //处理session
            request.getSession().setAttribute("user",dbUser);
            ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
            dbUser.setPassword("********");
            resultInfo.setData(dbUser);
            LOGGER.info("login success ....");
            return resultInfo;
        }catch (Exception e){
            LOGGER.error("cms user login happen Exception",e);
            return ResultInfo.newExceptionResultInfo();
        }
    }

    @RequestMapping(value = "/loginOut")
    @ResponseBody
    public ResultInfo login(HttpServletRequest request,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
        try {
            ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
            request.getSession().removeAttribute("user");
            LOGGER.info("login success ....");
            return resultInfo;
        }catch (Exception e){
            LOGGER.error("cms user login out happen Exception",e);
            return ResultInfo.newExceptionResultInfo();
        }
    }

    @PostMapping(value = "/isLogin")
    @ResponseBody
    public ResultInfo isLogin(HttpServletRequest request,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
        try {
            Cookie[] cookies = request.getCookies();
            if (cookies != null){
                for (Cookie cookie : cookies) {
                    LOGGER.info("cookie : {}",cookie);
                }
            }

            ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
            Object user = request.getSession().getAttribute("user");
            if (user == null){
                return ResultInfo.newNoLoginResultInfo();
            }else {
                resultInfo.setData(user);
                LOGGER.info("request ready login...");
                return resultInfo;
            }
        }catch (Exception e){
            LOGGER.error("cms user login out happen Exception",e);
            return ResultInfo.newExceptionResultInfo();
        }
    }
}
