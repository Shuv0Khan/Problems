package leetcode.Algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/split-array-largest-sum/description/
 *
 * Given an integer array nums and an integer k, split nums into k
 * non-empty subarrays such that the largest sum of any subarray is minimized.
 *
 * Return the minimized largest sum of the split.
 *
 * A subarray is a contiguous part of the array.
 *
 * Example 1:
 *
 * Input: nums = [7,2,5,10,8], k = 2
 * Output: 18
 * Explanation: There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8], where the largest
 * sum among the two subarrays is only 18.
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,4,5], k = 2
 * Output: 9
 * Explanation: There are four ways to split nums into two subarrays.
 * The best way is to split it into [1,2,3] and [4,5], where the largest
 * sum among the two subarrays is only 9.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 106
 * 1 <= k <= min(50, nums.length)
 */
public class SplitArrayLargestSum {
    public class Split {
        public int sum = 0;
        public int start = -1;
        public int end = -1;
        public Split(int t, int s, int e) {
            this.sum = t;
            this.start = s;
            this.end = e;
        }
    }

    /**
     * this solution tries to find the splits by iteratively
     * splitting the array into sub-arrays prioritizing the
     * sub-array with highest sum first.
     *
     * this solution doesn't work in all cases.
     * @param nums
     * @param k
     * @return
     */
    public int splitArray(int[] nums, int k) {
        PriorityQueue<Split> subarrays = new PriorityQueue<>(new Comparator<Split>() {
            @Override
            public int compare(Split o1, Split o2) {
                if (o1.start == o1.end && o2.start == o2.end) {
                    return 0;
                } else if (o1.start == o1.end) {
                    return 1;
                } else if (o2.start == o2.end) {
                    return -1;
                }
                return o2.sum - o1.sum;
            }
        });
        int sum = 0;
        for (int i : nums) {
            sum+=i;
        }
        subarrays.add(new Split(sum, 0, nums.length-1));

        while (subarrays.size() != k) {
            splitSubarray(subarrays, nums);
        }

        for (Split s : subarrays) {
            sum = 0;
            for (int i = s.start; i <= s.end; i++) {
                sum += nums[i];
            }
            System.out.println("Sum: "+s.sum+", s: "+s.start+", e: "+s.end+", resum: "+sum);
        }

        int max = 0;
        for (Split s: subarrays) {
            max = Math.max(max, s.sum);
        }

        return max;

    }

    private void splitSubarray(PriorityQueue<Split> subarrays, int[] nums) {
        Split split = subarrays.poll();

        if (split.start == split.end) {
            subarrays.add(split);
            return;
        }

        int splitAt = split.start - 1;
        int minSum = split.sum;
        int sumLeft = 0;
        int sumRight = split.sum;

        for (int i = split.start; i <= split.end; i++) {
            splitAt++;
            sumLeft += nums[splitAt];
            sumRight -= nums[splitAt];
            int maxSplit = Math.max(sumLeft, sumRight);
            if (maxSplit < minSum) {
                minSum = maxSplit;
            } else {
                subarrays.add(new Split(sumLeft - nums[splitAt], split.start, splitAt - 1));
                subarrays.add(new Split(sumRight + nums[splitAt], splitAt, split.end));
                break;
            }
        }
    }

    /**
     * https://leetcode.com/problems/split-array-largest-sum/solutions/1904499/JAVA-or-0ms-100-or-Clean-Simplest-Solution-with-comments/
     *
     * This algorithm relies on binary search technique.
     * The answer to any test case will always lie between the max value element
     * of the given array (lower boundary of binary search) and sum of all array
     * elements (upper boundary of binary search) inclusive of the boundaries.
     * This is because:
     *
     * After splitting, any subarray will have atleast the max element of the array,
     * or more (in case of multiple elements in the subarray).
     * The answer can never go beyond the total sum of all the array elements.**
     * In the algorithm, we assume that mid is a possible answer, and we check
     * using binary search if it is possible to split the array into m subarrays
     * such that every subarray is less than the mid.
     *
     * If yes, then mid is a contender to the final answer. We store it, and further
     * reduce the high boundary below mid to check if it is possible to get a lower answer.
     * If no, then the lower boundary is increased above mid to get a higher
     * mid value in the next iteration.
     * @param nums
     * @param k
     * @return
     */
    public int splitArraySolution(int[] nums, int k) {
        int lowerBoundary = -1;
        int upperBoundary = 0;
        for(int i: nums) {
            lowerBoundary = Math.max(lowerBoundary, i);
            upperBoundary += i;
        }

        // binary search from lowerBoundary to upperBoundary for the sum
        // that can be used to split the array nums into k sub-arrays
        int maxSum = 0;
        while (lowerBoundary <= upperBoundary) {

            // to avoid overflow
            int targetSum = lowerBoundary + (upperBoundary - lowerBoundary) / 2;

            if (isSplitPossible(nums, targetSum, k)) {
                // target sum can be even lower
                maxSum = targetSum;
                upperBoundary = targetSum - 1;
            } else {
                // target sum too low causing more than k splits.
                lowerBoundary = targetSum + 1;
            }
        }
        return maxSum;
    }

    private boolean isSplitPossible(int[] nums, int targetSum, int k) {
        int sum = 0;
        int splits = 0;

        for (int i: nums) {
            sum += i;
            if (sum > targetSum) {
                splits++;
                sum = i;
            }
        }

        return ++splits <= k;
    }

}
