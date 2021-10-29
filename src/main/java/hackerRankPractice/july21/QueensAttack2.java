package hackerRankPractice.july21;

import java.util.List;

/**
 * @author shuvo
 * @since 10/07/2021
 * https://www.hackerrank.com/challenges/queens-attack-2/problem
 */
public class QueensAttack2 {

    public static int[][] findCornerDistances(int x, int y, int n) {
        int[][] cornerDist = new int[3][3];

        cornerDist[0][0] = (Math.min(Math.abs(x - 1), Math.abs(y - n)));
        cornerDist[0][1] = Math.abs(y - n);
        cornerDist[0][2] = (Math.min(Math.abs(x - n), Math.abs(y - n)));
        cornerDist[1][0] = Math.abs(x - 1);
        cornerDist[1][2] = Math.abs(x - n);
        cornerDist[2][0] = (Math.min(Math.abs(x - 1), Math.abs(y - 1)));
        cornerDist[2][1] = Math.abs(y - 1);
        cornerDist[2][2] = (Math.min(Math.abs(x - n), Math.abs(y - 1)));

        /*int x1 = x - cornerDist[2][0];
        int y1 = y - cornerDist[2][0];
        System.out.println(x1 + ", " + y1);*/

        /*int x2 = x + cornerDist[2][2];
        int y2 = y - cornerDist[2][2];
        System.out.println(x2 + ", " + y2);*/

        /*int x3 = x + cornerDist[0][1];
        int y3 = y + cornerDist[0][1];
        System.out.println(x3 + ", " + y3);*/

        /*int x4 = x - cornerDist[0][0];
        int y4 = y + cornerDist[0][0];
        System.out.println(x4 + ", " + y4);*/

        return cornerDist;
    }
    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // Write your code here

        int [][] cornerDist = findCornerDistances(c_q, r_q, n);

        int x = c_q;
        int y = r_q;

        if (k > 0) {

            for (List<Integer> pair : obstacles) {
                int x1 = pair.get(1);
                int y1 = pair.get(0);

                if (x1 == x) {
                    int diff = Math.abs(y - y1) - 1;
                    if (y1 < y) {
                        cornerDist[2][1] = Math.min(cornerDist[2][1], diff);
                    } else if (y1 > y) {
                        cornerDist[0][1] = Math.min(cornerDist[0][1], diff);
                    }
                } else if (y1 == y) {
                    int diff = Math.abs(x - x1) - 1;
                    if (x1 < x) {
                        cornerDist[1][0] = Math.min(cornerDist[1][0], diff);
                    } else if (x1 > x) {
                        cornerDist[1][2] = Math.min(cornerDist[1][2], diff);
                    }
                } else if (Math.abs(x - x1) == Math.abs(y - y1)) {
                    // TODO: 10/07/2021 if anything needs to be deducted/added to x ~ y then do that outside abs()
                    int diff = Math.abs(x - x1) - 1;
                    if (x1 < x && y1 < y) {
                        cornerDist[2][0] = Math.min(cornerDist[2][0], diff);
                    } else if (x1 > x && y1 < y) {
                        cornerDist[2][2] = Math.min(cornerDist[2][2], diff);
                    } else if (x1 < x && y1 > y) {
                        cornerDist[0][0] = Math.min(cornerDist[0][0], diff);
                    } else if (x1 > x && y1 > y) {
                        cornerDist[0][2] = Math.min(cornerDist[0][2], diff);
                    }
                }

            }

        }

        int sum = 0;

        for (int[] row : cornerDist) {
            for (int dist : row) {
                sum += dist;
            }
        }

        return sum;
    }
}
