package com.gildedrose.items;

public class Brie extends Item{

    public Brie(String name, int daysToSell, int quality) {
        super(name, daysToSell, quality);
    }

    @Override
    public void update() {
        if (quality < 50) {
            quality++;
        }
        daysToSell--;
    }
}
