package com.kimigayo.basics.extend;

public class Apple extends Fruit {
    public String name;
    public Float price;

    public static void main(String[] args) {
        Fruit fruit = new Apple("红蛇果",10f);
        Apple apple = new Apple("红蛇果",10f);
        System.out.println(fruit.getName());
        System.out.println(fruit.name);
        System.out.println(fruit.getType());
        System.out.println(apple.getName());
        System.out.println(apple.name);
        System.out.println(apple.getPrice());
        System.out.println(apple.getType());
    }

    public Apple(String name, Float price) {
        super(name,"苹果");
        this.name = name;
        this.price = price;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
