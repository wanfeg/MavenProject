package com.example.mavenproject.common.scheduleTask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.task.TaskSchedulerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.TimeUnit;

/**
 * @author :Aurora
 * @version:
 * @date : 2023/10/31 16:03
 * @desc:
 */
@Configuration
@Slf4j
public class ScheduleTask {

    @Bean
    public ThreadPoolTaskScheduler taskScheduler() {
        return new TaskSchedulerBuilder()
                // 线程名称前缀
                .threadNamePrefix("scheduling-")
                // 线程数
                .poolSize(1)
                .build();
    }

    @Bean
    public TaskSchedulerBuilder schedulerBuilder() {
        return new TaskSchedulerBuilder()
                // 线程名称前缀
                .threadNamePrefix("schedule-")
                // 线程数
                .poolSize(1);
    }





}
