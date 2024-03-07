package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StrictlyPalindromTest {
    @Test
    @DisplayName("basic test")
    void basicTest() {
        StrictlyPalindrom sp = new StrictlyPalindrom();
        assertFalse(sp.isStrictlyPalindromic(9));
    }
}