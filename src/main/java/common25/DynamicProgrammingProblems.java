package common25;

/**
 * Source - https://www.educative.io/blog/microsoft-interview-coding-questions
 *
 * Learnings -
 *      problem
 */
public class DynamicProgrammingProblems {
    /**
     * <b>12. Find the maximum single sell profit
     * <br>
     * Problem Statement:</b> Given a list of daily stock prices (integers for simplicity),
     * return the buy and sell prices that will maximize the single buy/sell profit.
     * If you can’t make any profit, try to minimize the loss.
     *
     * @param stockPrices list of stock prices chronologically
     * @return array of buy and sell prices for maximum profit/ minimum loss
     */
    public static int[] maxSingleSellProfit(int[] stockPrices) {
        int maxProfit = Integer.MIN_VALUE;
        int minPriceAt = 0;
        int buy = 0, sell = 0;
        for (int i = 1; i < stockPrices.length; i++) {
            int price = stockPrices[i];
            if (price - stockPrices[minPriceAt] >= maxProfit) {
                maxProfit = price - stockPrices[minPriceAt];
                buy = minPriceAt;
                sell = i;
            }
            if (price < stockPrices[minPriceAt]) {
                minPriceAt = i;
            }
        }
        return new int[]{stockPrices[buy], stockPrices[sell]};
    }

    /**
     * <b>Alternative:</b>
     * <br>
     * Maximum Multiple Buy-sell profit.
     * <br>
     * if minimum loss condition is also required, we can use
     * the above algorithm and keep track of minimum loss when
     * no profit can be made.
     * @param stockPrices list of stock prices chronologically
     * @return maximum multiple buy-sell profit, 0 if no profit can be made
     */
    public static int maximumMultiSellProfit(int [] stockPrices) {
        int profit = 0;
        for (int i = 1; i < stockPrices.length; i++) {
            if (stockPrices[i] > stockPrices[i - 1]) {
                profit += stockPrices[i] - stockPrices[i - 1];
            }
        }
        return profit;
    }
}
