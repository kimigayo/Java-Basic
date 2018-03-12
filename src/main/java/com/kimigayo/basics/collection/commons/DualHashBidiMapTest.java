package com.kimigayo.basics.collection.commons;

import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class DualHashBidiMapTest {
    public static void main(String[] args) {
        //无序的双向map
        DualHashBidiMap<String,String> map = new DualHashBidiMap();

        map.put("厦门","思明区");
        map.put("福州","鼓楼区");
        System.out.println(map.inverseBidiMap().get("思明区"));
        MapIterator iterator = map.inverseBidiMap().mapIterator();
        while (iterator.hasNext()){
            iterator.next();
            System.out.println(iterator.getKey()+"\t\t"+iterator.getValue());
        }
    }
}
