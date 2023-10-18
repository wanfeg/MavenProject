package com.example.mavenproject.service.impl;

import com.example.mavenproject.service.IHello;
import org.springframework.stereotype.Service;

@Service(value = "hello")
public class HelloImpl implements IHello {

    @Override
    public void sayHello() {
        System.out.println("Hello world!");
    }

    public final void sayByeBye(String name){
        System.out.println("ByeBye~~ " + name + "***");
    }

}

