package com.example.mavenproject.common.scheduleTask;
  
import lombok.extern.slf4j.Slf4j;  
import org.springframework.scheduling.annotation.EnableScheduling;  
import org.springframework.scheduling.annotation.Scheduled;  
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**  
* 定时同步  
*  
* @author Bruse  
*/  
@Slf4j  
@EnableScheduling // 开启定时任务  
@Component  
public class SyncTask {  
  
    // 在要执行的方法上加上@Scheduled注解，这里表示每5秒执行一次sync()  
    @Scheduled(cron = "0/5 * * * * ?")  
    public void sync() {  
        log.info("do sync task ...");  
    }


    @Scheduled(cron = "0/5 * * * * ?")
    public void sync2() {
        // 模拟耗时操作
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("do sync task ...");
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void doSomeThing() {
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("do some thing ...");
    }


}
