package com.kimigayo.basics.collection;

public class HashSetTest {
    public static void main(String[] args) {
        SelfHashSet set = new SelfHashSet();
        set.add("七里香");
        set.add("青花瓷");
        set.add(9527);
        set.add(9527);
        System.out.println(set.getSize());
    }
}
