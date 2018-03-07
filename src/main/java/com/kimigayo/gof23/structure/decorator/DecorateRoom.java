package com.kimigayo.gof23.structure.decorator;

public class DecorateRoom implements IRoom {
    private IRoom room;

    public DecorateRoom(IRoom room) {
        this.room = room;
    }

    public void decorate() {
        room.decorate();
    }
}
