package gitTheAlgos.math;

import java.math.BigInteger;

/**
 * nCr = n!/(r! (n-r)!)
 * nC(k+1) = n!/((k+1)!.(n-k-1)!)
 * nC(k+1)/(n-k) = n!/((k+1).k!.(n-k-1)!.(n-k))
 * nC(k+1)/(n-k) = (n!/(k!.(n-k)!)) . (1/(k+1))
 * nC(k+1) = nCk . (n-k)/(k+1)
 *
 * starting with k = 0
 * nC1 = nC0 . n
 *
 * Learning -
 * 1. multiplying nCr with (n-k) before dividing it by (k+1) works without considering doubles
 * instead of dividing first before multiplying.
 */
public class Combinatorial {
    public static BigInteger C(int n, int r) {
        if (n < 0 || r < 0) {
            /*
             * Indicates invalid input instead of throwing an exception.
             **/
            return BigInteger.valueOf(-1);
        }
        if (n < r) {
            /*
             * Indicates invalid input instead of throwing an exception.
             **/
            return BigInteger.valueOf(-1);
        }

        /*
         * starting with r = 0
         **/
        BigInteger nCr = BigInteger.ONE;

        for (int k = 0; k < r; k++) {
            /*
             * nC(k+1) = nCk . (n-k)/(k+1)
             **/
            nCr = nCr.multiply(BigInteger.valueOf((n-k))).divide(BigInteger.valueOf((k+1)));
        }

        return nCr;
    }

    public static BigInteger factorialC(int n, int r) {
        if (n < 0) {
            /*
             * Invalid input. Not throwing exception here.
             **/
            return BigInteger.valueOf(-1);
        }
        BigInteger nfac = BigInteger.ONE;
        for (int i = 2; i <=n; i++){
            nfac = nfac.multiply(BigInteger.valueOf(i));
        }

        BigInteger rfac = BigInteger.ONE;
        for (int i = 2; i <=r; i++){
            rfac = rfac.multiply(BigInteger.valueOf(i));
        }

        BigInteger nmrfac = BigInteger.ONE;
        for (int i = 2, l=n-r; i <=l; i++){
            nmrfac = nmrfac.multiply(BigInteger.valueOf(i));
        }

        return nfac.divide(rfac.multiply(nmrfac));
    }
}
