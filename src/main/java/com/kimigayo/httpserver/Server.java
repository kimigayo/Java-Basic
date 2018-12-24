package com.kimigayo.httpserver;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
    private final static String CRLF = "\r\n";
    private final static String BLANK = " ";


    public static void main(String[] args) throws IOException {
        new Server().receive();
    }

    public void receive() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        byte[] bytes = new byte[1024000];
        int len = socket.getInputStream().read(bytes);
        System.out.println(new java.lang.String(bytes, 0, len));
        StringBuffer buffer = new StringBuffer();
        buffer.append("<html>" +
                "<head><title>HTTP响应</title></head>" +
                "<body>Hello HTTP!</body>" +
                "</html>");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("HTTP/1.1").append(BLANK).append("200").append(BLANK).append("OK").append(CRLF);
        stringBuffer.append("Server kimigayo/0.0.0.1").append(CRLF);
        stringBuffer.append("DATE:").append(new Date()).append(CRLF);
        stringBuffer.append("Content-Type: text/html;charset=UTF-8").append(CRLF);
        stringBuffer.append("Content-Length: ").append(buffer.toString().getBytes().length).append(CRLF);
        stringBuffer.append(CRLF);
        stringBuffer.append(buffer);


        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write(stringBuffer.toString());
        writer.flush();
        writer.close();
    }
}
