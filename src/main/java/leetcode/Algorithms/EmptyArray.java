package leetcode.Algorithms;

/**
 * https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/
 */
public class EmptyArray {
    public int minOperations(int[] nums) {
        int noOfOps = 0, n = 0;
        int [] counts = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) counts[nums[i]]++;
        for (int i = 1; i < counts.length; i++) {
            n = counts[i];
            if (n % 3 ==0) {
                noOfOps += n / 3;
                continue;
            }

            if (n % 2 == 0) {
                noOfOps += n / 2;
                continue;
            }

            noOfOps += n / 3;
            n %= 3;
            noOfOps += n / 2;
            n %= 2;

            if (n != 0) {
                return -1;
            }
        }
        return noOfOps;
    }
}
