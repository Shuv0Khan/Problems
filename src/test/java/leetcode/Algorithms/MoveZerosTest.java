package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveZerosTest {
    @Test
    @DisplayName("basic test")
    void basicTest() {
        int [] nums = new int[] {1,2,3,4,5};
        int [] result = new int[] {1,2,3,4,5};
        MoveZeros.moveZeroes(nums);
        assertArrayEquals(result, nums);

        nums = new int[] {0,1,2,3,4,5};
        result = new int[] {1,2,3,4,5,0};
        MoveZeros.moveZeroes(nums);
        assertArrayEquals(result, nums);

        nums = new int[] {0,1,2,0,3,4,0,5,0};
        result = new int[] {1,2,3,4,5,0,0,0,0};
        MoveZeros.moveZeroes(nums);
        assertArrayEquals(result, nums);

        nums = new int[] {0,0,0,1,2};
        result = new int[] {1,2,0,0,0};
        MoveZeros.moveZeroes(nums);
        assertArrayEquals(result, nums);

        nums = new int[] {1,2,3,0,0};
        result = new int[] {1,2,3,0,0};
        MoveZeros.moveZeroes(nums);
        assertArrayEquals(result, nums);
    }
    @Test
    @DisplayName("basic test swap")
    void basicTestSwap() {
        int [] nums = new int[] {1,2,3,4,5};
        int [] result = new int[] {1,2,3,4,5};
        MoveZeros.moveZeroesSwap(nums);
        assertArrayEquals(result, nums);

        nums = new int[] {0,1,2,3,4,5};
        result = new int[] {1,2,3,4,5,0};
        MoveZeros.moveZeroesSwap(nums);
        assertArrayEquals(result, nums);

        nums = new int[] {0,1,2,0,3,4,0,5,0};
        result = new int[] {1,2,3,4,5,0,0,0,0};
        MoveZeros.moveZeroesSwap(nums);
        assertArrayEquals(result, nums);

        nums = new int[] {0,0,0,1,2};
        result = new int[] {1,2,0,0,0};
        MoveZeros.moveZeroesSwap(nums);
        assertArrayEquals(result, nums);

        nums = new int[] {1,2,3,0,0};
        result = new int[] {1,2,3,0,0};
        MoveZeros.moveZeroesSwap(nums);
        assertArrayEquals(result, nums);
    }
}