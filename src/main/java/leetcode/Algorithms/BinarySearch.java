package leetcode.Algorithms;

/**
 * https://leetcode.com/problems/binary-search/
 *
 * Given an array of integers nums which is sorted in ascending order,
 * and an integer target, write a function to search target in nums.
 * If target exists, then return its index. Otherwise, return -1.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 < nums[i], target < 104
 * All the integers in nums are unique.
 * nums is sorted in ascending order.
 */
public class BinarySearch {
    public static int search(int[] nums, int target) {
        for (int start = 0, end = nums.length - 1; start <= end; ) {

            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target){
                start = mid + 1;
            } else {
                return mid;
            }

        }

        return -1;
    }
}
