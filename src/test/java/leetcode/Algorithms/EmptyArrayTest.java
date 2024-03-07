package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmptyArrayTest {
    @Test
    @DisplayName("basic test")
    void basicTest() {
        assertEquals(4, new EmptyArray().minOperations(new int[]{2,3,3,2,2,4,2,3,4}));
    }
}