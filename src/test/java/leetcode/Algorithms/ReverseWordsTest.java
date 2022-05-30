package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseWordsTest {
    @Test
    @DisplayName("basic test")
    void basicTest() {
        String s = "Let's take LeetCode contest";
        String rev = "s'teL ekat edoCteeL tsetnoc";
        assertEquals(rev, ReverseWords.reverseWords(s));
        assertEquals(rev, ReverseWords.reverseWordsV2(s));
    }
}