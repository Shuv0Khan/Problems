package gitTheAlgos.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BinaryExponentTest {

    @Test
    @DisplayName("base cases")
    void positiveBaseCases() {
        assertEquals(BigInteger.valueOf(1), BinaryExponent.pow(1231323, 0));
        assertEquals(BigInteger.valueOf(Integer.MAX_VALUE), BinaryExponent.pow(Integer.MAX_VALUE, 1));

        /*
         * Binary exponent will work with only positive powers.
         * Negative powers will return -1 to indicate invalid input
         **/

        assertEquals(BigInteger.valueOf(-1), BinaryExponent.pow(123, -1312));
    }

    @Test
    @DisplayName("random positive integer test")
    void randomPositiveIntegerTest() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int a = Math.abs(random.nextInt(100));
            int n = Math.abs(random.nextInt(100));
            System.out.println(a+"^"+n);
            assertEquals(BigInteger.valueOf(a).pow(n), BinaryExponent.pow(a, n));
        }
    }

}