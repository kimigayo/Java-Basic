package com.kimigayo.gof23.behavior.templateMethod;

public class TemplateMethodTest {
    public static void main(String[] args) {
        BankTemplateMethod method = new BankTemplateMethod() {
            @Override
            protected void handleBusiness() {
                System.out.println("办理存款业务！");
            }
        };
        method.process();
    }
}
