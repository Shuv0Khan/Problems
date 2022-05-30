package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {
    @Test
    @DisplayName("basic test")
    void basicTest() {
        char[] s = "hello".toCharArray();
        char[] rev = "olleh".toCharArray();
        ReverseString.reverseString(s);
        assertArrayEquals(rev, s);
    }
}