package com.kimigayo.gof23.behavior.mediator;

public class Test implements Department {
    private Meditator meditator;

    public Test(Meditator meditator) {
        this.meditator = meditator;
        meditator.relative("test",this);
    }

    @Override
    public void selfWork() {
        System.out.println("进行测试工作");
    }

    @Override
    public void nextWork() {
        System.out.println("进行现场测试");
       }
}
