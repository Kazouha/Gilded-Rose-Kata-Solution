package com.gildedrose.items;

public abstract class Item {
    private final String name;

    protected int daysToSell;

    protected int quality;

    protected Item(String name, int daysToSell, int quality) {
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

    public abstract void update();
}