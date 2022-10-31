package hackerRankPractice.july21;

import java.util.List;

/**
 * @author shuvo
 * @since 04/07/2021
 * https://www.hackerrank.com/challenges/picking-numbers/problem
 */
public class PickingNumbers {
    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        int max = Integer.MIN_VALUE;
        for (Integer i : a) {
            if (i > max) {
                max = i;
            }
        }
        int [] counts = new int[max + 1];
        for (Integer i : a) {
            counts[i]++;
        }

        int maxLen = Integer.MIN_VALUE;
        for (int i = 1; i < counts.length; i++) {
            int len = counts[i - 1] + counts[i];
            if (len > maxLen) {
                maxLen = len;
            }
        }

        return maxLen;
    }
}
