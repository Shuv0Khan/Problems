package hackerRankPractice.july21;

import hackerRankPractice.july21.FormingAMagicSquare;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FormingAMagicSquareTest {
    int [][][] zeroCases = {
        {{8,1,6}, {3,5,7}, {4,9,2}},
        {{6,1,8}, {7,5,3}, {2,9,4}},
        {{4,9,2}, {3,5,7}, {8,1,6}},
        {{2,9,4}, {7,5,3}, {6,1,8}},
        {{8,3,4}, {1,5,9}, {6,7,2}},
        {{4,3,8}, {9,5,1}, {2,7,6}},
        {{6,7,2}, {1,5,9}, {8,3,4}},
        {{2,7,6}, {9,5,1}, {4,3,8}}
    };
    int [][][] cases = {
        {{1,2,3}, {4,5,6}, {7,8,9}},
        {{1,1,1}, {2,2,2}, {3,3,3}}
    };
    int[] costs = {24, 29};

    @Test
    @DisplayName("Test for zero cases")
    void testForZeroCases() {
        int n = 3;
        List<List<Integer>> square = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            square.add(row);
        }
        for (int [][] msq : zeroCases) {
            for (int i = 0; i < msq.length; i++) {
                for (int j = 0; j < msq[i].length; j++) {
                    square.get(i).set(j, msq[i][j]);
                }
            }
            Assertions.assertEquals(0, FormingAMagicSquare.formingMagicSquare(square));
        }
    }
    @Test
    @DisplayName("Test for all cases")
    void testForAllCases() {
        int n = 3;
        List<List<Integer>> square = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            square.add(row);
        }

        for (int test = 0; test < cases.length; test++) {
            int [][] msq = cases[test];
            for (int i = 0; i < msq.length; i++) {
                for (int j = 0; j < msq[i].length; j++) {
                    square.get(i).set(j, msq[i][j]);
                }
            }
            Assertions.assertEquals(costs[test], FormingAMagicSquare.formingMagicSquare(square));
        }
    }
}
