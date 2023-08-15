package com.example.mavenproject.common;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;

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
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("你好Runnable");
            }
        });
        thread1.start();
    }

}
