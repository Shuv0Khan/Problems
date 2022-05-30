package leetcode.Algorithms;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * Given a 1-indexed array of integers numbers that is already sorted
 * in non-decreasing order, find two numbers such that they add up to
 * a specific target number. Let these two numbers be numbers[index1]
 * and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 *
 * Return the indices of the two numbers, index1 and index2, added by
 * one as an integer array [index1, index2] of length 2.
 *
 * The tests are generated such that there is exactly one solution.
 * You may not use the same element twice.
 *
 * Your solution must use only constant extra space.
 *
 * Constraints:
 *
 * 2 <= numbers.length <= 3 * 10^4
 * -1000 <= numbers[i] <= 1000
 * numbers is sorted in non-decreasing order.
 * -1000 <= target <= 1000
 * The tests are generated such that there is exactly one solution.
 */
public class TwoSumII {
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                break;
            }
        }
        return new int[] {i+1, j+1};
    }

    /**
     * Adds a larger jump for the pivots
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSumExtraJump(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            int mid = i + (j - i) / 2;
            if (sum > target) {
                if (numbers[i] + numbers[mid] > target) {
                    j = mid - 1;
                } else {
                    j--;
                }
            } else if (sum < target) {
                if (numbers[mid] + numbers[j] < target) {
                    i = mid + 1;
                } else {
                    i++;
                }
            } else {
                break;
            }
        }
        return new int[] {i+1, j+1};
    }
}
