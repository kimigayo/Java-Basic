package com.kimigayo.nio.channel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {
    public static void main(String[] args) throws IOException {
        write();
    }

    public static void write() throws IOException {
        RandomAccessFile file = new RandomAccessFile("C:\\Users\\chenbinbin\\Desktop\\副本.txt", "rw");
        FileChannel channel = file.getChannel();
        String s = "大河之水天上来";
        ByteBuffer buffer = ByteBuffer.allocate(100);
//        buffer.clear();
        buffer.put(s.getBytes());
        buffer.flip();
        while (buffer.hasRemaining())
            channel.write(buffer);
        channel.close();
    }

    public static void read() throws IOException {
        RandomAccessFile file = new RandomAccessFile("C:\\Users\\chenbinbin\\Desktop\\常用sql.txt", "rw");
        FileChannel channel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(104);
        int byteread = channel.read(buffer);
        while (byteread != -1) {
//            System.out.println(byteread);
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.println((char) buffer.get());
            }
            buffer.compact();
            byteread = channel.read(buffer);
        }
        buffer.rewind();
        System.out.println((char) buffer.get());
        file.close();
    }
}
