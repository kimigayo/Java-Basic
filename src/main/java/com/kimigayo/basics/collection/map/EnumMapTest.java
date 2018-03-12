package com.kimigayo.basics.collection.map;

import java.util.EnumMap;

/**
 * key必须为枚举类型
 */
public class EnumMapTest {
    public static void main(String[] args) {
        EnumMap map = new EnumMap(Computer.class);
        map.put(Computer.DESKTOP,"台式机");
        map.put(Computer.PC,"笔记本");
        System.out.println(map.size());
    }

    private enum Computer{
        DESKTOP,PC
    }
}
