package hackerRankPractice.july21;

/**
 * @author shuvo
 * @since 19/07/2021
 * https://www.hackerrank.com/challenges/utopian-tree/problem
 */
public class UtopianTree {
    /*
     * Complete the 'utopianTree' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int utopianTree(int n) {
        // Write your code here
        int height = 1;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                height++;
            } else {
                height *= 2;
            }
        }

        return height;

    }

}
