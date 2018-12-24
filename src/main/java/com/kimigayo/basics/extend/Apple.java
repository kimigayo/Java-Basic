package com.kimigayo.basics.extend;

public class Apple extends Fruit {
    public String name;
    public Float price;

    public static String APPLE_STR="appleStr";

    static {
        System.out.println("apple static");
    }

    public Apple(String name, Float price) {
        super(name,"苹果");
        System.out.println("Apple constructor");
        System.out.println(APPLE_STR);
        this.name = name;
        this.price = price;
    }

    public Float getPrice() {
        return price;
    }

     public String getName() {
        return name;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
