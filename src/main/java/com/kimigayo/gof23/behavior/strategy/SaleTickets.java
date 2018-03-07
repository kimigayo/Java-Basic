package com.kimigayo.gof23.behavior.strategy;

public class SaleTickets {
    private Strategy strategy;

    public SaleTickets(Strategy strategy) {
        this.strategy = strategy;
    }

    public void sale(double price){
        System.out.println("售票价格为:"+strategy.getPrice(price));
    }
}
