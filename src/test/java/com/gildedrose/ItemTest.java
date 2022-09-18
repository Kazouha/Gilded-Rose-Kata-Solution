package com.gildedrose;

import com.gildedrose.items.Brie;
import com.gildedrose.items.Item;
import com.gildedrose.items.Normal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {

    @Nested
    class NormalTest {

        @Test
        @DisplayName("Normal item's quality degrades by 1 each day")
        void test_1() {
            // Arrange
            Item normal = new Normal("foo", 3, 3);

            // Act
            normal.update();

            // Assert
            assertThat(normal.getQuality()).isEqualTo(2);
        }

        @Test
        @DisplayName("Normal item's quality degrades by 2 each day after daysToSell is passed")
        void test_2() {
            // Arrange
            Item normal = new Normal("foo", 0, 4);

            // Act
            normal.update();

            // Assert
            assertThat(normal.getQuality()).isEqualTo(2);
        }

        @Test
        @DisplayName("Quality cannot be negative")
        void test_3() {
            // Arrange
            Item normal = new Normal("foo", 0, 0);

            // Act
            normal.update();

            // Assert
            assertThat(normal.getQuality()).isZero();
        }
    }

    @Nested
    class BrieTest {
        @Test
        @DisplayName("Quality of Aged Brie increses the older it gets")
        void test_1() {
            // Arrange
            Item brie = new Brie("Aged Brie", 10, 10);

            // Act
            brie.update();

            // Assert
            assertThat(brie.getQuality()).isEqualTo(11);
        }

        @Test
        @DisplayName("Quality cannot be over 50")
        void test_2() {
            // Arrange
            Item brie = new Brie("Aged Brie", 10, 50);

            // Act
            brie.update();

            // Assert
            assertThat(brie.getQuality()).isEqualTo(50);
        }
    }

}