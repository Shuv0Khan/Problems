package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestRepeatingReplacementTest {
    @Test
    @DisplayName("basic tests")
    void basicTests() {
        LongestRepeatingReplacement obj = new LongestRepeatingReplacement();

        String s = "ABAB";
        int k = 2;
        assertEquals(4, obj.characterReplacement(s, k));

        s = "AABABBA";
        k = 1;
        assertEquals(4, obj.characterReplacement(s, k));

        s = "AAABCAAA";
        k = 2;
        assertEquals(8, obj.characterReplacement(s, k));

        s = "ABCDE";
        k = 2;
        assertEquals(3, obj.characterReplacement(s, k));

        s = "KJHAABAACAAYTR";
        k = 2;
        assertEquals(8, obj.characterReplacement(s, k));

        s = "ABBC";
        k = 2;
        assertEquals(4, obj.characterReplacement(s, k));

        s = "AAAABBB";
        k = 2;
        assertEquals(6, obj.characterReplacement(s, k));

        s = "ABCAD";
        k = 2;
        assertEquals(4, obj.characterReplacement(s, k));

    }
}