package com.kimigayo.basics.collection.commons;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.List;

public class CollectionsTest {
    public static void main(String[] args) {
        List<Integer> list1=Lists.newArrayList(1,2,45,32,111,98);
        List<Integer> list2=Lists.newArrayList(1,21,12,32,87,98);
//        Collection collection = CollectionUtils.intersection(list1,list2);
//        Collection collection = CollectionUtils.retainAll(list1,list2);
//        Collection collection = CollectionUtils.subtract(list1,list2);
//        Collection collection = CollectionUtils.union(list1,list2);
        Collection collection = CollectionUtils.retainAll(list1,list2);
        for (Object o:collection)
            System.out.println(o);
    }
}
