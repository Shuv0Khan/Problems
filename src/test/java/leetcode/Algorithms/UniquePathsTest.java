package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniquePathsTest {
    @Test
    @DisplayName("basic test")
    void basicTest() {
        assertEquals(28, UniquePaths.uniquePaths(3, 7));
        assertEquals(3, UniquePaths.uniquePaths(3, 2));
    }
}