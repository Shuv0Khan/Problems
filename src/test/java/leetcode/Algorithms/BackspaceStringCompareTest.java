package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackspaceStringCompareTest {
    @Test
    @DisplayName("basic test")
    void basicTest() {
        BackspaceStringCompare obj = new BackspaceStringCompare();

        String source = "ab##a#";
        String target = "cde###";
        assertTrue(obj.backspaceCompare(source, target));
        assertTrue(obj.backspaceCompareSol2(source, target));

        source = "ab#c";
        target = "ad#c";
        assertTrue(obj.backspaceCompare(source, target));
        assertTrue(obj.backspaceCompareSol2(source, target));

        source = "ab##";
        target = "c#d#";
        assertTrue(obj.backspaceCompare(source, target));
        assertTrue(obj.backspaceCompareSol2(source, target));

        source = "a#c";
        target = "b";
        assertFalse(obj.backspaceCompare(source, target));
        assertFalse(obj.backspaceCompareSol2(source, target));

        source = "bxj##tw";
        target = "bxj###tw";
        assertFalse(obj.backspaceCompare(source, target));
        assertFalse(obj.backspaceCompareSol2(source, target));

        source = "bxj##tw######";
        target = "bxj###tw#####";
        assertTrue(obj.backspaceCompare(source, target));
        assertTrue(obj.backspaceCompareSol2(source, target));

        source = "y#fo##f";
        target = "y#f#o##f";
        assertTrue(obj.backspaceCompare(source, target));
        assertTrue(obj.backspaceCompareSol2(source, target));

        source = "abcd";
        target = "bbcd";
        assertFalse(obj.backspaceCompare(source, target));
        assertFalse(obj.backspaceCompareSol2(source, target));

        source = "a##c";
        target = "#a#c";
        assertTrue(obj.backspaceCompare(source, target));
        assertTrue(obj.backspaceCompareSol2(source, target));
    }
}