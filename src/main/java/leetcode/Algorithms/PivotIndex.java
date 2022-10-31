package leetcode.Algorithms;

/**
 * https://leetcode.com/problems/find-pivot-index/
 *
 * Given an array of integers nums, calculate the pivot index of this array.
 *
 * The pivot index is the index where the sum of all the numbers strictly to
 * the left of the index is equal to the sum of all the numbers strictly to the index's right.
 *
 * If the index is on the left edge of the array, then the left sum is 0 because
 * there are no elements to the left. This also applies to the right edge of the array.
 *
 * Return the leftmost pivot index. If no such index exists, return -1.
 *
 */
public class PivotIndex {
    /**
     * My Solution
     * @param nums
     * @return -1 or the pivot index
     */
    public static int findIndex (int[] nums) {
        int rightSum = 0;
        int leftSum = 0;
        for(int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }

        if (leftSum == rightSum) {
            return 0;
        }

        for (int i = 1; i < nums.length; i++) {
            leftSum += nums[i-1];
            rightSum -= nums[i];

            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }

    public static int leetcodeSolution(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            /*
             * shuvo - 2022-10-31, Mon, 19:3
             * rightSum = sum - leftsum - nums[i]
             **/
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}
