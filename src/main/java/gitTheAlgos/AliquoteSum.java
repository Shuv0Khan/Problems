package gitTheAlgos;

/**
 * <p>In number theory, the aliquot sum s(n) of a positive integer n
 * is the sum of all proper divisors of n, that is, all divisors of n other than n itself.
 * It can be used to characterize the prime numbers, perfect numbers,
 * deficient numbers, abundant numbers, and untouchable numbers,
 * and to define the aliquot sequence of a number.
 *
 * <p>For example, the proper divisors of 15 (that is, the positive divisors of 15 that are not equal to 15)
 * are 1, 3 and 5, so the aliquot sum of 15 is 9 i.e. (1 + 3 + 5).
 *
 * <p>The values of s(n) for n = 1, 2, 3, ... are:
 * <p>0, 1, 1, 3, 1, 6, 1, 7,...
 *
 * <p>https://en.wikipedia.org/wiki/Aliquot_sum
 *
 * Lessons -
 * 1. While doing series like this one, take care to check for the initial
 * inputs. For example in this - aliquote sum of 1 is 0.
 *
 * 2. it's not a prime check. so using loop upto sqrt will give error as we will miss n/i factors.
 *
 */
public class AliquoteSum {
    /**
     * Improvement for large numbers
     * @param n
     * @return
     */
    public static int sum(int n) {
        if (n == 1) {
            return 0;
        }
        if (n < 4) {
            return 1;
        }
        int sum = 1;
        for (int i = 2, l = (int) Math.sqrt(n); i <= l; i++) {
            if (n % i == 0) {
                sum += i;
                int div = n/i;
                if (div > l) {
                    sum += div;
                }
            }
        }
        return sum;
    }

    /**
     * This I'm sure works.
     *
     * @param number
     * @return
     */
    public static int aliquotSum(int number) {
        int sum = 0;
        for (int i = 1, limit = number / 2; i <= limit; ++i) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
