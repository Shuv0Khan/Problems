package common25;

import java.util.Arrays;
import java.util.HashMap;

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
 * problem 2:
 *      1. Integer.MIN_VALUE doesn't become positive even if we do Math.abs
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


    /**
     * <b>2. Determine if the sum of two integers is equal to a given value
     * <br>
     * Problem Statement:</b> Given an array of integers and a value,
     * determine if there are any two integers in the array whose sum
     * is equal to the given value.
     * Return true if the sum exists, and false if it does not.
     * @param nums array of integers
     * @param target the value that is equal to sum of any two ints of nums.
     * @return True if present, false otherwise.
     */
    public static boolean sumEqualToTargetBinSearch(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        Arrays.sort(nums); // may use counting sort for O(n+k) time and O(n) space.

        /*
         * shuvo - 2022-02-20, Sun, 11:8
         * Done to avoid finding num1 in nums if target = 2*num1
         * Done outside for loop to avoid if-else for each iteration.
         **/
        int num1 = nums[0];
        int num2 = target - num1;
        nums[0] = nums[1];
        if (Arrays.binarySearch(nums, num2) >= 0) {
            return true;
        }
        nums[0] = num1;

        for (int i = 1; i < nums.length; i++) {
            num1 = nums[i];
            num2 = target - nums[i];
            nums[i] = nums[i-1];
            if (Arrays.binarySearch(nums, num2) >= 0) {
                return true;
            }
            nums[i] = num1;
        }
        return false;
    }

    /**
     * Alternative 1: Using Two pivots at the two ends of the
     * sorted array instead of using binary search.
     * @param nums array of integers
     * @param target the value that is equal to sum of any two ints of nums.
     * @return True if present, false otherwise.
     */
    public static boolean sumEqualToTargetTwoPivots(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        Arrays.sort(nums);

        int start = 0;
        int end = nums.length - 1;

        for (;start<end;) {
            long sum = nums[start] + nums[end]; // long to avoid overflow/underflow
            if (sum == target) {
                return true;
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }

        return false;
    }

    /**
     * Alternative 3: Using Hashmap with O(n) time and O(n) space.
     *
     * @param nums array of integers
     * @param target the value that is equal to sum of any two ints of nums.
     * @return True if present, false otherwise.
     */
    public static boolean sumEqualToTargetHashMap(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int sub = target - num;
            if (map.get(sub) != null) {
                return true;
            } else {
                map.put(num, 1);
            }
        }

        return false;
    }

    /**
     * Alternative 4: Using reminders with O(n) time and O(n+target) space.
     *
     * @param nums array of integers
     * @param target the value that is equal to sum of any two ints of nums.
     * @return True if present, false otherwise.
     */
    public static boolean sumEqualToTargetReminder(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        target = Math.abs(target);
        int[] remCounts = new int[target];
        for (int num: nums) {
            num = Math.abs(num); // Integer.MIN_VALUE doesn't change even if we do absolute.
            if (num > 0 && num < target) {
                remCounts[num % target]++;
            }
        }

        for (int num1 = 1, l = (int) (Math.floor(target/2.0) + 1); num1 < l; num1++) {
            int num2 = target - num1;
            if (num1 == num2) {
                if (remCounts[num1] > 1) {
                    return true;
                }
            }else if (remCounts[num1] + remCounts[num2] > 1) {
                return true;
            }
        }

        return false;
    }

    /**
     * <b>3. Set columns and rows as zeroes
     * <br>
     * Problem Statement:</b> Given a two-dimensional array,
     * if any element within is zero, make its whole
     * row and column zero. Consider the matrix below.
     *
     * @param mat the 2d matrix
     * @return int[][] matrix with row+column set to zero
     */
    public static int[][] setToZero(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int isColZero = -1;

        for (int i = 0; i < row; i++) {
            if (mat[i][0] == 0) {
                isColZero = 0;
            }
            for (int j = 1; j < col; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }
        // first use mat[0][0] to set row to zero
        // if done after col set to zero, then it will cause the row to also be zero
        if (mat[0][0] == 0) {
            for (int j = 0; j < col; j++) {
                mat[0][j] = 0;
            }
        }

        if (isColZero == 0) {
            for (int i = 0; i < row; i++) {
                mat[i][0] = 0;
            }
        }

        return mat;
    }

}
