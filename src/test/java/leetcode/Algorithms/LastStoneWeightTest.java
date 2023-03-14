package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LastStoneWeightTest {
    @Test
    @DisplayName("basic test")
    void basicTest() {
        LastStoneWeight obj = new LastStoneWeight();

        int[] stones = new int[]{2,7,4,1,8,1};
        assertEquals(1, obj.lastStoneWeight(stones));

        stones = new int[]{1};
        assertEquals(1, obj.lastStoneWeight(stones));

        stones = new int[]{1, 1};
        assertEquals(0, obj.lastStoneWeight(stones));
    }
}