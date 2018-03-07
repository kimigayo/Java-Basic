package com.kimigayo.gof23.behavior.observer;

import java.util.Observable;
import java.util.Observer;

public class ConcreteObserver2 implements Observer {
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.state=((ConcreteSubject2)o).getState();
    }
}
