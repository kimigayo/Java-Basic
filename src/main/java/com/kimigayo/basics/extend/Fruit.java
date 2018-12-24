package com.kimigayo.basics.extend;

public class Fruit {
    public String type;
    public String name;

    public static String FRUIT_STR="fruitStr";

    static {
        System.out.println("fruit static");
    }
    public Fruit(String type, String name) {
        System.out.println("fruit constructor");
        System.out.println(FRUIT_STR);
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
        System.out.println(fruit);
        System.out.println(apple);
    }
}
