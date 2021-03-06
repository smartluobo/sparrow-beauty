package com.chaomeis.sparrowbeauty.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@ServletComponentScan
@WebFilter(filterName = "test", urlPatterns = {"/cms/**"})
public class ZCrossFilter implements Filter{
    private static final Logger LOGGER = LoggerFactory.getLogger(ZCrossFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        String origin = req.getHeader("Origin");
        if (origin == null ){
            resp.setHeader("Access-Control-Allow-Origin", "http://47.106.172.126:8668");
        }

        resp.setHeader("Access-Control-Allow-Origin", origin);            // 允许指定域访问跨域资源
        resp.setHeader("Access-Control-Allow-Credentials", "true");       // 允许客户端携带跨域cookie，此时origin值不能为“*”，只能为指定单一域名

        if(RequestMethod.OPTIONS.toString().equals(req.getMethod())) {
            String allowMethod = req.getHeader("Access-Control-Request-Method");
            String allowHeaders = req.getHeader("Access-Control-Request-Headers");
            resp.setHeader("Access-Control-Max-Age", "86400");            // 浏览器缓存预检请求结果时间,单位:秒
            resp.setHeader("Access-Control-Allow-Methods", allowMethod);  // 允许浏览器在预检请求成功之后发送的实际请求方法名
            resp.setHeader("Access-Control-Allow-Headers", allowHeaders); // 允许浏览器发送的请求消息头
            String header = resp.getHeader("Access-Control-Allow-Origin");
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    private void setHeaders( HttpServletResponse response){
        LOGGER.error("CrossFilter setHeaders is called..............");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACES");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
    }

}
