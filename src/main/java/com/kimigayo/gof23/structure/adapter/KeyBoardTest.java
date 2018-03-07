package com.kimigayo.gof23.structure.adapter;

/**适配器模式：对象适配器、类适配器
 * Created by chenbinbin on 2018/2/10.
 */
public class KeyBoardTest {
    public static void main(String[] args) {
        IKeyboardAdapter iKeyboardAdapter = new KeyboardAdapterObject(new Keyboard());
        iKeyboardAdapter.play();
    }
}
