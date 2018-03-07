package com.kimigayo.gof23.structure.decorator;

public class DecorateDesk extends DecorateRoom{
    public DecorateDesk(IRoom room) {
        super(room);
    }

    @Override
    public void decorate() {
        super.decorate();
        System.out.println("装饰桌子");
    }
}
