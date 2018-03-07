package com.kimigayo.gof23.behavior.iterator;

/**
 * 迭代器模式
 * 应用场景：JDK内置的迭代器（List/Set）
 */
public class IteratorTest {
    public static void main(String[] args) {
        ConcreteMyAggregate aggregate = new ConcreteMyAggregate();
        aggregate.getList().add("jack");
        aggregate.getList().add("mick");
        aggregate.getList().add("owen");
        MyIterator iterator = aggregate.createIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.getCurrentObj().toString());
            iterator.next();
        }
    }
}
