package com.kimigayo.gof23.creator.builder.product;

import creator.builder.component.Engine;
import creator.builder.component.Seat;
import creator.builder.component.Tyre;

/**
 * Created by chenbinbin on 2018/2/8.
 */
public abstract class AbstractCar implements Car
{
    private Engine engine;
    private Seat seat;
    private Tyre tyre;

    public AbstractCar(Engine engine, Seat seat, Tyre tyre) {
        this.engine = engine;
        this.seat = seat;
        this.tyre = tyre;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Tyre getTyre() {
        return tyre;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }
}

