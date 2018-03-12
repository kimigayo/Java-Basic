package com.kimigayo.basics.collection.guava;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;

public class Collections2Test {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("软件园","观音山","白鹭洲","东渡码头");
//        Collection<String> list2 = Collections2.filter(list, new Predicate<String>() {
//            @Override
//            public boolean apply(String s) {
//                return s.length()>3;
//            }
//        });
//        for (String s :list2)
//            System.out.println(s);
        Collection<Object> objects = Collections2.transform(list, new Function<String, Object>() {
            @Override
            public Object apply(String s) {
                return "厦门-"+s;
            }
        });
        for (Object o:objects){
            System.out.println(o);
        }
    }
}
