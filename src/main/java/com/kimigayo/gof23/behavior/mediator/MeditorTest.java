package com.kimigayo.gof23.behavior.mediator;

/**
 * 中介者模式
 * 本质：解耦多个同事对象之间的交互关系。每个对象都持有中介者对象的引用，只和中介者对象打交道，我们通过中介者对象统一管理这些关系
 */
public class MeditorTest {
    public static void main(String[] args) {
        Meditator meditator = new ProjectManager();
        Design design = new Design(meditator);
        Develop develop = new Develop(meditator);
        Test test = new Test(meditator);
        design.selfWork();
        design.nextWork();
    }
}
