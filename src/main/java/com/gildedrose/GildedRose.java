package com.gildedrose;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!isAgedBree(item)
                    && !isBackstagePass(item)) {
                if (item.quality > 0 && !isSulfuras(item)) {
                    item.quality = item.quality - 1;
                }
            } else {
                increaseQuality(item);
            }

            if (!isSulfuras(item)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!isAgedBree(item)) {
                    if (!isBackstagePass(item)) {
                        if (item.quality > 0 && !isSulfuras(item)) {
                            item.quality = item.quality - 1;
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
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

}
