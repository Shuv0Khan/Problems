package common25;

import java.util.Arrays;

/**
 * Source - https://www.educative.io/blog/microsoft-interview-coding-questions
 *
 * Learnings -
 * problem 1:
 *      1. Think more about the corner cases. almost missed the fact that
 *      the problem definition doesn't say if the placeholder for missing
 *      value can be any integer (+/-).
 *      2. Double-check the if conditions. Also, it's better to do a hand
 *      simulation before running the code.
 *      3. No condition on the length of the array. So we can assume that
 *      it will be to the limit of Integers. So the multiplication will
 *      overflow int boundary. Sum will also overflow.
 *      4. Make sure to check the negative cases, like what will happen
 *      if the input doesn't have any missing value? or if no duplicates?
 *
 */
public class ArrayProblems {
    /**
     * <b>1. Find the missing number in a given array.
     * <br>
     * Problem Statement:</b> Given an array of positive numbers
     * ranging from 1 to n, such that all numbers from 1 to n
     * are present except one number x, find x.
     * Assume the input array is unsorted.
     *
     * @param nums array of positive integers from 1 to n.
     * @return int - the missing number
     */
    public static int findMissingNum(int[] nums) {
        long seriesSum = nums.length;
        seriesSum = seriesSum * (seriesSum + 1) / 2;
        for(int num : nums){
            if (num > 0 && num <= nums.length) {
                seriesSum -= num;
            }
        }
        return (int) seriesSum;
    }

    /**
     * Improvement on the above algorithm with xor.
     *
     * @param nums
     * @return
     */
    public static int findMissingNumXor(int[] nums) {
        long xor = 0;
        for (int i = 0; i < nums.length; i++) {
            if (0 < nums[i] && nums[i] <= nums.length) {
                xor ^= nums[i];
            }
            xor ^= (i + 1);
        }

        return (int) xor;
    }

    /**
     * Variation of the above problem where the
     * missing number is due to a duplication of any number in
     * the range 1 - n.
     *
     * @param nums
     * @return
     */
    public static int[] findMissAndDupNum(int[] nums) {
        if (nums.length < 2) {
            return new int[]{0, 0};
        }
        int[] ret = new int[2];
        long sum = nums[0];
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                ret[1] = i; // duplicate number
            }
            sum += nums[i];
        }

        long seriesSum = nums.length;
        seriesSum = seriesSum * (seriesSum + 1) / 2;

        ret[0] = (int) (seriesSum - sum + ret[1]); //missing number

        return ret;
    }

}
