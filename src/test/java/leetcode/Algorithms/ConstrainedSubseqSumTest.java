package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ConstrainedSubseqSumTest {
    @Test
    @DisplayName("basic test")
    void basicTest() {
        assertEquals(37, new ConstrainedSubseqSum().constrainedSubsetSum(new int[]{10,2,-10,5,20}, 2));
        assertEquals(-1, new ConstrainedSubseqSum().constrainedSubsetSum(new int[]{-1, -2, -3}, 1));
        assertEquals(23, new ConstrainedSubseqSum().constrainedSubsetSum(new int[]{10,-2,-10,-5,20}, 2));
    }

    @Test
    @DisplayName("edge cases")
    void edgeCases() {
        assertEquals(1, new ConstrainedSubseqSum().constrainedSubsetSum(new int[]{1}, 2));
        assertEquals(1, new ConstrainedSubseqSum().constrainedSubsetSum(new int[]{1, -1, -2, -3, -4, 1}, 1));
        assertEquals(3, new ConstrainedSubseqSum().constrainedSubsetSum(new int[]{-1, -2, -3, 1, 2, -4, -1}, 1));
        assertEquals(4, new ConstrainedSubseqSum().constrainedSubsetSum(new int[]{-1, -2, -3, 1, 2, -2, 3, -3, -4}, 1));
        assertEquals(8, new ConstrainedSubseqSum().constrainedSubsetSum(new int[]{-1, -2, -3, 1, 2, -4, 5, -3, -4}, 2));
        assertEquals(2, new ConstrainedSubseqSum().constrainedSubsetSum(new int[]{1, -1, -2, -3, -4, 1}, 5));
        assertEquals(7, new ConstrainedSubseqSum().constrainedSubsetSum(new int[]{6, 1, -1, -2, -3, -4, 1}, 2));
        assertEquals(12, new ConstrainedSubseqSum().constrainedSubsetSum(new int[]{10, -2, -1, 3}, 2));
        assertEquals(16091, new ConstrainedSubseqSum().constrainedSubsetSum(new int[]{-8269,3217,-4023,-4138,-683,6455,-3621,9242,4015,-3790}, 1));
        assertEquals(78, new ConstrainedSubseqSum().constrainedSubsetSum(new int[]{10,10,10,10,-10,-1,-10,-1,-10,10,10,10,10}, 3));
    }
}