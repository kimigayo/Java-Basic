package com.kimigayo.gof23.behavior.strategy;

public class Student implements Strategy{
    @Override
    public double getPrice(double price) {
        return price*0.5;
    }
}
