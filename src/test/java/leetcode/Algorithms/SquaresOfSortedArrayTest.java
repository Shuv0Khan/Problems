package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquaresOfSortedArrayTest {
    @Test
    @DisplayName("basic test")
    void basicTest() {
        int[] nums = {-4,-1,0,3,10};
        int[] ret = {0,1,9,16,100};
        assertArrayEquals(ret, SquaresOfSortedArray.sortedSquares(nums));

        nums = new int[]{-4,-1,0,3,10};
        assertArrayEquals(ret, SquaresOfSortedArray.sortedSquaresV2(nums));
    }
}