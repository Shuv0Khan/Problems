package hackerRankPractice.july21;

/**
 * https://www.hackerrank.com/challenges/append-and-delete/problem?h_r=next-challenge&h_v=zen
 */
public class AppendAndDelete {
    /*
     * Complete the 'appendAndDelete' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     *  3. INTEGER k
     */

    public static String appendAndDelete(String s, String t, int k) {
        // Write your code here
        String YES = "Yes";
        String NO = "No";
        int sLen = s.length();
        int tLen = t.length();

        if (k >= sLen + tLen) {
            return YES;
        }

        if (sLen == 0 || tLen == 0 || s.charAt(0) != t.charAt(0)) {
            int totalLen = sLen + tLen;
            if (k >= totalLen) {
                return YES;
            }
            return NO;
        }

        int i = 1;
        for (; i < sLen && i < tLen; i++){
            if (s.charAt(i) != t.charAt(i)) {
                break;
            }
        }

        int opNeeded = (sLen - i) + (tLen - i);
        if (opNeeded == k){
            return YES;
        } else if (k < opNeeded) {
            return NO;
        }

        // TODO: 03/07/2021 Whenever subtraction is done, remember that the result may be -ve.
        opNeeded = k - opNeeded;
        if (opNeeded % 2 == 0){
            return YES;
        }

        return NO;
    }
}
