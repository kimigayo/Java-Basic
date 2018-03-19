package com.kimigayo.nio.channel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class ChannelTransferTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile fileFrom = new RandomAccessFile("C:\\Users\\chenbinbin\\Desktop\\常用sql.txt","rw");
        RandomAccessFile fileTo = new RandomAccessFile("C:\\Users\\chenbinbin\\Desktop\\副本.txt","rw");
        FileChannel channelFrom = fileFrom.getChannel();
        FileChannel channelTo = fileTo.getChannel();
        long position = 0;
        long count =  channelFrom.size();
        channelFrom.transferTo(0,count,channelTo);
    }
}
