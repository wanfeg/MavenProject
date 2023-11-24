package com.example.mavenproject.controller;

import cn.hutool.extra.spring.SpringUtil;
import com.example.mavenproject.service.impl.HelloImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :Aurora
 * @version:
 * @date : 2023/9/15 15:01
 * @desc:
 */
@RequestMapping("nihao")
@RestController
public class Controller {

    @RequestMapping("/welcom")
    public String nihao(){
        HelloImpl bean = SpringUtil.getBean("hello");
        bean.sayByeBye("xiao wang");
        System.out.println("bean = " + bean);
        return "nihao";
    }

}
