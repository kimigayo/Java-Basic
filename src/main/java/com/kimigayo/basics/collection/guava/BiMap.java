package com.kimigayo.basics.collection.guava;

import com.google.common.collect.HashBiMap;

public class BiMap {
    public static void main(String[] args) {
        HashBiMap<Object, Object> biMap = HashBiMap.create();
        biMap.put("厦门 ","鼓浪屿");
//        biMap.put("厦门 ","会展中心");
        biMap.put("福州 ","福州大学");
        System.out.println(biMap.inverse().get("鼓浪屿"));
    }
}
