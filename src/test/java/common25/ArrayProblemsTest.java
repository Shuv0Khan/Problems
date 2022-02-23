package common25;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArrayProblemsTest {
    @Test
    @DisplayName("Find Missing Num basic tests")
    void findMissingNumBasicTests() {
        int[] nums = new int[]{2};

        assertEquals(1, ArrayProblems.findMissingNum(nums));
        assertEquals(1, ArrayProblems.findMissingNumXor(nums));

        nums = new int[]{1, 2, 5, 4};
        assertEquals(3, ArrayProblems.findMissingNum(nums));
        assertEquals(3, ArrayProblems.findMissingNumXor(nums));

        nums = new int[]{1, 2, 0, 4};
        assertEquals(3, ArrayProblems.findMissingNum(nums));
        assertEquals(3, ArrayProblems.findMissingNumXor(nums));

        nums = new int[]{1, 2, -3, 4};
        assertEquals(3, ArrayProblems.findMissingNum(nums));
        assertEquals(3, ArrayProblems.findMissingNumXor(nums));

        nums = new int[]{1, 2, 3, 4};
        assertEquals(0, ArrayProblems.findMissingNum(nums));
        assertEquals(0, ArrayProblems.findMissingNumXor(nums));
    }

    @Test
    @DisplayName("Find Duplicate Num Basic test")
    void findMissAndDupNumBasicTest() {
        int[] nums = new int[]{2};
        int[] ret = new int[2];
        assertArrayEquals(ret, ArrayProblems.findMissAndDupNum(nums));

        nums = new int[]{1, 1};
        ret = new int[]{2, 1};
        assertArrayEquals(ret, ArrayProblems.findMissAndDupNum(nums));

        nums = new int[]{1, 2, 3, 3, 5};
        ret = new int[]{4, 3};
        assertArrayEquals(ret, ArrayProblems.findMissAndDupNum(nums));

        nums = new int[]{1, 2, 3, 1};
        ret = new int[]{4, 1};
        assertArrayEquals(ret, ArrayProblems.findMissAndDupNum(nums));

        nums = new int[]{1, 2, 3, 4};
        ret = new int[]{0, 0};
        assertArrayEquals(ret, ArrayProblems.findMissAndDupNum(nums));
    }

    @Test
    @DisplayName("Find Missing Num Integer Limit test")
    void findMissingNumIntegerLimitTest() {
        /*

        // will require more than 4gb in vm memory for this test
        nums = new int[Integer.MAX_VALUE];
        nums[0] = -1;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            nums[i] = i+1;
        }
        assertEquals(1, ArrayProblems.findMissingNum(nums));
        */
    }

    @Test
    @DisplayName("Sum of two Equal to given basic test")
    void sumOfTwoEqualToGivenBasicTest() {
        assertFalse(ArrayProblems.sumEqualToTargetBinSearch(new int[]{2}, 3));
        assertFalse(ArrayProblems.sumEqualToTargetBinSearch(new int[]{-1, 2}, 3));
        assertFalse(ArrayProblems.sumEqualToTargetBinSearch(new int[]{-1, 0}, 3));
        assertFalse(ArrayProblems.sumEqualToTargetBinSearch(new int[]{1, Integer.MAX_VALUE}, 3));
        assertFalse(ArrayProblems.sumEqualToTargetBinSearch(new int[]{-1, Integer.MIN_VALUE}, 3));
        assertFalse(ArrayProblems.sumEqualToTargetBinSearch(new int[]{2, 3}, 4));
        assertTrue(ArrayProblems.sumEqualToTargetBinSearch(new int[]{-1, 2}, 1));
        assertTrue(ArrayProblems.sumEqualToTargetBinSearch(new int[]{1, 2}, 3));
        assertTrue(ArrayProblems.sumEqualToTargetBinSearch(new int[]{-1, -2}, -3));
        assertTrue(ArrayProblems.sumEqualToTargetBinSearch(new int[]{1, 2, -1, 4, 0, 3}, 3));
        assertTrue(ArrayProblems.sumEqualToTargetBinSearch(new int[]{1, 2, 1, 4, 0, -2}, 2));


        assertFalse(ArrayProblems.sumEqualToTargetTwoPivots(new int[]{2}, 3));
        assertFalse(ArrayProblems.sumEqualToTargetTwoPivots(new int[]{-1, 2}, 3));
        assertFalse(ArrayProblems.sumEqualToTargetTwoPivots(new int[]{-1, 0}, 3));
        assertFalse(ArrayProblems.sumEqualToTargetTwoPivots(new int[]{1, Integer.MAX_VALUE}, 3));
        assertFalse(ArrayProblems.sumEqualToTargetTwoPivots(new int[]{-1, Integer.MIN_VALUE}, 3));
        assertFalse(ArrayProblems.sumEqualToTargetTwoPivots(new int[]{2, 3}, 4));
        assertTrue(ArrayProblems.sumEqualToTargetTwoPivots(new int[]{-1, 2}, 1));
        assertTrue(ArrayProblems.sumEqualToTargetTwoPivots(new int[]{1, 2}, 3));
        assertTrue(ArrayProblems.sumEqualToTargetTwoPivots(new int[]{-1, -2}, -3));
        assertTrue(ArrayProblems.sumEqualToTargetTwoPivots(new int[]{1, 2, -1, 4, 0, 3}, 3));
        assertTrue(ArrayProblems.sumEqualToTargetTwoPivots(new int[]{1, 2, 1, 4, 0, -2}, 2));


        assertFalse(ArrayProblems.sumEqualToTargetHashMap(new int[]{2}, 3));
        assertFalse(ArrayProblems.sumEqualToTargetHashMap(new int[]{-1, 2}, 3));
        assertFalse(ArrayProblems.sumEqualToTargetHashMap(new int[]{-1, 0}, 3));
        assertFalse(ArrayProblems.sumEqualToTargetHashMap(new int[]{1, Integer.MAX_VALUE}, 3));
        assertFalse(ArrayProblems.sumEqualToTargetHashMap(new int[]{-1, Integer.MIN_VALUE}, 3));
        assertFalse(ArrayProblems.sumEqualToTargetHashMap(new int[]{2, 3}, 4));
        assertTrue(ArrayProblems.sumEqualToTargetHashMap(new int[]{-1, 2}, 1));
        assertTrue(ArrayProblems.sumEqualToTargetHashMap(new int[]{1, 2}, 3));
        assertTrue(ArrayProblems.sumEqualToTargetHashMap(new int[]{-1, -2}, -3));
        assertTrue(ArrayProblems.sumEqualToTargetHashMap(new int[]{1, 2, -1, 4, 0, 3}, 3));
        assertTrue(ArrayProblems.sumEqualToTargetHashMap(new int[]{1, 2, 1, 4, 0, -2}, 2));


        assertFalse(ArrayProblems.sumEqualToTargetReminder(new int[]{2}, 3));
//        assertFalse(ArrayProblems.sumEqualToTargetReminder(new int[]{-1, 2}, 3));
//        assertFalse(ArrayProblems.sumEqualToTargetReminder(new int[]{-1, 0}, 3));
        assertFalse(ArrayProblems.sumEqualToTargetReminder(new int[]{1, Integer.MAX_VALUE}, 3));
        assertFalse(ArrayProblems.sumEqualToTargetReminder(new int[]{-1, Integer.MIN_VALUE}, 3));
        assertFalse(ArrayProblems.sumEqualToTargetReminder(new int[]{2, 3}, 4));
//        assertTrue(ArrayProblems.sumEqualToTargetReminder(new int[]{-1, 2}, 1));
        assertTrue(ArrayProblems.sumEqualToTargetReminder(new int[]{1, 2}, 3));
        assertTrue(ArrayProblems.sumEqualToTargetReminder(new int[]{-1, -2}, -3));
        assertTrue(ArrayProblems.sumEqualToTargetReminder(new int[]{1, 2, 0, 3}, 3));
        assertTrue(ArrayProblems.sumEqualToTargetReminder(new int[]{1, 2, 1, 4}, 2));
    }


    @Test
    @DisplayName("set matrix row col to zero basic test")
    void setMatrixRowColToZeroBasicTest() {
        int[][] mat = new int[][]{{1,2}, {2,3}, {1,0}};
        int[][] retMat = new int[][]{{1,0}, {2,0}, {0,0}};
        assertTrue(Arrays.deepEquals(retMat, ArrayProblems.setToZero(mat)));

        mat = new int[][]{{1, 2, 3}, {2, 0, 3}, {0, 1, 2}};
        retMat = new int[][]{{0, 0, 3}, {0, 0, 0}, {0, 0, 0}};
        assertTrue(Arrays.deepEquals(retMat, ArrayProblems.setToZero(mat)));
    }
}