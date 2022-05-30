package leetcode.Algorithms;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 *
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in
 * non-decreasing order.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums is sorted in non-decreasing order.
 */
public class SquaresOfSortedArray {
    /**
     * Time - O(n ln(n))
     * Space - constant
     * @param nums
     * @return
     */
    public static int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) Math.pow(nums[i], 2);
        }
        Arrays.sort(nums);

        return nums;
    }

    /**
     * Time - O(n)
     * Space - O(n)
     * @param nums
     * @return
     */
    public static int[] sortedSquaresV2(int[] nums) {
        int i = 0, j = nums.length - 1;
        int s = j, a, b;
        int[] sqrd = new int[nums.length];

        while (i <= j) {
            a = Math.abs(nums[i]);
            b = Math.abs(nums[j]);

            if (a < b) {
                sqrd[s] = b*b;
                j--;
            } else {
                sqrd[s] = a*a;
                i++;
            }
            s--;
        }
        return sqrd;
    }
}
