package com.example.mavenproject.common;

import cn.hutool.http.HttpUtil;

/**
 * @author :Aurora
 * @version:
 * @date : 2023/8/15 17:25
 * @desc:
 */
public class MainTest {

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            new Thread(() -> {
                HttpUtil.get("127.0.0.1:8080/nihk/getTest?num=" + finalI);
            }).start();
        }
        Thread.yield();
    }
}
