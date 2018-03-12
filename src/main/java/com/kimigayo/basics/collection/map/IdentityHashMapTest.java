package com.kimigayo.basics.collection.map;

import java.util.IdentityHashMap;

/**
 * IdentityHashMap,比较key重复根据引用地址
 */
public class IdentityHashMapTest {
    public static void main(String[] args) {
        IdentityHashMap map = new IdentityHashMap();
        map.put("a","bbb");
        map.put(new String("a"),"bbb");
        map.put(new String("a"),"bbb");
        System.out.println(map.size());
    }
}
