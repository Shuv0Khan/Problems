package gitTheAlgos.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class AmicableNumbersTest {
    @Test
    @DisplayName("test div sums")
    void testDivSums() {
        int start = 20;
        int end = 30;
        int [] divSums = AmicableNumbers.getAllDivSums(start, end);
        for (int i = 0; i < divSums.length; i++) {
            Assertions.assertEquals(AliquoteSum.sum(start + i), divSums[i]);
        }

        for (int l = 0; l < 10; l++) {
            Random random = new Random();
            start = random.nextInt(100);
            end = start + random.nextInt(100);
            System.out.println(start + ", " + end);
            divSums = AmicableNumbers.getAllDivSums(start, end);
            for (int i = 0; i < divSums.length; i++) {
                Assertions.assertEquals(AliquoteSum.sum(start + i), divSums[i]);
            }
        }
    }
    @Test
    @DisplayName("basic positive tests")
    void basicPositiveTests() {
        int start = 1;
        int end = 3000;
        ArrayList amicableNums = AmicableNumbers.findAllInRange(start, end);
        for (int i = 0; i < amicableNums.size(); i++) {
            int[] pair = (int[]) amicableNums.get(i);
            Assertions.assertEquals(AliquoteSum.sum(pair[0]), pair[1]);
            Assertions.assertEquals(AliquoteSum.sum(pair[1]), pair[0]);
            System.out.println(Arrays.toString(pair));
        }
    }
}