package com.kimigayo.gof23.behavior.observer;

public class ConcreteObserver implements Observer{
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public void update(Subject subject) {
        if(subject instanceof ConcreteSubject){
            this.state = ((ConcreteSubject)subject).getState();
        }
    }
}
