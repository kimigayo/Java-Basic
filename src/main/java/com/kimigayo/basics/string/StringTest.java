package com.kimigayo.basics.string;

public class StringTest {
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer();//线程不安全，效率高
        System.out.println(buffer.append("abcdefjhijk"));
        System.out.println(buffer.delete(1,2));
        System.out.println(buffer.reverse());
        System.out.println(buffer.length());
        StringBuilder builder = new StringBuilder();//线程安全，效率不高
    }
}
