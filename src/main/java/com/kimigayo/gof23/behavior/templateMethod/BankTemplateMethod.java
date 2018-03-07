package com.kimigayo.gof23.behavior.templateMethod;

public abstract class BankTemplateMethod {
    private void takeNumber(){
        System.out.println("排队取号！");
    }

    private void serviceEvaluate(){
        System.out.println("服务评价!");
    }

    protected abstract void handleBusiness();

    public void process(){
        takeNumber();
        handleBusiness();
        serviceEvaluate();
    }
}
