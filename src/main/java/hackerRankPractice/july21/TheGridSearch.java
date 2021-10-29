package hackerRankPractice.july21;

import java.util.List;

/**
 * @author shuvo
 * @since 16/07/2021
 *
 */
public class TheGridSearch {
    /*
     * Complete the 'gridSearch' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY G
     *  2. STRING_ARRAY P
     */

    public static String gridSearch(List<String> G, List<String> P) {
        // Write your code here
        int R = G.size();
        int C = G.get(0).length();
        int r = P.size();
        int c = P.get(0).length();

        for (int i = 0; i < R - r + 1; i++) {
            String row = G.get(i);
            for (int j = 0; j < C - c + 1; j++) {
                if (row.charAt(j) == P.get(0).charAt(0)) {
                    boolean matched = matchPattern(G, i, j, P);
                    if (matched) {
                        return "YES";
                    }
                }
            }
        }

        return "NO";

    }

    private static boolean matchPattern(List<String> G, int rowI, int colJ, List<String> P) {
        int rowi = P.size();
        int colj = P.get(0).length();

        for (int I = rowI, i = 0; i < rowi; I++,i++) {
            for (int J = colJ, j = 0; j < colj; J++,j++) {
                if (G.get(I).charAt(J) != P.get(i).charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }
}
