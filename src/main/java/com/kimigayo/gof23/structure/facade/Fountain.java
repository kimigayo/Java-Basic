package com.kimigayo.gof23.structure.facade;

public class Fountain implements Water{
    @Override
    public void BoilWater() {
        System.out.println("烧开水");
    }
}
