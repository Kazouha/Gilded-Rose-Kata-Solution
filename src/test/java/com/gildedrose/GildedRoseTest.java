package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {
    @Test
    @DisplayName("First item's name is foo")
    void test_1() {
        // Arrange
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertThat(app.items[0].name).isEqualTo("foo");
    }

    @Test
    @DisplayName("Normal item's quality degrades by 1 each day")
    void test_2() {
        // Arrange
        Item[] items = new Item[] { new Item("foo", 3, 3) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertThat(app.items[0].sellIn).isEqualTo(2);
        assertThat(app.items[0].quality).isEqualTo(2);
    }
    @Test
    @DisplayName("Normal item's quality degrades by 2 each day after sellIn date is passed")
    void test_3() {
        // Arrange
        Item[] items = new Item[] { new Item("foo", 0, 10) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertThat(app.items[0].quality).isEqualTo(8);
    }

    @Test
    @DisplayName("Quality cannot be negative")
    void  test_4() {
        // Arrange
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertThat(app.items[0].quality).isZero();
    }

    @Test
    @DisplayName("Quality of Aged Brie increses the older it gets")
    void test_5() {
        // Arrange
        Item[] items = new Item[] { new Item("Aged Brie", 10, 20) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertThat(app.items[0].quality).isGreaterThan(20);
    }

    @Test
    @DisplayName("Quality cannot rise above 50")
    void test_6() {
        // Arrange
        Item[] items = new Item[] { new Item("Aged Brie", 10, 50) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertThat(app.items[0].quality).isEqualTo(50);
    }

    @Test
    @DisplayName("Quality of Sulfuras never changes")
    void test_7() {
        // Arrange
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 3, 80) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertThat(app.items[0].quality).isEqualTo(80);
    }

    @Test
    @DisplayName("Quality of Backstage Passes increases by 2 if SellIn value is 10 or less")
    void test_8() {
        // Arrange
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertThat(app.items[0].quality).isEqualTo(22);
    }

    @Test
    @DisplayName("Quality of Backstage Passes increases by 3 if SellIn value is 5 or less")
    void test_9() {
        // Arrange
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertThat(app.items[0].quality).isEqualTo(23);
    }

    @Test
    @DisplayName("Quality of Backstage Passes drops to 0 after SellIn value is passed")
    void test_10() {
        // Arrange
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertThat(app.items[0].quality).isZero();
    }


}