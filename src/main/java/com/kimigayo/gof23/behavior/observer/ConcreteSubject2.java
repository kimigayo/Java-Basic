package com.kimigayo.gof23.behavior.observer;

import java.util.Observable;

public class ConcreteSubject2 extends Observable {
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        setChanged();
        notifyObservers(state);
    }
}
