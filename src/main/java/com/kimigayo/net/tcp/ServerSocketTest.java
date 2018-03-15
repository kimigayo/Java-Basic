package com.kimigayo.net.tcp;

import com.kimigayo.basics.io.FileUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerSocketTest {
    private List<SocketChannel> channels = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        new ServerSocketTest().socketServer();
    }

    public void socketServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true) {
            final Socket socket = serverSocket.accept();
            new Thread(new SocketChannel(socket)).start();
        }
    }

    private class SocketChannel implements Runnable {
        private String name;
        private DataInputStream inputStream = null;
        private DataOutputStream outputStream = null;

        public SocketChannel(Socket socket) {
            try {
                inputStream = new DataInputStream(socket.getInputStream());
                outputStream = new DataOutputStream(socket.getOutputStream());
                System.out.println("接收到请求:" + socket.getRemoteSocketAddress());
                this.name = receive();
                sendToAll("欢迎：" + name);
                channels.add(this);
            } catch (IOException e) {
                e.printStackTrace();
                channels.remove(this);
            }
        }

        @Override
        public void run() {
            send(receive());
        }

        public String receive() {
            try {
                return inputStream.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }

        public void sendToAll(String msg) {
            for (SocketChannel channel : channels) {
                channel.doSend(msg);
            }
        }

        public void send(String msg) {
            for (SocketChannel channel : channels) {
                if (msg.startsWith("@") && msg.indexOf(":") > -1) {
                    String name = msg.substring(1, msg.indexOf(":"));
                    if (channel.name.equals(name)) {
                        channel.doSend(this.name+"："+msg.substring(msg.indexOf(":")+1));
                    }
                } else {
                    channel.doSend(this.name+"："+msg);
                }
            }
        }

        public void doSend(String s) {
            try {
                outputStream.writeUTF(s);
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
