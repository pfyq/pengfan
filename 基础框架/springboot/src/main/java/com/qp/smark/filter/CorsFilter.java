//package com.qp.smark.filter;
//
//
//import com.qp.smark.controller.later.JoinObjController;
//import org.apache.log4j.Logger;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class CorsFilter implements Filter{
//    private static final Logger log = Logger.getLogger(CorsFilter.class);
//
//    @Override
//    public void destroy() {
//    }
//
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
//            throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) res;
//
//        response.setContentType("application/json;charset=utf-8");
//        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//request.getHeader("Origin")
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//        response.setHeader("Access-Control-Max-Age", "0");
//        response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires,content-type,Content-Type, X-E4M-With,userId,token");
//        response.setHeader("Access-Control-Allow-Credentials", "true");//允许带cookie
//        response.setHeader("XDomainRequestAllowed","1");
//
//        chain.doFilter(req, res);
//        log.error("来过此方法 CorsFilter");
////        HttpServletResponse response = (HttpServletResponse) res;
////        response.setHeader("Access-Control-Allow-Origin", "*");
////        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE,PUT");
////        response.setHeader("Access-Control-Max-Age", "3600");
////        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
////        chain.doFilter(req, res);
//
//
//    }
//
//    @Override
//    public void init(FilterConfig arg0) throws ServletException {
//
//    }
//}
