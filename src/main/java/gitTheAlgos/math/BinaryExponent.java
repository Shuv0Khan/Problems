package gitTheAlgos.math;

import java.math.BigInteger;

/**
 * Binary exponentiation (also known as exponentiation by squaring) is a trick
 * which allows to calculate an using only O(logn) multiplications
 * (instead of O(n) multiplications required by the naive approach).
 *
 * https://cp-algorithms.com/algebra/binary-exp.html
 *
 * Learning -
 * 1. Exponent can lead to very big numbers even for integers.
 *
 */
public class BinaryExponent {
    public static BigInteger pow(int a, int n) {
        if (n < 0) {
            return BigInteger.valueOf(-1);
        } else if (n == 0) {
            return BigInteger.ONE;
        }
        BigInteger res = BigInteger.ONE;
        BigInteger A = BigInteger.valueOf(a);
        while (n > 0) {
            if ((n & 1) == 1) {
                res = res.multiply(A);
            }
            A = A.multiply(A);
            n = n >> 1;
        }

        return res;
    }
}
