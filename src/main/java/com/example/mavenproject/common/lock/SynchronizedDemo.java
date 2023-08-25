package com.example.mavenproject.common.lock;


import java.util.concurrent.locks.Lock;

public class SynchronizedDemo implements Runnable {
    static final SynchronizedDemo sync = new SynchronizedDemo();
    static Object object = new Object();
    private static int count = 0;

    static{
        System.out.println("sync = " + sync);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
            System.out.println("synchronizedDemo = " + synchronizedDemo);
            Thread thread = new Thread(synchronizedDemo);
            thread.start();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("result: " + count);

    }

    @Override
    public void run() {
        System.out.println("this:" + this);
        synchronized (object){
            for (int i = 0; i < 10000; i++)
                count++;
        }
    }

}
