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
            if (isSulfuras(item)) {
                item.quality = 80;
                continue;
            }

            if (!isAgedBree(item)
                    && !isBackstagePass(item)) {
                decreaseQuality(item);
            } else if (isBackstagePass(item) && item.getDaysToSell() <= 0) {
                decreaseQuality(item);
            }
            else {
                increaseQuality(item);
            }

            item.daysToSell = item.daysToSell - 1;
        }
    }

    private static boolean isAgedBree(Item item) {
        return (item.name.equals("Aged Brie"));
    }

    private static boolean isBackstagePass(Item item) {
        return (item.name.contains("Backstage pass"));
    }

    private static boolean isSulfuras(Item item) {
        return (item.name.equals("Sulfuras, Hand of Ragnaros"));
    }

    private static void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;

            if (isBackstagePass(item) && item.daysToSell > 0) {
                if (item.daysToSell < 11 && item.quality < 50) {
                    item.quality++;
                }

                if (item.daysToSell < 6 && item.quality < 50) {
                    item.quality++;
                }
            }
        }
    }

    private static void decreaseQuality(Item item) {
        if (!isSulfuras(item) && item.quality > 0) {
            item.quality--;
            if (item.daysToSell <= 0 && item.quality > 0) {
                item.quality--;
                if (isBackstagePass(item)) {
                    item.quality = 0;
                }
            }
        }
    }
}
