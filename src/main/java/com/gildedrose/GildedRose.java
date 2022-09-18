package com.gildedrose;

import com.gildedrose.items.Item;

import java.util.List;

public class GildedRose {
    List<Item> items;

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            item.update();
        }
    }
}
