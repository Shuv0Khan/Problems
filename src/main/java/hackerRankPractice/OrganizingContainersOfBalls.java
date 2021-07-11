package hackerRankPractice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuvo
 * @since 11/07/2021
 * https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem
 */
public class OrganizingContainersOfBalls {
    // TODO: 11/07/2021 Matrix manipulation.

    /*
     * Complete the 'organizingContainers' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts 2D_INTEGER_ARRAY container as parameter.
     */

    public static String organizingContainers(List<List<Integer>> container) {
        // Write your code here
        int n = container.size();
        int[] containerBall = new int[n];
        for (int i = 0; i < n; i++) containerBall[i] = -1;

        for (int ball = 0; ball < n; ball++) {
            boolean accumulated = false;
            for (int cont = 0; cont < n; cont++) {
                if (containerBall[cont] > -1) {
                    continue;
                }
                int rowSum = 0;
                for (Integer b : container.get(cont)) {
                    rowSum += b;
                }
                int colSum = 0;
                for (int i = 0; i < n; i++) {
                    colSum += container.get(i).get(ball);
                }
                if (rowSum == colSum) {
                    containerBall[cont] = ball;
                    accumulated = true;
                    break;
                }
            }
            if (!accumulated) {
                return "Impossible";
            }
        }
        return "Possible";

    }

}
