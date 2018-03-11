package com.kimigayo.basics.collection;

import java.util.HashMap;
import java.util.Map;

public class SelfHashSet<T> {
    private int size;
    private final static Object OBJECT = new Object();
    private Map map;

    public SelfHashSet() {
        map = new HashMap();
    }

    public void add(T t) {
        map.put(t,OBJECT);
    }

    public int getSize() {
        return map.size();
    }

}
