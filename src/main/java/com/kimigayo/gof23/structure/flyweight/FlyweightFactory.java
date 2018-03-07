package com.kimigayo.gof23.structure.flyweight;

import java.util.concurrent.ConcurrentHashMap;

public class FlyweightFactory {
    private static ConcurrentHashMap<String,Flyweight> map = new ConcurrentHashMap<>();

    public static Flyweight getFlyweight(String name){
        if (map.get(name)==null)
            synchronized (map){
                if (map.get(name)==null){
                    Flyweight flyweight = new ConcreteFlyweight(name);
                    map.put(name,flyweight);
                    return flyweight;
                }
            }
            return map.get(name);
    }

    public static long getSize(){
        return map.size();
    }
}
