package hackerRankPractice;

import java.util.List;

/**
 * @author shuvo
 * @since 07/07/2021
 * https://www.hackerrank.com/challenges/non-divisible-subset/problem
 */
public class NonDivisibleSubset {
    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here
        int[] count = new int[k];
        for (Integer num : s) {
            count[num % k]++;
        }
        if (k % 2 == 0) {
            count[k/2] = 1;
        }

        int sum = count[0] > 0 ? 1 : 0;
        for (int i = 1; i <= k/2; i++) {
            sum+=Math.max(count[i], count[k-i]);
        }

        return sum;
    }
}
