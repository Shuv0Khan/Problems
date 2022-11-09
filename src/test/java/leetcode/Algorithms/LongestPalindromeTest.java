package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromeTest {
    @Test
    @DisplayName("basic test")
    void basicTest() {
        assertEquals(1, LongestPalindrome.longestPalindrome("a"));
        assertEquals(3, LongestPalindrome.longestPalindrome("aba"));
        assertEquals(2, LongestPalindrome.longestPalindrome("aa"));
        assertEquals(3, LongestPalindrome.longestPalindrome("abAb"));
        assertEquals(6, LongestPalindrome.longestPalindrome("abaccabd"));
        assertEquals(1, LongestPalindrome.longestPalindrome("abcd"));
        assertEquals(1, LongestPalindrome.longestPalindrome("abdcabd"));
    }
}