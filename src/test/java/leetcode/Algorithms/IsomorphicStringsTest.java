package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsomorphicStringsTest {
    @Test
    @DisplayName("basic tests")
    void basicTests() {
        String s = "foo";
        String t = "bar";
        assertFalse(IsomorphicStrings.isIsomorphic(s, t));

        s = "ffoo";
        t = "barr";
        assertFalse(IsomorphicStrings.isIsomorphic(s, t));

        s = "add";
        t = "egg";
        assertTrue(IsomorphicStrings.isIsomorphic(s, t));

        s = "add dad";
        t = "egg gag";
        assertFalse(IsomorphicStrings.isIsomorphic(s, t));

        s = "add dda";
        t = "egg geg";
        assertFalse(IsomorphicStrings.isIsomorphic(s, t));

        s = "aaa bbb";
        t = "ddd xxx";
        assertTrue(IsomorphicStrings.isIsomorphic(s, t));

        s = "add dad";
        t = "egg geg";
        assertTrue(IsomorphicStrings.isIsomorphic(s, t));

        s = "badc";
        t = "baba";
        assertFalse(IsomorphicStrings.isIsomorphic(s, t));

        s = "paper";
        t = "title";
        assertTrue(IsomorphicStrings.isIsomorphic(s, t));
    }
}