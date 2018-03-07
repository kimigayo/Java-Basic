package com.kimigayo.gof23.creator.builder.factory;

import com.kimigayo.gof23.creator.builder.component.Engine;
import com.kimigayo.gof23.creator.builder.component.Seat;
import com.kimigayo.gof23.creator.builder.component.Tyre;

/**
 * Created by chenbinbin on 2018/2/8.
 */
public interface CarFactory {
    Engine createEngine();
    Seat createSeat();
    Tyre createTyre();
}
