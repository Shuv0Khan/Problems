package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinCostClimbingStairsTest {
    @Test
    @DisplayName("basic tests")
    void basicTests() {
        int [] costs = new int[]{10,15,20};
        assertEquals(15, MinCostClimbingStairs.minCostClimbingStairs(costs));
        assertEquals(15, MinCostClimbingStairs.leetcodeSolution(costs));

        costs = new int[]{1,100,1,1,1,100,1,1,100,1};
        assertEquals(6, MinCostClimbingStairs.minCostClimbingStairs(costs));
        assertEquals(6, MinCostClimbingStairs.leetcodeSolution(costs));
    }
}