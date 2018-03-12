package com.kimigayo.basics.collection.commons;

import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.map.HashedMap;

public class IterableMapTest {
    public static void main(String[] args) {
        IterableMap<String,String> map = new HashedMap<>();
        map.put("a","马云");
        map.put("b","马化腾");
        map.put("c","李彦宏");
        MapIterator<String,String>  iterator = map.mapIterator();
        while (iterator.hasNext()){
            iterator.next();
            System.out.println(iterator.getKey()+"\t\t"+iterator.getValue());
        }
    }
}
