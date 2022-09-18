package com.gildedrose.items;

public class Item {
    public final String name;

    public int daysToSell;

    public int quality;

    public Item(String name, int daysToSell, int quality) {
        this.name = name;
        this.daysToSell = daysToSell;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.daysToSell + ", " + this.quality;
    }

    public String getName() {
        return name;
    }

    public int getQuality() {
        return quality;
    }

    public int getDaysToSell() {
        return daysToSell;
    }

    public void update() {

    }
}