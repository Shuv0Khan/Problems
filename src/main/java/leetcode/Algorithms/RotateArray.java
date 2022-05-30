package leetcode.Algorithms;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/rotate-array/
 *
 * Given an array, rotate the array to the right
 * by k steps, where k is non-negative.
 *
 * 1 <= nums.length <= 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 * 0 <= k <= 10^5
 */
public class RotateArray {
    /**
     * Time - O(n)
     * Space - O(n)
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        int n = nums.length - 1, j;
        int[] rotated = new int[n + 1];
        k = k % n;

        for (int i = 0; i <= n; i++) {
            j = i + k;
            if (j > n) {
                j = j - n - 1;
            }
            rotated[j] = nums[i];
        }

        for (int i = 0; i <= n; i++) {
            nums[i] = rotated[i];
        }
    }

    /**
     * Time - O(n^2)
     * Space - O(1)
     * @param nums
     * @param k
     */
    public static void rotateV2(int[] nums, int k) {
        int n = nums.length;
        boolean rotateRight = true;
        k = k % n;

        if (k < n/2) {
            k = n - k;
            rotateRight = false;
        }

        for (int i = 0; i < k; i++) {
            if (rotateRight) {
                oneRightRotation(nums);
            } else {
                oneLeftRotation(nums);
            }
        }
    }

    private static void oneLeftRotation(int[] nums) {
        int n = nums[0];
        for (int i = nums.length - 1; i > -1; i--) {
            int temp = nums[i];
            nums[i] = n;
            n = temp;
        }
    }

    private static void oneRightRotation(int[] nums) {
        int n = nums[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            nums[i] = n;
            n = temp;
        }
    }

    /**
     * Juggling Algorithm
     */
    public static void rotateJugglingAlgo(int[] nums, int k) {
        /*
         * if k > nums.length
         **/
        int n = nums.length;
        k = k % n;
        int g = gcd(k, n);

        for (int i = 0; i < g; i++) {
            int inHand = nums[i];
            int j = i;
            while (true) {
                int index = (j + k) % n;
                int temp = nums[index];
                nums[index] = inHand;
                inHand = temp;
                j = index;
                if (index == i) {
                    break;
                }
            }
            System.out.println(i+": "+ Arrays.toString(nums));
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    /**
     * Reversal Algorithm
     */
    public static void rotateReversalAlgo(int []nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n-k);
        reverse(nums, n-k, n);
        reverse(nums, 0, n);
    }

    private static void reverse(int []nums, int start, int end) {
        int i = start, j = end - 1;
        while (i < j) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            i++;
            j--;
        }
    }
}
