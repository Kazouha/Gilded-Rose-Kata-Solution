package com.gildedrose;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
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
            } else if (isBackstagePass(item) && item.sellIn <= 0) {
                decreaseQuality(item);
            }
            else {
                increaseQuality(item);
            }

            item.sellIn = item.sellIn - 1;
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

            if (isBackstagePass(item) && item.sellIn > 0) {
                if (item.sellIn < 11 && item.quality < 50) {
                    item.quality++;
                }

                if (item.sellIn < 6 && item.quality < 50) {
                    item.quality++;
                }
            }
        }
    }

    private static void decreaseQuality(Item item) {
        if (!isSulfuras(item) && item.quality > 0) {
            item.quality--;
            if (item.sellIn <= 0 && item.quality > 0) {
                item.quality--;
                if (isBackstagePass(item)) {
                    item.quality = 0;
                }
            }
        }
    }
}
