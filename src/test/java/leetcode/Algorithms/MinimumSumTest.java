package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumSumTest {
    @Test
    @DisplayName("basic test")
    void basicTest() {
        MinimumSum ms = new MinimumSum();
        assertEquals(63 ,ms.minimumSum(3294));
        assertEquals(126 ,ms.minimumSum(5688));
        assertEquals(86 ,ms.minimumSum(8780));
        assertEquals(2 ,ms.minimumSum(2000));
        assertEquals(198 ,ms.minimumSum(9999));
    }
}