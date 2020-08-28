package com.wonders.library.platform.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Slf4j
public class PagesSkipController {
    @RequestMapping(value = "/index")
    public String registerAgreement(HttpServletResponse response, HttpServletRequest request){
        log.info("111"+request.getParameter("token"));
        response.setHeader("token",request.getParameter("token"));
        log.info("==================开始跳转首页===============");
        return "index";
    }

    @RequestMapping(value = "/login")
    public String Logout(){
        log.info("==================开始跳转登录页面===============");
        return "login";
    }
}
