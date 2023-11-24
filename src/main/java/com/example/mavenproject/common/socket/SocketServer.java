package com.example.mavenproject.common.socket;//服务器端

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
  public static void main(String[] args) throws Exception {
    // 监听指定的端口
    int port = 55533;
    ServerSocket server = new ServerSocket(port);

    //循环等待请求
    while(true){
      //建立连接
      Socket socket = server.accept();
      //从socket中获取输入流并读取
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
      String str;
      while ((str = bufferedReader.readLine()) != null) {
        System.out.println("get message from client:" + str);
      }
      //关闭连接
      bufferedReader.close();
      socket.close();
    }
  }
}
