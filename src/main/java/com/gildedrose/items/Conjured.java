package com.gildedrose.items;

public class Conjured extends Item {

    public Conjured(String name, int daysToSell, int quality) {
        super(name, daysToSell, quality);
    }

    @Override
    public void update() {
        if (quality > 0) {
            quality -= 2;
            if (daysToSell <= 0) {
                quality -= 2;
            }
        }
        if (quality < 0) {
            quality = 0;
        }
        daysToSell--;
    }
}
