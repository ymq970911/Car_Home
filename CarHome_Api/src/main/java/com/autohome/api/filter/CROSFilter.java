package com.autohome.api.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: voter
 * @description: 实现服务端跨域处理：允许参数、请求消息头跨域
 * @author: Feri(邢朋辉)
 * @create: 2020-07-15 17:12
 */
@Component
@WebFilter("/*")
public class CROSFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*"); //允许跨域
        response.setHeader("Access-Control-Allow-Credentials", "true"); //允许跨域
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");//支持跨域的请求方式
        response.setHeader("Access-Control-Allow-Headers", "content-type,votertoken");// 允许跨域的请求消息头
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("content-type", "application/json;charset=UTF-8");
        filterChain.doFilter(servletRequest, response);
    }
}
