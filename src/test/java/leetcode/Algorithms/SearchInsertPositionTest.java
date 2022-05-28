package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInsertPositionTest {

    @Test
    @DisplayName("basic test")
    void basicTest() {
        int[] nums = {1};
        assertEquals(0, SearchInsertPosition.searchInsert(nums, 0));
        assertEquals(0, SearchInsertPosition.searchInsert(nums, 1));

        nums = new int[]{1, 3};
        assertEquals(0, SearchInsertPosition.searchInsert(nums, 0));
        assertEquals(0, SearchInsertPosition.searchInsert(nums, 1));
        assertEquals(1, SearchInsertPosition.searchInsert(nums, 3));
        assertEquals(2, SearchInsertPosition.searchInsert(nums, 4));

        nums = new int[]{1, 2, 3};
        assertEquals(0, SearchInsertPosition.searchInsert(nums, 0));
        assertEquals(0, SearchInsertPosition.searchInsert(nums, 1));
        assertEquals(1, SearchInsertPosition.searchInsert(nums, 2));
        assertEquals(2, SearchInsertPosition.searchInsert(nums, 3));
        assertEquals(3, SearchInsertPosition.searchInsert(nums, 4));

        nums = new int[]{1, 2, 3, 5, 7};
        assertEquals(0, SearchInsertPosition.searchInsert(nums, 0));
        assertEquals(2, SearchInsertPosition.searchInsert(nums, 3));
        assertEquals(3, SearchInsertPosition.searchInsert(nums, 4));
        assertEquals(3, SearchInsertPosition.searchInsert(nums, 5));
        assertEquals(4, SearchInsertPosition.searchInsert(nums, 6));
        assertEquals(4, SearchInsertPosition.searchInsert(nums, 7));
        assertEquals(5, SearchInsertPosition.searchInsert(nums, 8));

        nums = new int[]{-2, 0, 3, 5, 7};
        assertEquals(0, SearchInsertPosition.searchInsert(nums, -5));
        assertEquals(1, SearchInsertPosition.searchInsert(nums, 0));
        assertEquals(0, SearchInsertPosition.searchInsert(nums, -2));
        assertEquals(2, SearchInsertPosition.searchInsert(nums, 3));
        assertEquals(3, SearchInsertPosition.searchInsert(nums, 4));
        assertEquals(3, SearchInsertPosition.searchInsert(nums, 5));
        assertEquals(4, SearchInsertPosition.searchInsert(nums, 6));
    }
}