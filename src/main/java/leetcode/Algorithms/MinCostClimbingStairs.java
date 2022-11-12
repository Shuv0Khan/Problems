package leetcode.Algorithms;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs
 *
 * You are given an integer array cost where cost[i] is the cost of
 * ith step on a staircase. Once you pay the cost, you can either
 * climb one or two steps.
 *
 * You can either start from the step with index 0, or the step with index 1.
 *
 * Return the minimum cost to reach the top of the floor.
 *
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: You will start at index 1.
 * - Pay 15 and climb two steps to reach the top.
 * The total cost is 15.
 *
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * Explanation: You will start at index 0.
 * - Pay 1 and climb two steps to reach index 2.
 * - Pay 1 and climb two steps to reach index 4.
 * - Pay 1 and climb two steps to reach index 6.
 * - Pay 1 and climb one step to reach index 7.
 * - Pay 1 and climb two steps to reach index 9.
 * - Pay 1 and climb one step to reach the top.
 * The total cost is 6.
 *
 * Constraints:
 *
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 */
public class MinCostClimbingStairs {
    /**
     *  min(minCostOfClimbing(cost, 0), minCostOfClimbing(cost, 1))
     *  reverse order/ descend stairs
     *  min(minCostOfClimbing(cost, n - 1), minCostOfClimbing(cost, n - 2))
     *  (cost, 2),              (cost, 1)
     *  (cost, 1), (cost, 0)=10    (cost, 0)=10, 0
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        return ascend(cost, -1, dp);
    }

    private static int ascend(int[] cost, int i, int[] dp) {
        if (i > 0 && i < dp.length && dp[i] != -1) {
            return dp[i];
        }
        if (i >= cost.length) {
            return 0;
        }

        if (i < 0) {
            return Math.min(ascend(cost, i + 1, dp), ascend(cost, i + 2, dp));
        } else {
            dp[i] = cost[i] + Math.min(ascend(cost, i + 1, dp), ascend(cost, i + 2, dp));
            return dp[i];
        }
    }

    /**
     * Bottom-up DP
     * @param cost
     * @return
     */
    public static int leetcodeSolution(int[] cost) {
        int [] dp = new int[cost.length + 2];

        for (int i = cost.length - 1; i >= 0; i--) {
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        }

        return Math.min(dp[0], dp[1]);
    }
}
