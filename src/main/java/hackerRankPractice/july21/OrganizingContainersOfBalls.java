package hackerRankPractice.july21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        int[] ballCount = new int[n];
        int[] capacityCount = new int[n];

        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                int m = container.get(row).get(col);
                ballCount[col] += m;
                capacityCount[row] += m;
            }
        }

        Arrays.sort(ballCount);
        Arrays.sort(capacityCount);

        for (int i = 0; i < n; i++) {
            if (ballCount[i] != capacityCount[i]) {
                return "Impossible";
            }
        }

        return "Possible";

    }

}
