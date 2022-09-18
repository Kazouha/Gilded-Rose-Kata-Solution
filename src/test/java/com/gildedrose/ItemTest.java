package com.gildedrose;

import com.gildedrose.items.BackstagePass;
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

    @Nested
    class BackstagePassTest {

        @Test
        @DisplayName("Quality of Backstage Passes increases by 1 if daysToSell is more than 10")
        void test_1() {
            // Arrange
            Item backstagePass = new BackstagePass("Backstage Pass", 15, 10);

            // Act
            backstagePass.update();

            // Assert
            assertThat(backstagePass.getQuality()).isEqualTo(11);
        }

        @Test
        @DisplayName("Quality of Backstage Passes increases by 2 if daysToSell is 10 or less")
        void test_2() {
            // Arrange
            Item backstagePass = new BackstagePass("Backstage Pass", 10, 10);

            // Act
            backstagePass.update();

            // Assert
            assertThat(backstagePass.getQuality()).isEqualTo(12);
        }

        @Test
        @DisplayName("Quality of Backstage Passes increases by 3 if daysToSell is 5 or less")
        void test_3() {
            // Arrange
            Item backstagePass = new BackstagePass("Backstage Pass", 5, 10);

            // Act
            backstagePass.update();

            // Assert
            assertThat(backstagePass.getQuality()).isEqualTo(13);
        }

        @Test
        @DisplayName("Quality of Backstage Passes is 0 if daysToSell is passed")
        void test_4() {
            // Arrange
            Item backstagePass = new BackstagePass("Backstage Pass", 0, 10);

            // Act
            backstagePass.update();

            // Assert
            assertThat(backstagePass.getQuality()).isZero();
        }

        @Test
        @DisplayName("Quality cannot be over 50")
        void test_5() {
            // Arrange
            Item backstagePass1 = new BackstagePass("Backstage Pass", 15, 50);
            Item backstagePass2 = new BackstagePass("Backstage Pass", 10, 50);
            Item backstagePass3 = new BackstagePass("Backstage Pass", 5, 50);

            // Act
            backstagePass1.update();
            backstagePass2.update();
            backstagePass3.update();

            // Assert
            assertThat(backstagePass1.getQuality()).isEqualTo(50);
            assertThat(backstagePass2.getQuality()).isEqualTo(50);
            assertThat(backstagePass3.getQuality()).isEqualTo(50);
        }
    }

}