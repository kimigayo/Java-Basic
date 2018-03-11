package com.kimigayo.basics.collection;

public class SelfArrayList<T> {
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
}
