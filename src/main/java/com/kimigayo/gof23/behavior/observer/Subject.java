package com.kimigayo.gof23.behavior.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> list = new ArrayList<>();

    protected void notifyObserver(){
        for(Observer observer : list){
            observer.update(this);
        }
    }

    public List<Observer> getList() {
        return list;
    }

    public void setList(List<Observer> list) {
        this.list = list;
    }
}
