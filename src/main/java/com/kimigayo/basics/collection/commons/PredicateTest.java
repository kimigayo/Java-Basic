package com.kimigayo.basics.collection.commons;


import com.google.common.collect.Lists;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.PredicateUtils;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.functors.UniquePredicate;
import org.apache.commons.collections4.list.PredicatedList;

import java.util.List;

public class PredicateTest {
    public static void main(String[] args) {
        Predicate predicate = NotNullPredicate.notNullPredicate();
        Predicate predicate1 = UniquePredicate.uniquePredicate();
        Predicate all = PredicateUtils.allPredicate(predicate,predicate1);
        //        System.out.println(predicate.evaluate(null));
        List<String> list1 = PredicatedList.predicatedList(Lists.newArrayList(),predicate);
        list1.add("软件园");
//        list1.add("软件园");
        list1.add("鼓浪屿");
//        list1.add(null);
    }
}
