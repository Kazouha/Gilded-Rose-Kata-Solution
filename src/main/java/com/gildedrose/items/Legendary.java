package com.gildedrose.items;

public class Legendary extends Item {

    public Legendary(String name, int daysToSell, int quality) {
        super(name, daysToSell, quality);
        this.quality = 80;
    }

}
