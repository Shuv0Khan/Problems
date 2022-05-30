package leetcode.Algorithms;

/**
 * https://leetcode.com/problems/move-zeroes/
 *
 * Given an integer array nums, move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 */
public class MoveZeros {
    /**
     * 2 pivot no swaps/bubbling of zero
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int zeroCount = 0;
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                zeroCount++;
            } else {
                nums[i++] = nums[j];
            }
        }
        for (int i = 0, j = nums.length - 1; i < zeroCount; i++, j--) {
            nums[j] = 0;
        }
    }

    /**
     * 2 pivot with swap
     * @param nums
     */
    public static void moveZeroesSwap(int[] nums) {
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                continue;
            }
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i++] = temp;
        }
    }
}
