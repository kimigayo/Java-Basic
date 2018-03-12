package com.kimigayo.basics.collection.guava;



import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public class ImmutableListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList(1);
        list.add("软件园");
        list.add("厦门大学");
        list.add("观音山");
        List<String> list1 = ImmutableList.copyOf(list);
//        list1.add("白鹭洲");
        for(String s:list1){
            System.out.println(s);
        }
    }
}
