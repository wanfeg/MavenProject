package com.example.mavenproject.common;

import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.http.HttpUtil;
import com.example.mavenproject.service.impl.HelloImpl;

/**
 * @author :Aurora
 * @version:
 * @date : 2023/8/15 17:25
 * @desc:
 */
public class MainTest {

    public static void main(String[] args) {
        /*for (int i = 0; i < 1000; i++) {
            int finalI = i;
            new Thread(() -> {
                HttpUtil.get("127.0.0.1:8080/nihk/getTest?num=" + finalI);
            }).start();
        }
        Thread.yield();*/
        String s1 = "10101,10401";
        String s2 = "10101,";
        System.out.println("s1.contains(s2) = " + s1.contains(s2));

    }

}
