package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertArrayTest {

    @Test
    @DisplayName("basic test")
    void basicTest() {
        int[] nums = {3, 4, 5, 4, 6, 5, 1};
        System.out.println(new ConvertArray().findMatrix(nums));
    }

}