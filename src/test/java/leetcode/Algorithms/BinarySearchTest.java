package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    @Test
    @DisplayName("basic test")
    void basicTest() {
        int[] nums = {1};
        assertEquals(-1, BinarySearch.search(nums, 0));
        assertEquals(0, BinarySearch.search(nums, 1));

        nums = new int[]{1, 3};
        assertEquals(-1, BinarySearch.search(nums, 0));
        assertEquals(0, BinarySearch.search(nums, 1));
        assertEquals(1, BinarySearch.search(nums, 3));
        assertEquals(-1, BinarySearch.search(nums, 4));

        nums = new int[]{1, 2, 3};
        assertEquals(-1, BinarySearch.search(nums, 0));
        assertEquals(0, BinarySearch.search(nums, 1));
        assertEquals(1, BinarySearch.search(nums, 2));
        assertEquals(2, BinarySearch.search(nums, 3));
        assertEquals(-1, BinarySearch.search(nums, 4));

        nums = new int[]{1, 2, 3, 5, 7};
        assertEquals(-1, BinarySearch.search(nums, 0));
        assertEquals(2, BinarySearch.search(nums, 3));
        assertEquals(-1, BinarySearch.search(nums, 4));
        assertEquals(3, BinarySearch.search(nums, 5));
        assertEquals(-1, BinarySearch.search(nums, 6));

        nums = new int[]{-2, 0, 3, 5, 7};
        assertEquals(-1, BinarySearch.search(nums, -5));
        assertEquals(1, BinarySearch.search(nums, 0));
        assertEquals(0, BinarySearch.search(nums, -2));
        assertEquals(2, BinarySearch.search(nums, 3));
        assertEquals(-1, BinarySearch.search(nums, 4));
        assertEquals(3, BinarySearch.search(nums, 5));
        assertEquals(-1, BinarySearch.search(nums, 6));
    }



}