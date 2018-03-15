package com.kimigayo.net.tcp.transfer;

import com.kimigayo.basics.io.FileUtil;

import java.io.*;
import java.net.Socket;

public class SocketSend implements Runnable{
    private DataOutputStream outputStream;
    private BufferedReader reader;
    private Socket socket;
    private boolean isRunning =true;
    private SocketSend() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }
    public SocketSend(Socket socket,String name) {
        this(socket);
        send(name);
    }

    public SocketSend(Socket socket) {
        this();
        this.socket = socket;
        try {
            outputStream = new DataOutputStream(this.socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            FileUtil.closeAll(outputStream,reader);
            isRunning =false;
        }
    }

    public String getInput(){
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public void run() {
        while (isRunning){
            send(getInput());
        }
    }

    public void send(String input){
        if(null!=input&&!"".equals(input.trim())){
            try {
                outputStream.writeUTF(input);
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
                isRunning =false;
            }
        }
    }
}
