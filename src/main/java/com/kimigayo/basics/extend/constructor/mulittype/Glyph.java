package com.kimigayo.basics.extend.constructor.mulittype;

public class Glyph {
    void draw(){
        System.out.println("Glyph.draw()");
    }

    public Glyph() {
        System.out.println("Glyph.draw before");
        this.draw();
        System.out.println("Glyph.draw after");
    }
}
