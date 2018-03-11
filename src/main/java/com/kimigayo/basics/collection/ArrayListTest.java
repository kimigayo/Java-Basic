package com.kimigayo.basics.collection;

import java.util.Arrays;

public class ArrayListTest {
    public static void main(String[] args) throws Exception {
        SelfArrayList list = new SelfArrayList(1);
        list.add("软件园");
        list.add("厦门大学");
        list.add("观音山");
        list.remove(1);
        System.out.println(list.getSize());
        for (int i =0;i<list.getSize();i++){
            System.out.println(list.get(i));
        }
    }
}
