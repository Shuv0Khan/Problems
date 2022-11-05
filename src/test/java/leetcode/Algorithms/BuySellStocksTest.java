package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuySellStocksTest {
    @Test
    @DisplayName("base cases")
    void baseCases() {
        int[] prices = new int[]{7,1,5,3,6,4};
        assertEquals(5, BuySellStocks.maxProfit(prices));

        prices = new int[]{7,6,4,3,1};
        assertEquals(0, BuySellStocks.maxProfit(prices));

        prices = new int[]{1, 3, 4, 6, 7};
        assertEquals(6, BuySellStocks.maxProfit(prices));

        prices = new int[] {36, 43, 51, 112, 9, 17};
        assertEquals(76, BuySellStocks.maxProfit(prices));

        prices = new int[] {8, 9, 10, 7, 6, 10, 1, 3, 4, 10};
        assertEquals(9, BuySellStocks.maxProfit(prices));
    }

    @Test
    @DisplayName("basic test sol 2")
    void basicTestSol2() {
        int[] prices = new int[]{7,1,5,3,6,4};
        assertEquals(5, BuySellStocks.maxProfit2(prices));

        prices = new int[]{7,6,4,3,1};
        assertEquals(0, BuySellStocks.maxProfit2(prices));

        prices = new int[]{1, 3, 4, 6, 7};
        assertEquals(6, BuySellStocks.maxProfit2(prices));

        prices = new int[] {36, 43, 51, 112, 9, 17};
        assertEquals(76, BuySellStocks.maxProfit2(prices));

        prices = new int[] {8, 9, 10, 7, 6, 10, 1, 3, 4, 10};
        assertEquals(9, BuySellStocks.maxProfit2(prices));
    }

    @Test
    @DisplayName("basic test sol 3")
    void basicTestSol3() {
        int[] prices = new int[]{7,1,5,3,6,4};
        assertEquals(5, BuySellStocks.maxProfit3(prices));

        prices = new int[]{7,6,4,3,1};
        assertEquals(0, BuySellStocks.maxProfit3(prices));

        prices = new int[]{1, 3, 4, 6, 7};
        assertEquals(6, BuySellStocks.maxProfit3(prices));

        prices = new int[] {36, 43, 51, 112, 9, 17};
        assertEquals(76, BuySellStocks.maxProfit3(prices));

        prices = new int[] {8, 9, 10, 7, 6, 10, 1, 3, 4, 10};
        assertEquals(9, BuySellStocks.maxProfit3(prices));
    }
}