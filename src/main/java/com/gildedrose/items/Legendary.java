package com.gildedrose.items;

public class Legendary extends Item {

    public Legendary(String name, int daysToSell, int quality) {
        super(name, daysToSell, quality);
        this.quality = 80;
    }

    @Override
    public void update() {
        // Method should do nothing, because values of legendary items do not change
    }
}
