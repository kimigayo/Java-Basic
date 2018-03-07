package com.kimigayo.gof23.structure.adapter;

/**
 * Created by chenbinbin on 2018/2/10.
 */
public class KeyboardAdapterObject implements IKeyboardAdapter {
    private Keyboard keyboard;

    public KeyboardAdapterObject(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    @Override
    public void play() {
        keyboard.knock();
    }
}
