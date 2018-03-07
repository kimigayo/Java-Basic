package com.kimigayo.gof23.structure.flyweight;

public class ConcreteFlyweight implements Flyweight {
    private String name;

    public ConcreteFlyweight(String name) {
        this.name = name;
    }

    @Override
    public void action() {
        System.out.println("名称="+name);
    }

    @Override
    public void getAge(UnsharedConreteFlyweight flyweight) {
        System.out.println("年龄="+flyweight.getAge());
    }
}
