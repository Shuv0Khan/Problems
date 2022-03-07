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
    }

    @Test
    @DisplayName("maximum multiple buy sell profit basic test")
    void maximumMultipleBuySellProfitBasicTest() {
        int [] stockPrices = new int[]{8, 5, 12, 9, 19, 1};
        assertEquals(17, DynamicProgrammingProblems.maximumMultiSellProfit(stockPrices));

        stockPrices = new int[]{8, 5, 4, 2, 1};
        assertEquals(0, DynamicProgrammingProblems.maximumMultiSellProfit(stockPrices));
    }
}