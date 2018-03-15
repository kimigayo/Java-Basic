package com.kimigayo.net.tcp.transfer;

import com.kimigayo.basics.io.FileUtil;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ScoketReceive implements Runnable{
    private DataInputStream inputStream;
    private Socket socket;
    private boolean isRunning =true;

    public ScoketReceive(Socket socket) {
        this.socket = socket;
        try {
            inputStream = new DataInputStream(this.socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            FileUtil.closeAll(inputStream);
            isRunning=false;
        }
    }

    public String getInput(){
        try {
            return inputStream.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public void run() {
        while (isRunning){
            reveive();
        }
    }

    public void reveive(){
        System.out.println(getInput());
    }
}
