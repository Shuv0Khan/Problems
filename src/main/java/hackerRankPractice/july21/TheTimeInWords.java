package hackerRankPractice.july21;

/**
 * @author shuvo
 * @since 16/07/2021
 * https://www.hackerrank.com/challenges/the-time-in-words/problem
 */
public class TheTimeInWords {
    /*
     * Complete the 'timeInWords' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER h
     *  2. INTEGER m
     */

    public static String timeInWords(int h, int m) {
        // Write your code here
        String [] eng = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "quarter", "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
            "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine", "half"
        };

        if (m == 0) {
            return eng[h] + " o' clock";
        }

        String text = "";
        String min = "minute";
        if (m > 1 && 60 - m > 1) {
            min = "minutes";
        }

        if (m == 15 || m == 30) {
            text = " past ";
        } else if (m == 45) {
            text = " to ";
        } else if (m < 31) {
            text = " " + min  + " past ";
        } else {
            text = " " + min  + " to ";
        }

        if (m > 30) {
            m = 60 - m;
            h++;
            if (h == 13){
                h = 1;
            }
        }
        return eng[m] + text + eng[h];
    }
}
