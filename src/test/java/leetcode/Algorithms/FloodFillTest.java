package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloodFillTest {

    @Test
    @DisplayName("basic test")
    void basicTest() {
        int[][] image = new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int [][] filled = new int[][]{
                {2, 2, 2},
                {2, 2, 0},
                {2, 0, 1}
        };

        FloodFill.floodFill(image, 1, 1, 2);

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                assertEquals(filled[i][j], image[i][j]);
            }
        }
    }

}