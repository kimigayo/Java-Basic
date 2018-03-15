package com.kimigayo.net.udp;

import java.io.IOException;
import java.net.*;

/**
 * 无连接不可靠
 */
public class InetSocketAddressClientTest {
    public static void main(String[] args) throws IOException {
        InetSocketAddress  socketAddress = new InetSocketAddress(InetAddress.getLocalHost(),8888);
        DatagramSocket socket = new DatagramSocket(socketAddress);
        String msg = "udp编程";
        byte[] bytes = msg.getBytes();
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length,InetAddress.getLocalHost(),9999);
        socket.send(packet);
        socket.close();
    }
}
