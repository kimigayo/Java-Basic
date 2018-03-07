package com.kimigayo.gof23.behavior.iterator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMyAggregate {
    private List<Object> list = new ArrayList<>();

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public MyIterator createIterator(){
        return new ConcreteIterator();
    }

    private class ConcreteIterator implements MyIterator{
        private int cursor;

        @Override
        public void next() {
            if(cursor<list.size()) {
                cursor++;
            }
        }

        @Override
        public boolean hasNext() {
            return list.size()>cursor;
        }

        @Override
        public boolean isFirst() {
            return cursor==0;
        }

        @Override
        public boolean isLast() {
            return cursor==list.size()-1;
        }

        @Override
        public Object getCurrentObj() {
            return list.get(cursor);
        }
    }
}