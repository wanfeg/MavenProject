package com.example.mavenproject.utils;

/**
 * @author :Aurora
 * @version:
 * @date : 2023/8/4 17:00
 * @desc:
 */
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC2 {

    // 共享变量，表示当前应该打印哪个字母
    private static int state = 0;

    // 可重入锁
    private static final ReentrantLock lock = new ReentrantLock();

    // 三个条件对象，分别绑定A、B、C三个线程
    private static final Condition A = lock.newCondition();
    private static final Condition B = lock.newCondition();
    private static final Condition C = lock.newCondition();

    public static void main(String[] args) {
        // 创建三个线程
        Thread threaA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 循环100次
                    for (int i = 0; i < 100;) {
                        // 获取锁
                        lock.lock();
                        try {
                            // 判断是否轮到自己执行
                            while (state % 3 != 0) {
                                // 不是则等待
                                A.await();
                            }
                            // 打印字母
                            System.out.println("A线程第" + ++i +"次打印："+"A");
                            // 修改状态
                            state++;
                            // 唤醒下一个线程
                            B.signal();
                        } finally {
                            // 释放锁
                            lock.unlock();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threaB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100;) {
                        lock.lock();
                        try {
                            while (state % 3 != 1) {
                                B.await();
                            }
                            System.out.println("B线程第" + ++i +"次打印："+"B");
                            state++;
                            C.signal();
                        } finally {
                            lock.unlock();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threaC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100;) {
                        lock.lock();
                        try {
                            while (state % 3 != 2) {
                                C.await();
                            }
                            System.out.println("C");
                            state++;
                            A.signal();
                        } finally {
                            lock.unlock();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 启动三个线程
        threaA.start();
        threaB.start();
        threaC.start();
    }
}

