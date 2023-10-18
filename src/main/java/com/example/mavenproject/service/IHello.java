package com.example.mavenproject.service;


public interface IHello {

    void sayHello();

    void sayByeBye(String name);

    default void set(){
        System.out.println("hello");
    }

    static void get(){
        System.out.println("你好");
    }

}