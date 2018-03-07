package com.kimigayo.gof23.behavior.mediator;

public class Develop implements Department {
    private Meditator meditator;

    public Develop(Meditator meditator) {
        this.meditator = meditator;
        meditator.relative("develop",this);
    }

    @Override
    public void selfWork() {
        System.out.println("进行开发工作");

    }

    @Override
    public void nextWork() {
        meditator.work("test");
    }
}
