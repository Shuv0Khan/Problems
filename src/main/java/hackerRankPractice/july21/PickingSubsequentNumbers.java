package hackerRankPractice.july21;

import java.util.List;

/**
 * @author shuvo
 * @since 04/07/2021
 * twist on -
 * https://www.hackerrank.com/challenges/picking-numbers/problem
 *
 * pick subsequent numbers to form the subarray
 */
public class PickingSubsequentNumbers {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        int maxLen = 0;
        int minInWindow = a.get(0);
        int maxInWindow = a.get(0);
        int start = 0;
        int i = 1;

        for (; i < a.size(); i++) {
            int current = a.get(i);
            if (current > maxInWindow) {
                maxInWindow = current;
            } else if (current < minInWindow) {
                minInWindow = current;
            }

            // TODO: 04/07/2021 when subtracting note the possible signs of both args.
            if (Math.abs(minInWindow - maxInWindow) > 1) {
                int len = i - start;
                if (len > maxLen) {
                    maxLen = len;
                }

                minInWindow = maxInWindow = current;
                int j = i - 1;
                for (; j > start; j--) {
                    if (Math.abs(current - a.get(j)) > 1) {
                        break;
                    }
                    if (a.get(j) > maxInWindow) {
                        maxInWindow = a.get(j);
                    } else if (a.get(j) < minInWindow) {
                        minInWindow = a.get(j);
                    }
                }
                start = ++j;
            }

        }

        if (maxLen < (i - start)) {
            maxLen = i - start;
        }
        return maxLen;
    }

}
