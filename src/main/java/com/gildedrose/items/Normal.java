package com.gildedrose.items;

public class Normal extends Item {

    public Normal(String name, int daysToSell, int quality) {
        super(name, daysToSell, quality);
    }

    @Override
    public void update() {
        if (quality > 0) {
            quality--;
            if (daysToSell <= 0) {
                quality--;
            }
        }
        daysToSell--;
    }
}
