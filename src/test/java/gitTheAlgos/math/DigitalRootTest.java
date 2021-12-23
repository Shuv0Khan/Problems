package gitTheAlgos.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DigitalRootTest {
    @Test
    @DisplayName("basic Tests")
    void basicTests() {
        int n = 1;
        assertEquals(1, DigitalRoot.digitalRoot(1));
        assertEquals(1, DigitalRoot.digitalRootEqn(1));


        n = 99999;
        assertEquals(9, DigitalRoot.digitalRoot(n));
        assertEquals(9, DigitalRoot.digitalRootEqn(n));
    }

    @Test
    @DisplayName("random numbers test")
    void randomNumbersTest() {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int n = rand.nextInt();
            if (n < 0) {
                n = -n;
            } else if (n == 0) {
                n = 99999;
            }
            assertEquals(DigitalRoot.digitalRootEqn(n), DigitalRoot.digitalRoot(n));
        }
    }
}