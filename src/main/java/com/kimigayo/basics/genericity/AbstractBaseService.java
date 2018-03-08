package com.kimigayo.basics.genericity;

public abstract class AbstractBaseService<T> implements IBaseService<T> {
//    public T static name;不能修饰static\final变量
    @Override
    public T add(T t) {
        return t;
    }

}
