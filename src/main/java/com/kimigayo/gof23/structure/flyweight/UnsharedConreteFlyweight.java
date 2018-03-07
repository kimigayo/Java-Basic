package com.kimigayo.gof23.structure.flyweight;

public class UnsharedConreteFlyweight {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UnsharedConreteFlyweight(int age) {

        this.age = age;
    }
}
