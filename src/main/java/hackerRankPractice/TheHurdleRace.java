package hackerRankPractice;

import java.util.List;

/**
 * @author shuvo
 * @since 06/07/2021
 * https://www.hackerrank.com/challenges/the-hurdle-race/problem
 */
public class TheHurdleRace {
    /*
     * Complete the 'hurdleRace' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY height
     */

    public static int hurdleRace(int k, List<Integer> height) {
        // Write your code here
        int max = 0;
        for (Integer h : height) {
            if (max < h) {
                max = h;
            }
        }

        max = max - k;
        if (max > 0) {
            return max;
        }
        return 0;
    }
}
