package leetcode.Algorithms;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock
 *
 * You are given an array prices where prices[i] is the price of a
 * given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy
 * one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction.
 * If you cannot achieve any profit, return 0.
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6),
 * profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because
 * you must buy before you sell.
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 * Constraints:
 * 1 <= prices.length <= 10^5
 * 0 <= prices[i] <= 10^4
 */
public class BuySellStocks {

    /**
     * TLE
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int[] indices = new int[]{-1, -1};
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > profit) {
                    indices[0] = i;
                    indices[1] = j;
                    profit = prices[j] - prices[i];
                }
            }
        }

        return profit;
    }

    public static int maxProfit2(int[] prices) {
        int i = 0, j = 1, leftLowest = 0, profit = 0;
        for (; j + 1< prices.length;) {
            if (prices[i] > prices[j]) {
                i++;
                j++;
                continue;
            }
            if (prices[j + 1] > prices[j]) {
                j++;
                continue;
            }
            if (prices[leftLowest] > prices[i]) {
                leftLowest = i;
            }
            if (prices[j] - prices[leftLowest] > profit) {
                profit = prices[j] - prices[leftLowest];
            }
            i = j + 1;
            j = i + 1;
        }

        if (prices[leftLowest] > prices[i]) {
            leftLowest = i;
        }
        if (prices[prices.length - 1] - prices[leftLowest] > profit) {
            profit = prices[j] - prices[leftLowest];
        }

        return profit;
    }

    public static int maxProfit3(int [] prices) {
        int leastPrice = prices[0];
        int overallProfit = 0;
        int currentProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (leastPrice > prices[i]) {
                leastPrice = prices[i];
            }
            currentProfit = prices[i] - leastPrice;
            if (currentProfit > overallProfit) {
                overallProfit = currentProfit;
            }
        }

        return overallProfit;
    }
}
