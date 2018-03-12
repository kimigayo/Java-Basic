package com.kimigayo.basics.collection.guava;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;

public class SetsTest {
    public static void main(String[] args) {
        Set<String> set1 = Sets.newHashSet("软件园","观音山","白鹭洲","东渡码头");
        Set<String> set2 = Sets.newHashSet("软件园","观音山","白鹭洲","轮渡码头");
        Set<String> set3 = Sets.intersection(set1,set2);
        Set<String> set4 = Sets.difference(set1,set2);
        Set<String> set5 = Sets.union(set1,set2);
        for (String s:set3){
            System.out.println(s);
        }
        System.out.println("===================");
        for (String s:set4){
            System.out.println(s);
        }
        System.out.println("===================");
        for (String s:set5){
            System.out.println(s);
        }
    }
}
