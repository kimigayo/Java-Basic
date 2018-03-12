package com.kimigayo.basics.collection.commons;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.iterators.ArrayListIterator;
import org.apache.commons.collections4.iterators.FilterIterator;
import org.apache.commons.collections4.iterators.LoopingIterator;
import org.apache.commons.collections4.iterators.UniqueFilterIterator;

import java.util.Iterator;
import java.util.List;

public class FilterIteratorTest {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("ab","b","c","ab");
//        for (int i =0;i<list.size();i++){
//            System.out.println(list.get(i));
//        }
//        Iterator<String>  iterator = new UniqueFilterIterator(list.iterator());
        //自定义断言
        Iterator<String>  iterator = new FilterIterator(list.iterator(), new Predicate<String>() {
            @Override
            public boolean evaluate(String o) {
                return o.length()==1;
            }
        });
        while (iterator.hasNext())
            System.out.println(iterator.next());
        //循环迭代器
        System.out.println("======LoopingIterator=======");
        Iterator<String> iterator1 = new LoopingIterator<String>(list);
        for (int i =0;i<6;i++){
            System.out.println(iterator1.next());
        }
        //数组迭代器
        System.out.println("======ArraylistIterator=======");
        int[] ints = new int[]{1,2,3,4,5};
        Iterator<Integer>  aiterator = new ArrayListIterator<Integer>(ints,1,3);
        while (aiterator.hasNext())
            System.out.println(aiterator.next());
    }
}
