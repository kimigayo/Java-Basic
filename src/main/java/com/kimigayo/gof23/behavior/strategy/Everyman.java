package com.kimigayo.gof23.behavior.strategy;

public class Everyman implements Strategy{

    @Override
    public double getPrice(double price) {
        return price;
    }
}
