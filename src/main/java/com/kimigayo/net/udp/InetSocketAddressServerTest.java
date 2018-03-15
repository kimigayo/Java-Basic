package com.kimigayo.net.udp;

import java.io.IOException;
import java.net.*;

public class InetSocketAddressServerTest {
    public static void main(String[] args) throws IOException {
        InetSocketAddress address = new InetSocketAddress(InetAddress.getLocalHost(),9999);
        DatagramSocket socket = new DatagramSocket(address);
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length);
        socket.receive(packet);
        socket.close();
        System.out.println(new String(bytes));
    }
}
