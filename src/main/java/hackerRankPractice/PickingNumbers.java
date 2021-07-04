package hackerRankPractice;

import java.util.Collections;
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
        Collections.sort(a);

        /*
        the sliding window algorithm in PickingSubsequentNumbers.pickingNumbers(a)
        modified and optimized as the list is sorted.

        int maxLen = 0;
        int minInWindow = a.get(0);
        int maxInWindow = a.get(0);
        int start = 0;
        int nextStart = 1;
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

                start = nextStart;
                minInWindow = a.get(start);
                maxInWindow = current;
                continue;
            }

            if (a.get(nextStart) != current) {
                nextStart = i;
            }

        }

        if (maxLen < (i - start)) {
            maxLen = i - start;
        }
        return maxLen;*/

        return PickingSubsequentNumbers.pickingNumbers(a);
    }
}
