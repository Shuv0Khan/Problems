package hackerRankPractice.july21;

import java.util.Arrays;
import java.util.Map;

/**
 * @author shuvo
 * @since 13/07/2021
 * https://www.hackerrank.com/challenges/bigger-is-greater/problem
 * ---
 * https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
 */
public class BiggerIsGreater {

    public static int distance(String word, int swapThis, int withThat) {
        /*
        * distance of w1 = aelb -> w2 = bela,
        * where w1[swapThis] = a , swapThis = 3,
        *       w1[withThat] = b , withThat = 0
        *
        *         i=n
        * dist = SUM   ((w1[i] - w2[i]) x 26^i)
        *         i=0
        *
        *     where w1[i] = position of the letter in english alphabet
        *           considering position of a is 1 and z is 26.
        **/
        int diff = (word.charAt(withThat) - 'a' + 1) - (word.charAt(swapThis) - 'a' + 1);
        int dist = (int) ((diff * Math.pow(26, swapThis)) + (-diff * Math.pow(26, withThat)));
        return dist;
    }

    /*
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */

    public static String biggerIsGreater(String w) {
        // Write your code here
        char[] line = w.toCharArray();
        /*
        * Find the longest weakly decreasing suffix.
        **/
        int pivot = line.length - 1;
        for (;pivot > 0; pivot--) {
            if (line[pivot] > line[pivot - 1]) {
                break;
            }
        }

        if (pivot == 0){
            return "no answer";
        }
        pivot--;

        /*
        * Find min max compared to pivot element from the suffix
        **/
        int minMax = pivot + 1;
        for (int i = pivot + 1; i < line.length; i++) {
            if (line[i] > line[pivot] && line[i] <= line[minMax]) {
                minMax = i;
            }
        }

        /*
        * Swap
        **/
        char elem = line[pivot];
        line[pivot] = line[minMax];
        line[minMax] = elem;

        /*
        * Reverse the suffix to find minimum possible
        * permutation of given string.
        **/
        int suffixLen = line.length - pivot - 1;
        if (suffixLen == 1) {
            return new String(line);
        }

        int upto = pivot + (suffixLen / 2);
        for (int i = pivot + 1; i <= upto; i++) {
            int j = line.length - 1 - i + pivot + 1;
            elem = line[i];
            line[i] = line[j];
            line[j] = elem;
        }

        return new String(line);
    }
}
