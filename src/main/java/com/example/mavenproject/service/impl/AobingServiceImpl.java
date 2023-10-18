package com.example.mavenproject.service.impl;

import com.example.mavenproject.service.AobingService;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service(value = "aobingService")
public class AobingServiceImpl implements AobingService {

    public String hello(String name) {
        return "U man Hello，I am " + name;
    }

}  