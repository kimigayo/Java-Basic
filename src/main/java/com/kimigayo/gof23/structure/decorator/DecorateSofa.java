package com.kimigayo.gof23.structure.decorator;

public class DecorateSofa extends DecorateRoom {
    public DecorateSofa(IRoom room) {
        super(room);
    }

    @Override
    public void decorate() {
        super.decorate();
        System.out.println("装饰沙发");
    }
}
