package com.kimigayo.gof23.structure.adapter;

/**
 * Created by chenbinbin on 2018/2/10.
 */
public class KeyboardAdapterClass extends Keyboard implements IKeyboardAdapter {
    @Override
    public void play() {
        super.knock();
    }
}
