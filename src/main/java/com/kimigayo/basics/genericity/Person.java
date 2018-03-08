package com.kimigayo.basics.genericity;

public class Person<T>{
    private String name;
    private int age;
    private T study;

    public T getStudy() {
        return study;
    }

    public void setStudy(T study) {
        this.study = study;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
