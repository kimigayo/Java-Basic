package com.kimigayo.basics.extend.constructor.order;

public class Beetle extends Insect{
    int k=printInit("Beetle.k initialized");

    public Beetle() {
        System.out.println("k="+k);
        System.out.println("j="+j);
    }
    private static int x2=printInit("static Beetle.x2 initialized");
    static {
        System.out.println("Beetle region");
    }

}

class Test{
    public static void main(String[] args) {
        System.out.println("Beetle constructor");
        Beetle beetle =null;
        new Beetle();
    }
}
