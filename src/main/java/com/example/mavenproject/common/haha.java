package com.example.mavenproject.common;

/**
 * @author :Aurora
 * @version:
 * @date : 2023/8/14 11:05
 * @desc:
 */
public class haha {
    public static void main(String[] args) {
        System.out.println("haha");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread = Thread.currentThread();
        System.out.println("thread = " + thread);
        System.out.println("推送到主分支");

    }

}
