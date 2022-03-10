package common25;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicProgrammingProblemsTest {
    @Test
    @DisplayName("maximum single sell profit basic test")
    void maximumSingleSellProfitBasicTest() {
        int [] stockPrices = new int[]{8, 5, 12, 9, 19, 1};
        int [] buySellPrices = new int[]{5, 19};
        assertArrayEquals(buySellPrices, DynamicProgrammingProblems.maxSingleSellProfit(stockPrices));

        stockPrices = new int[]{8, 5, 4, 2, 1};
        buySellPrices = new int[]{2, 1};
        assertArrayEquals(buySellPrices, DynamicProgrammingProblems.maxSingleSellProfit(stockPrices));

        stockPrices = new int[]{1};
        buySellPrices = new int[]{0, 0};
        assertArrayEquals(buySellPrices, DynamicProgrammingProblems.maxSingleSellProfit(stockPrices));
    }

    @Test
    @DisplayName("maximum multiple buy sell profit basic test")
    void maximumMultipleBuySellProfitBasicTest() {
        int [] stockPrices = new int[]{8, 5, 12, 9, 19, 1};
        assertEquals(17, DynamicProgrammingProblems.maximumMultiSellProfit(stockPrices));

        stockPrices = new int[]{8, 5, 4, 2, 1};
        assertEquals(0, DynamicProgrammingProblems.maximumMultiSellProfit(stockPrices));

        stockPrices = new int[]{1};
        assertEquals(0, DynamicProgrammingProblems.maximumMultiSellProfit(stockPrices));
    }

    @Test
    @DisplayName("longest increasing subsequence basic test")
    void longestIncreasingSubsequenceBasicTest() {
        int [] stockPrices = new int[]{8, 5, 7, 9, 19, 1};
        assertEquals(4, DynamicProgrammingProblems.longestSubSequence(stockPrices));

        stockPrices = new int[]{8, 5, 4, 2, 1};
        assertEquals(0, DynamicProgrammingProblems.longestSubSequence(stockPrices));

        stockPrices = new int[]{1, 2, 3, 4, 5};
        assertEquals(stockPrices.length, DynamicProgrammingProblems.longestSubSequence(stockPrices));

        stockPrices = new int[]{1};
        assertEquals(0, DynamicProgrammingProblems.longestSubSequence(stockPrices));
    }

    @Test
    @DisplayName("longest increasing path in a matrix basic test")
    void longestIncreasingPathInAMatrixBasicTest() {
        int [][] mat = new int[][]{
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        assertEquals(4, DynamicProgrammingProblems.longestPath(mat));

        mat = new int[][]{
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}
        };
        assertEquals(4, DynamicProgrammingProblems.longestPath(mat));

        mat = new int[][]{
                {1, 6, 4},
                {9, 2, 7},
                {5, 8, 3}
        };
        assertEquals(2, DynamicProgrammingProblems.longestPath(mat));

        mat = new int[][]{
                {9, 8, 7},
                {4, 5, 6},
                {3, 2, 1}
        };
        assertEquals(9, DynamicProgrammingProblems.longestPath(mat));
    }
}