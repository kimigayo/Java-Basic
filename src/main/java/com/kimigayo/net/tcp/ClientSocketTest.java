package com.kimigayo.net.tcp;

import com.kimigayo.net.tcp.transfer.ScoketReceive;
import com.kimigayo.net.tcp.transfer.SocketSend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class ClientSocketTest {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入使用的ID：");
        String s = reader.readLine();
        Socket socket = new Socket(InetAddress.getLocalHost(),8888);
        new Thread(new SocketSend(socket,s)).start();
        new Thread(new ScoketReceive(socket)).start();
    }
}
