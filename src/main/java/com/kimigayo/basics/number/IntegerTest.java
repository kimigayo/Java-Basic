package com.kimigayo.basics.number;

public class IntegerTest {
    public static void main(String[] args) {
        Integer integer = new Integer(1000);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.toHexString(integer));
        Integer i1 = 1234;
        Integer i2 = 1234;
        Integer i3 = 124;
        Integer i4 = 124;
        System.out.println(i1==i2);
        System.out.println(i3==i4);//[-128,127]之间的数，仍然当作基本类型处理
    }
}
