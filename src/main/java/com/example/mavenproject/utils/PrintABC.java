package com.example.mavenproject.utils;

public class PrintABC {

    // 共享变量，表示当前应该打印哪个字母
    private static int state = 0;
    static int cnt = 1;
    // 共享对象，作为锁和通信的媒介
    private static final Object lock = new Object();

    public static void main(String[] args) {
        // 创建三个线程
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 循环100次
                    for (int i = 0; i < 100; i++) {
                        // 获取锁
                        synchronized (lock) {
                            // 判断是否轮到自己执行
                            while (state % 3 != 0) {
                                // 不是则等待
                                lock.wait();
                            }

                            // 打印字母
                            System.out.println("A线程第" + cnt++ +"次打印："+"A");
                            // 修改状态
                            state++;
                            // 唤醒下一个线程
                            lock.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        synchronized (lock) {
                            while (state % 3 != 1) {
                                lock.wait();
                            }
                            System.out.println("B线程第"  +"次打印："+"B");
                            state++;
                            lock.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        synchronized (lock) {
                            while (state % 3 != 2) {
                                lock.wait();
                            }
                            System.out.println("C线程第"  +"次打印："+"C");
                            state++;
                            lock.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 启动三个线程
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
