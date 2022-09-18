package com.gildedrose.items;

public class BackstagePass extends Item {

    public BackstagePass(String name, int daysToSell, int quality) {
        super(name, daysToSell, quality);
    }

    @Override
    public void update() {
        if (quality >= 50) {
            return;
        }

        quality++;

        if(daysToSell < 11) {
            quality++;
        }

        if (daysToSell < 6) {
            quality++;
        }

        if (daysToSell <= 0) {
            quality = 0;
        }

        daysToSell--;
    }
}
