package com.kimigayo.gof23.behavior.mediator;

public class Design implements Department {
    private Meditator meditator;

    public Design(Meditator meditator) {
        this.meditator = meditator;
        meditator.relative("design",this);
    }

    @Override
    public void selfWork() {
        System.out.println("进行设计工作");
    }

    @Override
    public void nextWork() {
        meditator.work("develop");
    }
}
