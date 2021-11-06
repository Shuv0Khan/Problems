package gitTheAlgos.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CombinatorialTest {
    @Test
    @DisplayName("invalid input cases")
    void invalidInputCases() {
        assertEquals(BigInteger.valueOf(-1), Combinatorial.C(-1, -1));
        assertEquals(BigInteger.valueOf(-1), Combinatorial.C(3, 4));
    }

    @Test
    @DisplayName("specific tests")
    void specificTests() {
        int n = 6;
        int r = 3;
        assertEquals(Combinatorial.factorialC(n, r), Combinatorial.C(n, r));
    }

    @Test
    @DisplayName("basic random tests")
    void basicRandomTests() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int n = Math.abs(random.nextInt(100));
            int r = Math.abs(random.nextInt(10));
            if (n < r) continue;

            System.out.println(n+" C "+r);

            assertEquals(Combinatorial.factorialC(n, r), Combinatorial.C(n, r));
        }
    }
}