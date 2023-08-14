package com.example.mavenproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author :Aurora
 * @version:
 * @date : 2023/8/11 14:16
 * @desc:
 */
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private RepeatRequtstHandler requtstHandler;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requtstHandler);
    }


}
