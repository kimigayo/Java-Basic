package com.kimigayo.gof23.structure.decorator;

public class DecorateAirconditioned extends DecorateRoom {
    public DecorateAirconditioned(IRoom room) {
        super(room);
    }

    @Override
    public void decorate() {
        super.decorate();
        System.out.println("装饰空调");
    }
}
