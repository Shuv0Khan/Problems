package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstBadVersionTest {

    @Test
    @DisplayName("basic tests")
    void basicTests() {
        assertEquals(1, FirstBadVersion.firstBadVersion(1, 1));
        assertEquals(1, FirstBadVersion.firstBadVersion(2, 1));
        assertEquals(2, FirstBadVersion.firstBadVersion(3, 2));
        assertEquals(3, FirstBadVersion.firstBadVersion(3, 3));
        assertEquals(4, FirstBadVersion.firstBadVersion(10, 4));
        assertEquals(5, FirstBadVersion.firstBadVersion(10, 5));
        assertEquals(4, FirstBadVersion.firstBadVersion(11, 4));
        assertEquals(5, FirstBadVersion.firstBadVersion(11, 5));
    }

}