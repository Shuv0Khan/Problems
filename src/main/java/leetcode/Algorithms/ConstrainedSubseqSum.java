package leetcode.Algorithms;

public class ConstrainedSubseqSum {
    public int constrainedSubsetSum(int[] nums, int k) {
        int start = 0;
        int sum = Integer.MIN_VALUE;
        //skip leading -ve nums
        for (; start < nums.length; start++) {
            if (nums[start] >= 0) {
                break;
            }
            if (nums[start] > sum) {
                sum = nums[start];
            }
            // setting leading -ves as 0
            nums[start] = 0;
        }
        // no positive nums found, smallest -ve num is the max sum
        if (start == nums.length) {
            return sum;
        }

        int [] negSums = new int[k];

        for (int i = start + 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                // find the end of the sequence of -ve nums while summing those up
                start = i - 1;
                for (; i < nums.length && nums[i] < 0; i++) {
                    negSums[i % k] += nums[i];
                    nums[i] = 0;
                }
                // if we are working with trailing -ves
                if (i == nums.length) {
                    break;
                } else if (i - start <= k) {
                    // skip this subarray of -ve nums
                    continue;
                }
                // find the max sum and reset the array
                int max = Integer.MIN_VALUE;
                for (int j = 0; j < k; j++) {
                    if (negSums[j] != 0 && negSums[j] > max) {
                        max = negSums[j];
                    }
                    negSums[j] = 0;
                }
                // cost of crossing the -ve subarray
                nums[i - 1] = max;
                continue;
            }

            nums[i] += nums[i - 1];
            nums[i - 1] = 0;
        }

        // does including the -ve subarray increase the sum?

        //skip to first positive sum of subarray
        for(start = 0; start < nums.length && nums[start] < 1; start++);

        for (int i = start; i < nums.length; i++) {
            if (nums[i] <= 0) {
                start = i - 1;
                int min = 0;
                for (; i < nums.length && nums[i] <= 0; i++){
                    if (nums[i] < min) {
                        min = nums[i];
                    }
                }
                if (i == nums.length) {
                    // last -ve subarray
                    break;
                }
                // if including the -ve subarray generates greater sum then include it
                if (nums[start] + min + nums[i] > Math.max(nums[start], nums[i])) {
                    nums[i] = nums[start] + min + nums[i];
                }
            }
        }

        sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > sum) {
                sum = nums[i];
            }
        }
        return sum;
    }
}
