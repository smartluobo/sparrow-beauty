package com.chaomeis.sparrowbeauty.cms.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.chaomeis.sparrowbeauty.response.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object user = request.getSession().getAttribute("user");
        LOGGER.info(" session interceptor preHandle...");
        if (user == null){
            LOGGER.info("no login be interceptor");
            response.getWriter().print(JSONObject.toJSONString(ResultInfo.newNoLoginResultInfo()));
            return false;
        }else {
            return super.preHandle(request, response, handler);
        }
    }
}
