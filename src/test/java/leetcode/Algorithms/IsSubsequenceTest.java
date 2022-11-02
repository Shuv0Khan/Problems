package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsSubsequenceTest {
    @Test
    @DisplayName("basic test")
    void basicTest() {
        String s = "ace";
        String t = "ahbgdcert";
        assertTrue(IsSubsequence.isSubsequence(s, t));

        s = "axc";
        t = "ahbgdc";
        assertFalse(IsSubsequence.isSubsequence(s, t));

        s = "aec";
        t = "ahbgdcert";
        assertFalse(IsSubsequence.isSubsequence(s, t));

        s = "aaec";
        t = "ahbgdaec";
        assertTrue(IsSubsequence.isSubsequence(s, t));

        s = "aaaa";
        t = "ahbgdaecaa";
        assertTrue(IsSubsequence.isSubsequence(s, t));
    }
}