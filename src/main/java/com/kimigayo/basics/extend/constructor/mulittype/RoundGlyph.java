package com.kimigayo.basics.extend.constructor.mulittype;

public class RoundGlyph extends Glyph {
    private int radius=1;
    private String str="str";
    private static int radiustatic=220;
    private int k=radiustatic++;
    public RoundGlyph(int r) {
        radius=r;
        System.out.println("RoundGlyph.draw,radius"+radius+str);
        System.out.println("RoundGlyph.draw,radiustatic"+radiustatic);
    }

    @Override
    void draw() {
        System.out.println("RoundGlyph.draw,radius"+radius+str);
        System.out.println("RoundGlyph.draw(),raduistatic"+radiustatic);
    }

    public static void main(String[] args) {
        new RoundGlyph(100);
        new RoundGlyph(100);
        new RoundGlyph(100);
    }
}

