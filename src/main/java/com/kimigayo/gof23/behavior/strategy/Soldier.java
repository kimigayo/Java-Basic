package com.kimigayo.gof23.behavior.strategy;

public class Soldier implements Strategy{
    @Override
    public double getPrice(double price) {
        return price*0.8;
    }
}
