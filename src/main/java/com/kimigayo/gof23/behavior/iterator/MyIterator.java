package com.kimigayo.gof23.behavior.iterator;

public interface MyIterator {
    boolean hasNext();
    boolean isFirst();
    boolean isLast();
    Object getCurrentObj();
    void next();
}
