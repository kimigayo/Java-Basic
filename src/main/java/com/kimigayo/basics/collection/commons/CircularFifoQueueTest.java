package com.kimigayo.basics.collection.commons;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.PredicateUtils;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.functors.UniquePredicate;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.apache.commons.collections4.queue.PredicatedQueue;
import org.apache.commons.collections4.queue.UnmodifiableQueue;

import java.util.Queue;

public class CircularFifoQueueTest {
    public static void main(String[] args) {
        CircularFifoQueue<String> queue = new CircularFifoQueue<>(2);
        queue.add("a");
        queue.add("b");
        queue.add("c");
        Queue<String> queue1 = UnmodifiableQueue.unmodifiableQueue(queue);//使queue1不可修改，设置相当于快照，不够安全
        queue.add("d");
        Predicate<String> predicate1 = PredicateUtils.allPredicate(UniquePredicate.uniquePredicate(),NotNullPredicate.notNullPredicate());
        Queue<String> queue2 = PredicatedQueue.predicatedQueue(queue1,predicate1);
//        queue.add(null);
        queue.add("d");
        for (String s:queue2)
            System.out.println(s);
    }
}
