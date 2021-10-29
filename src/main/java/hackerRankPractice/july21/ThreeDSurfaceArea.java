package hackerRankPractice.july21;

import java.util.List;

/**
 * @author shuvo
 * @since 16/07/2021
 * https://www.hackerrank.com/challenges/3d-surface-area/problem
 */
public class ThreeDSurfaceArea {
    /*
     * Complete the 'surfaceArea' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY A as parameter.
     */

    public static int surfaceArea(List<List<Integer>> A) {
        // Write your code here
        int result = 0;
        for (int i = 0, row = A.size(); i < row; i++) {
            for (int j = 0, col = A.get(0).size(); j < col; j++) {
                result += A.get(i).get(j) * 4 + 2;

                if (j < col - 1) {
                    result -= Math.min(A.get(i).get(j), A.get(i).get(j+1)) * 2;
                }

                if (i < row - 1) {
                    result -= Math.min(A.get(i).get(j), A.get(i+1).get(j)) * 2;
                }
            }
        }
        return result;
    }
}
