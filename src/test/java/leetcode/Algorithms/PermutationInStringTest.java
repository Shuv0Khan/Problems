package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermutationInStringTest {
    @Test
    @DisplayName("basic test")
    void basicTest() {
        String s1 = "abcd";
        String s2 = "adbc";
        assertTrue(PermutationInString.checkInclusion(s1, s2));
        assertTrue(PermutationInString.checkInclusionV2(s1, s2));

        s1 = "abced";
        s2 = "adbc";
        assertFalse(PermutationInString.checkInclusion(s1, s2));
        assertFalse(PermutationInString.checkInclusionV2(s1, s2));

        s1 = "abcd";
        s2 = "adbec";
        assertFalse(PermutationInString.checkInclusion(s1, s2));
        assertFalse(PermutationInString.checkInclusionV2(s1, s2));

        s1 = "abcd";
        s2 = "adeabcd";
        assertTrue(PermutationInString.checkInclusion(s1, s2));
        assertTrue(PermutationInString.checkInclusionV2(s1, s2));

        s1 = "hello";
        s2 = "ooolleoooleh";
        assertFalse(PermutationInString.checkInclusion(s1, s2));
        assertFalse(PermutationInString.checkInclusionV2(s1, s2));

        s1 = "adc";
        s2 = "dcda";
        assertTrue(PermutationInString.checkInclusion(s1, s2));
        assertTrue(PermutationInString.checkInclusionV2(s1, s2));

        s1 = "aadc";
        s2 = "dcada";
        assertTrue(PermutationInString.checkInclusion(s1, s2));
        assertTrue(PermutationInString.checkInclusionV2(s1, s2));

        s1 = "aaaa";
        s2 = "dcadaaa";
        assertFalse(PermutationInString.checkInclusion(s1, s2));
        assertFalse(PermutationInString.checkInclusionV2(s1, s2));

        s1 = "aaaa";
        s2 = "dcaaaa";
        assertTrue(PermutationInString.checkInclusion(s1, s2));
        assertTrue(PermutationInString.checkInclusionV2(s1, s2));

        s1 = "abcdxabcde";
        s2 = "abcdeabcdx";
        assertTrue(PermutationInString.checkInclusion(s1, s2));
        assertTrue(PermutationInString.checkInclusionV2(s1, s2));
    }
}