package gitTheAlgos.math;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://en.wikipedia.org/wiki/Amicable_numbers
 * Amicable numbers are two different numbers related in such a way that the sum of the proper divisors of each is equal to the other number.
 *
 * The smallest pair of amicable numbers is (220, 284). They are amicable because
 * the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110, of which the sum is 284;
 * and the proper divisors of 284 are 1, 2, 4, 71 and 142, of which the sum is 220.
 * (A proper divisor of a number is a positive factor of that number other than the number itself.
 * For example, the proper divisors of 6 are 1, 2, and 3.)
 *
 * The first ten amicable pairs are:
 * (220, 284), (1184, 1210), (2620, 2924), (5020, 5564),
 * (6232, 6368), (10744, 10856), (12285, 14595),
 * (17296, 18416), (63020, 76084), and (66928, 66992).
 *
 * Learning -
 * 1. If I need to ceil if not divisible, using n/m + 1 will result in error.
 * 2. when doing indexing with expressions, make sure so that it doesn't become negative.
 */
public class AmicableNumbers {
    public static ArrayList findAllInRange(int start, int end) {
        int[] divSums = getAllDivSums(start, end);
        ArrayList amicablePairs = new ArrayList();

        for (int i = 0; i < divSums.length; i++) {
            int index = divSums[i] - start;
            if (index > i && index < divSums.length && divSums[index] == i + start){
                int[] pair = new int[2];
                pair[0] = i + start;
                pair[1] = divSums[i];
                amicablePairs.add(pair);
            }
        }

        return amicablePairs;
    }

    public static int[] getAllDivSums(int start, int end) {
        int []divSums = new int[end-start+1];
        Arrays.fill(divSums, 1);

        for (int i = 2, l = (int) (Math.sqrt(end) + 1); i < l; i++) {
            for (int j = Math.max(i, (int) Math.ceil(1.0*start/i)); i * j <= end; j++) {
                int index = i * j - start;
                divSums[index] += i;
                if (j > i) {
                    divSums[index] += j;
                }
            }
        }
        return divSums;
    }
}
