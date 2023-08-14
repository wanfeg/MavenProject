package com.example.mavenproject.controller;

import jdk.internal.util.xml.impl.Input;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.Servlet;
import java.io.FileInputStream;
import java.io.InputStream;

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
    public String test1(){
        return "hello web i see you";
    }


}
