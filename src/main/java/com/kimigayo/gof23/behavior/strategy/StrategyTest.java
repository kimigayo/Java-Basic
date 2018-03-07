package com.kimigayo.gof23.behavior.strategy;

public class StrategyTest {
    public static void main(String[] args) {
        SaleTickets tickets = new SaleTickets(new Student());
        tickets.sale(998);
    }
}
