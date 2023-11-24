package com.example.mavenproject.common.socket;//客户端

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SocketClient {
  public static void main(String args[]) throws Exception {
    //与本地服务器端建立连接
    String host = "127.0.0.1"; 
    int port = 55533;
    Socket socket = new Socket(host, port);

    //控制台输入并向服务器端输出
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    //String str = bufferedReader.readLine();
    String str = "";
    while (str != "end") {
      str = bufferedReader.readLine();
      bufferedWriter.write(str + "\n");
      bufferedWriter.flush();
    }

    //关闭连接
    bufferedWriter.close();
    socket.close();
  }
}
