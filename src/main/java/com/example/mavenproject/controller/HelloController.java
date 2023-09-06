package com.example.mavenproject.controller;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author :Aurora
 * @version:
 * @date : 2023/7/28 16:58
 * @desc:
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/test")
    public String test1(@RequestHeader(value = "host") String host ,
                        @RequestHeader(value = "User-agent") String agent,
                                HttpServletRequest request){
        System.out.println("host = " + host);
        System.out.println("agent = " + agent);
        System.out.println("request.getHeader(\"Host\") = " + request.getHeader("host"));
        System.out.println("request.getHeader(\"User-agent\") = " + request.getHeader("User-agent"));
        return "hello web i see you";
    }


}
