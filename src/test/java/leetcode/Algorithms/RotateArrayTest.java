package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotateArrayTest {
    @Test
    @DisplayName("basic test")
    void basicTest() {
        int[] nums = {1,2,3,4,5,6,7};
        int[] rotated = {5,6,7,1,2,3,4};
        RotateArray.rotate(nums, 3);
        assertArrayEquals(rotated, nums);

        nums = new int[] {1,2,3,4,5,6,7};
        rotated = new int[] {3,4,5,6,7,1,2};
        RotateArray.rotateV2(nums, 5);
        assertArrayEquals(rotated, nums);

        nums = new int[] {1,2,3,4,5,6,7,8,9,10};
        rotated = new int[] {7,8,9,10,1,2,3,4,5,6};
        RotateArray.rotateJugglingAlgo(nums, 4);
        assertArrayEquals(rotated, nums);

        nums = new int[] {1,2,3,4,5,6,7,8,9,10};
        rotated = new int[] {7,8,9,10,1,2,3,4,5,6};
        RotateArray.rotateReversalAlgo(nums, 4);
        assertArrayEquals(rotated, nums);
    }
}