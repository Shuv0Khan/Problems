package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeciBinaryNumbersTest {
    @Test
    @DisplayName("basic test")
    void basicTest() {
        DeciBinaryNumbers dbn = new DeciBinaryNumbers();
        assertEquals(1, dbn.minPartitions("1111111"));
        assertEquals(3, dbn.minPartitions("32"));
        assertEquals(8, dbn.minPartitions("82734"));
        assertEquals(9, dbn.minPartitions("27346209830709182346"));
    }
}