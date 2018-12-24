package com.kimigayo.basics.extend.constructor.order;

public class OrderOfInitialization {
    public static void main(String[] args) {
        House house = new House();
        house.f();
    }
}

class Window{
    public Window(int i) {
        System.out.println("Window="+i);
    }
}

class House{
    private Window w1=new Window(1);

    public House() {
        System.out.println("House");
        w3=new Window(33);
    }
    private Window w2=new Window(2);
    void f(){
        System.out.println("f()");
    }
    private Window w3=new Window(3);
}
