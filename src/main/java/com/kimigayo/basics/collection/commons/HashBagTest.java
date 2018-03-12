package com.kimigayo.basics.collection.commons;

import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bag.TreeBag;

import java.util.Iterator;
import java.util.Set;

public class HashBagTest {
    public static void main(String[] args) {
        HashBag<String> bag = new HashBag();
        bag.add("a");
        bag.add("b");
        bag.add("a", 5);
        bag.add("b");
        Iterator iterator = bag.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
        Set<String> set = bag.uniqueSet();
        for (String s: set) {
            System.out.println(s + "==>" + bag.getCount(s));
        }
        //TreeBag为有序，此处不再列举
    }
}
