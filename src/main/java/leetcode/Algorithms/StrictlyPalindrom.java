package leetcode.Algorithms;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/strictly-palindromic-number/
 *
 * An integer n is strictly palindromic if, for every base b between 2 and n - 2 (inclusive),
 * the string representation of the integer n in base b is palindromic.
 *
 * Given an integer n, return true if n is strictly palindromic and false otherwise.
 *
 * A string is palindromic if it reads the same forward and backward.
 *
 *
 *
 * Example 1:
 * Input: n = 9
 * Output: false
 * Explanation: In base 2: 9 = 1001 (base 2), which is palindromic.
 * In base 3: 9 = 100 (base 3), which is not palindromic.
 * Therefore, 9 is not strictly palindromic so we return false.
 * Note that in bases 4, 5, 6, and 7, n = 9 is also not palindromic.
 *
 * Example 2:
 * Input: n = 4
 * Output: false
 * Explanation: We only consider base 2: 4 = 100 (base 2), which is not palindromic.
 * Therefore, we return false.
 *
 * Constraints:
 * 4 <= n <= 10^5
 */
public class StrictlyPalindrom {
    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i < n - 1; i++) {
            ArrayList<Integer> nums = this.getBaseConversion(n, i);
            if (!this.isPalindrom(nums)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrom(ArrayList<Integer> nums) {
        int start = 0;
        int end = nums.size() - 1;
        while (start < end) {
            if (nums.get(start) != nums.get(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public ArrayList<Integer> getBaseConversion(int n, int base) {
        ArrayList<Integer> nums = new ArrayList<>();
        int div = n;
        while (div > 0) {
            nums.add(div%base);
            div = div/base;
        }
        return nums;
    }
}
