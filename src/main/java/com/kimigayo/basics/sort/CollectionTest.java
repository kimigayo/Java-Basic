package com.kimigayo.basics.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(5);
        list.add(2);
        list.add(4);
        list.add(3);
//        Collections.reverse(list);
//        Collections.swap(list,1,2);
//        Collections.shuffle(list);
        Collections.sort(list);
        System.out.println(list);
        int localtion = Collections.binarySearch(list,4);//容器必须为排序情况下使用
        System.out.println(localtion);

    }
}
