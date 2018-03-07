package com.kimigayo.gof23.creator.builder.product;


import com.kimigayo.gof23.creator.builder.component.Engine;
import com.kimigayo.gof23.creator.builder.component.Seat;
import com.kimigayo.gof23.creator.builder.component.Tyre;

/**
 * Created by chenbinbin on 2018/2/7.
 */
public class Aodi extends AbstractCar {
    public Aodi(Engine engine, Seat seat, Tyre tyre) {
        super(engine, seat, tyre);
    }

    @Override
    public void run() {
        System.out.println("奥迪------》》》》");
    }
}
