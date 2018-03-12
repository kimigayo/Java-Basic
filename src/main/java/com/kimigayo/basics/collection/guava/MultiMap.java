package com.kimigayo.basics.collection.guava;

import com.google.common.collect.HashMultimap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MultiMap {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("思明区","厦门");
        map.put("湖里区","厦门");
        map.put("集美区","厦门");
        map.put("鼓楼区","福州");
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        HashMultimap<String, String> map1 = HashMultimap.create();
        for (Map.Entry<String,String> entry:entrySet)
            map1.put(entry.getValue(),entry.getKey ());
        Set<String>  set = map1.keySet();
        for (String s:set){
            Set<String> set1 = map1.get(s);
            System.out.println(s+"==>"+set1);
        }
    }
}
