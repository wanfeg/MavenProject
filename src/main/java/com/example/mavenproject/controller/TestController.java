package com.example.mavenproject.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author :Aurora
 * @version:
 * @date : 2023/8/15 17:20
 * @desc:
 */
@Slf4j
@RestController
public class TestController {

    @Async
    @GetMapping("/getTest")
    public void getTest(int num) throws Exception{
        log.info("{} 接收到请求：num={}",Thread.currentThread().getName(),num);
        TimeUnit.HOURS.sleep(1);
    }
}
