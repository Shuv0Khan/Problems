package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumIITest {
    @Test
    @DisplayName("basic test")
    void basicTest() {
        int [] numbers = new int[] {2,7,11,15};
        int target = 9;
        int [] indices = new int[] {1, 2};
        assertArrayEquals(indices, TwoSumII.twoSum(numbers, target));

        numbers = new int[] {-1,7,1,15};
        target = 0;
        indices = new int[] {1, 3};
        assertArrayEquals(indices, TwoSumII.twoSum(numbers, target));
    }

    @Test
    @DisplayName("basic test extra jump")
    void basicTestExtraJump() {
        int [] numbers = new int[] {2,7,11,15};
        int target = 9;
        int [] indices = new int[] {1, 2};
        assertArrayEquals(indices, TwoSumII.twoSum(numbers, target));

        numbers = new int[] {-1,7,1,15};
        target = 0;
        indices = new int[] {1, 3};
        assertArrayEquals(indices, TwoSumII.twoSum(numbers, target));
    }
}