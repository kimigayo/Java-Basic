package com.kimigayo.httpserver;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Response {
    private final static String CRLF = "\r\n";
    private final static String BLANK = " ";
    private String content;
    private BufferedWriter writer;

    public Response(OutputStream stream) {
        writer = new BufferedWriter(new OutputStreamWriter(stream));
    }

    public void push(int code){

    }
}
