package hackerRankPractice;

import java.util.List;

/**
 * @author shuvo
 * @since 03/07/2021
 * https://www.hackerrank.com/challenges/magic-square-forming/problem
 * https://en.wikipedia.org/wiki/Magic_square
 */
// TODO: 03/07/2021 Magic Square algorithm. This is only limited to a 3x3.
public class FormingAMagicSquare {
    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */

    public static int formingMagicSquare(List<List<Integer>> s) {
        // Write your code here
        int n = s.size();
        int magicConstant = n * ((n*n + 1) / 2);

        int[][][] valid3x3Squares = {
            {{8,1,6}, {3,5,7}, {4,9,2}},
            {{6,1,8}, {7,5,3}, {2,9,4}},
            {{4,9,2}, {3,5,7}, {8,1,6}},
            {{2,9,4}, {7,5,3}, {6,1,8}},
            {{8,3,4}, {1,5,9}, {6,7,2}},
            {{4,3,8}, {9,5,1}, {2,7,6}},
            {{6,7,2}, {1,5,9}, {8,3,4}},
            {{2,7,6}, {9,5,1}, {4,3,8}}
        };

        int minCost = Integer.MAX_VALUE;
        for (int[][] msq : valid3x3Squares) {
            int cost = 0;
            for (int i = 0; i < msq.length; i++) {
                for (int j = 0; j < msq[i].length; j++) {
                    cost += Math.abs(msq[i][j] - s.get(i).get(j));
                }
            }
            if (cost < minCost) {
                minCost = cost;
            }
        }

        return minCost;
    }
}
