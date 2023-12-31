package com.example.mavenproject.common.lock;

public class synchronizedTest implements Runnable {
    static synchronizedTest instance=new synchronizedTest();
    static int i=0;
    @Override
    public void run() {
        //省略其他耗时操作....
        //使用同步代码块对变量i进行同步操作,锁对象为instance
//        synchronized(instance){
//            for(int j=0;j<10000;j++){
//                i++;
//            }
//        }

        //this,当前实例对象锁
        synchronized(this){
            for(int j=0;j<1000000;j++){
                i++;
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(instance);
        Thread t2=new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
