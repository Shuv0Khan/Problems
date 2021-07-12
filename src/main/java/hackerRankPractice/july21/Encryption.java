package hackerRankPractice.july21;

/**
 * @author shuvo
 * @since 12/07/2021
 * https://www.hackerrank.com/challenges/encryption/problem
 */
public class Encryption {
    /*
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
        // Write your code here
        s = s.replace(" ", "");

        int l = s.length();
        int row = (int)(Math.sqrt(l));
        int col = row;
        if (row * col < l) {
            if (row * (col + 1) >= l) {
                col++;
            } else {
                row++;
                col++;
            }
        }

        String enc = "";
        for (int i = 0; i < col; i++) {
            for (int j = i; j < l; j+=col) {
                enc += s.charAt(j);
            }
            enc+=" ";
        }
        return enc.trim();
    }
}
