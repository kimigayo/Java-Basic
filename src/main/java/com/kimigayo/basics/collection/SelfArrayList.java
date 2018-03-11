package com.kimigayo.basics.collection;

import java.util.Iterator;

public class SelfArrayList<T> implements Iterable<T>{
    private Object[] objects;
    private int size;

    public SelfArrayList(){
        this(10);
    }

    public SelfArrayList(int size){
        objects = new Object[size+2];
    }

    public void add(T t){
        if(size>=(objects.length-1)){
            Object[] newObjects = new Object[size*2+2];
            System.arraycopy(objects,0,newObjects,0,size+1);
            objects = newObjects;
        }
        objects[size] = t;
        size++;
    }

    public T get(int index) throws Exception {
        ensureSize(index);
        return (T) objects[index];
    }

    public void remove(int index) throws Exception {
        ensureSize(index);
        Object[] newObjects = new Object[objects.length];
        System.arraycopy(objects,0,newObjects,0,size);
        System.arraycopy(objects,index+1,newObjects,index,size-index-1);
        this.objects=newObjects;
        size--;
    }

    private void ensureSize(int index) throws Exception {
        if(index>=size||index<0){
            throw new Exception("输入参数不在正常值");
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return new MyItr();
    }

    private class MyItr<T> implements Iterator<T>{
        private int consor=0;
        private int lastSet=-1;

        @Override
        public boolean hasNext() {
            return consor!=size;
        }

        @Override
        public T next() {
            T t = (T) objects[consor];
            lastSet =consor++;
            return t;
        }

        @Override
        public void remove() {
            Object[] newObjects = new Object[objects.length];
            System.arraycopy(objects,0,newObjects,0,objects.length);
            System.arraycopy(objects,lastSet+1,newObjects,lastSet,size-1);
            newObjects[size-1]=null;
            objects=newObjects;
            size--;
        }
    }
}
