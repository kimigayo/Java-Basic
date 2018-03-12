package com.kimigayo.basics.collection.guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MultiSetTest {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("软件园","观音山","鼓浪屿","观音山","鼓浪屿");
        Multiset multiset = HashMultiset.create();
        Iterator iterator = list.iterator();
        while (iterator.hasNext())
            multiset.add(iterator.next());
        Set<String> set = multiset.elementSet();
        for(String s:set)
            System.out.println(s+"==>"+multiset.count(s));
    }
}
