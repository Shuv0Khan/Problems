package leetcode.Algorithms;

/**
 * https://leetcode.com/problems/search-insert-position/
 *
 * Given a sorted array of distinct integers and a target value,
 * return the index if the target is found. If not, return
 * the index where it would be if it were inserted in order.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums contains distinct values sorted in ascending order.
 * -10^4 <= target <= 10^4
 */
public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int index = 0;

        for (int start = 0, end = nums.length - 1; start <= end; ) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
                index = mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
                index = start;
            } else {
                return mid;
            }
        }

        return index;
    }
}
