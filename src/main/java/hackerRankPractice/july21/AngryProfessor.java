package hackerRankPractice.july21;

import java.util.List;

/**
 * @author shuvo
 * @since 19/07/2021
 * https://www.hackerrank.com/challenges/angry-professor/problem
 */
public class AngryProfessor {
    /*
     * Complete the 'angryProfessor' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY a
     */

    public static String angryProfessor(int k, List<Integer> a) {
        // Write your code here
        int presentCount = 0;
        for (Integer time : a) {
            if (time <= 0) {
                presentCount++;
            }
        }
        if (presentCount < k) {
            return "YES";
        }
        return "NO";
    }
}
