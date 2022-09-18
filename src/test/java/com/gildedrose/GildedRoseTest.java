package com.gildedrose;

import com.gildedrose.items.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {
    @Test
    @DisplayName("First item's name is foo")
    void test_1() {
        // Arrange
        List<Item> items = new ArrayList<>(List.of(new Normal("foo", 0, 0)));
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertThat(app.items.get(0).getName()).isEqualTo("foo");
    }

    @Test
    @DisplayName("Normal item's quality degrades by 1 each day")
    void test_2() {
        // Arrange
        List<Item> items = new ArrayList<>(List.of(new Normal("foo", 3, 3)));
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertThat(app.items.get(0).getDaysToSell()).isEqualTo(2);
        assertThat(app.items.get(0).getQuality()).isEqualTo(2);
    }
    @Test
    @DisplayName("Normal item's quality degrades by 2 each day after sellIn date is passed")
    void test_3() {
        // Arrange
        List<Item> items = new ArrayList<>(List.of(new Normal("foo", 0, 10)));
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertThat(app.items.get(0).getQuality()).isEqualTo(8);
    }

    @Test
    @DisplayName("Quality cannot be negative")
    void  test_4() {
        // Arrange
        List<Item> items = new ArrayList<>(List.of(
                new Normal("foo", 0, 0),
                new Conjured("Conjured Item", 5, 1),
                new Conjured("Conjured Item", 0 , 0)));
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertThat(app.items.get(0).getQuality()).isZero();
        assertThat(app.items.get(1).getQuality()).isZero();
        assertThat(app.items.get(2).getQuality()).isZero();
    }

    @Test
    @DisplayName("Quality of Aged Brie increses the older it gets")
    void test_5() {
        // Arrange
        List<Item> items = new ArrayList<>(List.of(new Brie("Aged Brie", 10, 20)));
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertThat(app.items.get(0).getQuality()).isGreaterThan(20);
    }

    @Test
    @DisplayName("Quality cannot rise above 50")
    void test_6() {
        // Arrange
        List<Item> items = new ArrayList<>(List.of(
                new Brie("Aged Brie", 10, 50),
                new BackstagePass("Backstage pass", 10, 50),
                new BackstagePass("Backstage pass", 5, 50)));
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertThat(app.items.get(0).getQuality()).isEqualTo(50);
        assertThat(app.items.get(1).getQuality()).isEqualTo(50);
        assertThat(app.items.get(2).getQuality()).isEqualTo(50);
    }

    @Test
    @DisplayName("Quality of Sulfuras never changes")
    void test_7() {
        // Arrange
        List<Item> items = new ArrayList<>(List.of(new Legendary("Sulfuras, Hand of Ragnaros", 3, 80)));
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertThat(app.items.get(0).getQuality()).isEqualTo(80);
    }

    @Test
    @DisplayName("SellIn value of Sulfaras never changes")
    void test_8() {
        // Arrange
        List<Item> items = new ArrayList<>(List.of(new Legendary("Sulfuras, Hand of Ragnaros", 3, 80)));
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertThat(app.items.get(0).getDaysToSell()).isEqualTo(3);
    }

    @Test
    @DisplayName("Quality of Backstage Passes increases by 2 if SellIn value is 10 or less")
    void test_9() {
        // Arrange
        List<Item> items = new ArrayList<>(List.of(new BackstagePass("Backstage pass", 10, 20)));
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertThat(app.items.get(0).getQuality()).isEqualTo(22);
    }

    @Test
    @DisplayName("Quality of Backstage Passes increases by 3 if SellIn value is 5 or less")
    void test_10() {
        // Arrange
        List<Item> items = new ArrayList<>(List.of(new BackstagePass("Backstage pass", 5, 20)));
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertThat(app.items.get(0).getQuality()).isEqualTo(23);
    }

    @Test
    @DisplayName("Quality of Backstage Passes drops to 0 after SellIn value is passed")
    void test_11() {
        // Arrange
        List<Item> items = new ArrayList<>(List.of(new BackstagePass("Backstage pass", 0, 20)));
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertThat(app.items.get(0).getQuality()).isZero();
    }

    @Test
    @DisplayName("Quality of Conjured items decreases twice as fast as normal items")
    void test_12() {
        // Arrange
        List<Item> items = new ArrayList<>(List.of(
                new Conjured("Conjured Item", 5, 30),
                new Conjured("Conjured Item", 0 , 30)));
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertThat(app.items.get(0).getQuality()).isEqualTo(28);
        assertThat(app.items.get(1).getQuality()).isEqualTo(26);
    }

}