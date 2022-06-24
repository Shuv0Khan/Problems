package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstrWtRepeatTest {
    @Test
    @DisplayName("basic test")
    void basicTest() {
        String s = "abcabdac";
        assertEquals(4, LongestSubstrWtRepeat.lengthOfLongestSubstring(s));

        s = "bbbbb";
        assertEquals(1, LongestSubstrWtRepeat.lengthOfLongestSubstring(s));

        s = "pwwkew";
        assertEquals(3, LongestSubstrWtRepeat.lengthOfLongestSubstring(s));

        s = "abcadac";
        assertEquals(4, LongestSubstrWtRepeat.lengthOfLongestSubstring(s));
    }

}