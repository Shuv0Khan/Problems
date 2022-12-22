package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FindAllAnagramsTest {
    @Test
    @DisplayName("basic test")
    void basicTest() {
        String s = "cbaebabacd";
        String p = "abc";
        assertIterableEquals(Arrays.asList(0,6), FindAllAnagrams.findAnagrams(s, p));

        s = "abab";
        p = "ab";
        assertIterableEquals(Arrays.asList(0,1,2), FindAllAnagrams.findAnagrams(s, p));
    }
}