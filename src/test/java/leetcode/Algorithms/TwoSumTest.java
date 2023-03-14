package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {
    @Test
    @DisplayName("basic tests")
    void basicTests() {
        TwoSum obj = new TwoSum();

        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        assertArrayEquals(new int[]{0,1}, obj.twoSum(nums, target));

        nums = new int[]{3,2,4};
        target = 6;
        assertArrayEquals(new int[]{1,2}, obj.twoSum(nums, target));

        nums = new int[]{3,3};
        target = 6;
        assertArrayEquals(new int[]{0,1}, obj.twoSum(nums, target));
    }
}