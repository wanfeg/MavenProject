package com.example.mavenproject.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

//定时任务
//@Service
public class TaskService {


    @Scheduled(cron = "0/2 * * * * ?")
    public void job(){
        System.out.println("定时任务开始执行-->"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

}