package com.example.mavenproject.common.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author :Aurora
 * @version:
 * @date : 2023/11/3 10:39
 * @desc:
 */
//服务器端（线程池管理）

public class ThreadPoolSocketServer {
    public static void main(String[] args) throws IOException {
        // 监听指定的端口
        int port = 55533;
        ServerSocket server = new ServerSocket(port);
        //创建一个线程池
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        //循环等待请求
        while (true) {
            //建立连接
            Socket socket = server.accept();
            //分配线程
            Runnable runnable = () -> {
                BufferedReader bufferedReader = null;
                //从socket中获取输入流并读取
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                    String str;
                    while ((str = bufferedReader.readLine()) != null) {
                        System.out.println("get message from client:" + str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            };
            executorService.submit(runnable);
        }
    }
}

