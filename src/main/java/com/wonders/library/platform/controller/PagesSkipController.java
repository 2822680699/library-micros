package com.wonders.library.platform.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Slf4j
public class PagesSkipController {
    @RequestMapping(value = "/index")
    public String index(HttpServletResponse response, HttpServletRequest request){
        log.info("111"+request.getParameter("token"));
        response.setHeader("token",request.getParameter("token"));
        log.info("==================开始跳转首页===============");
        return "index";
    }

    @RequestMapping(value = "/books")
    public String book(HttpServletResponse response, HttpServletRequest request){
        log.info("111"+request.getParameter("token"));
        response.setHeader("token",request.getParameter("token"));
        log.info("==================开始跳转书籍===============");
        return "books";
    }

    @RequestMapping(value = "/update")
    public String update(HttpServletResponse response, HttpServletRequest request){
        log.info("111"+request.getParameter("token"));
        response.setHeader("token",request.getParameter("token"));
        log.info("==================开始跳转书籍更新===============");
        return "update";
    }

    @RequestMapping(value = "/create")
    public String create(HttpServletResponse response, HttpServletRequest request){
        log.info("111"+request.getParameter("token"));
        response.setHeader("token",request.getParameter("token"));
        log.info("==================开始跳转新增===============");
        return "create";
    }


    @RequestMapping(value = "/login")
    public String login(){
        log.info("==================开始跳转登录页面===============");
        return "login";
    }
}
