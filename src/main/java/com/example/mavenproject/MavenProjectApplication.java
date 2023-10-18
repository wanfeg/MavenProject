package com.example.mavenproject;

import cn.hutool.http.HttpUtil;
import com.example.mavenproject.service.AobingService;
import com.example.mavenproject.service.IHello;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableAsync
@SpringBootApplication
@MapperScan("com.example.mavenproject.mapper")
@EnableScheduling
public class MavenProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MavenProjectApplication.class, args);

    }

    //
    @Bean
    CommandLineRunner test2(IHello hello, AobingService aobingService) {
        return args -> {
            hello.sayHello();
            System.out.println(aobingService.hello("张子凡"));
            String data = HttpUtil.get("https://yapi.pro/mock/43658/emp/list");
            HttpUtil.post("https://yapi.pro/mock/43658/emp/list", "{\"name\":\"张三\",\"age\":18}");
            System.out.println(data.substring(data.indexOf("["), data.lastIndexOf("]") + 1));
        };
    }


}
