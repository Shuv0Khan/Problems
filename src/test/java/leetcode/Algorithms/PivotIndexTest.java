package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PivotIndexTest {
    @Test
    @DisplayName("basic test")
    void basicTest() {
        int[] nums = new int[]{0};
        assertEquals(0, PivotIndex.findIndex(nums));

        nums = new int[]{0, 0};
        assertEquals(0, PivotIndex.findIndex(nums));

        nums = new int[]{1, 1, 1};
        assertEquals(1, PivotIndex.findIndex(nums));

        nums = new int[]{1,7,3,6,5,6};
        assertEquals(3, PivotIndex.findIndex(nums));

        nums = new int[]{1,2,3};
        assertEquals(-1, PivotIndex.findIndex(nums));

        nums = new int[]{1, 1};
        assertEquals(-1, PivotIndex.findIndex(nums));

        nums = new int[]{2,1,-1};
        assertEquals(0, PivotIndex.findIndex(nums));
    }
}