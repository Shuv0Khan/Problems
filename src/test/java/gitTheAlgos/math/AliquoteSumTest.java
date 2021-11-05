package gitTheAlgos.math;

import gitTheAlgos.math.AliquoteSum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

class AliquoteSumTest {

    @Test
    @DisplayName("basic checks")
    void basicChecks() {
        Assertions.assertEquals(0, AliquoteSum.sum(1));
        Assertions.assertEquals(1, AliquoteSum.sum(2));
        Assertions.assertEquals(1, AliquoteSum.sum(3));
        Assertions.assertEquals(3, AliquoteSum.sum(4));
        Assertions.assertEquals(1, AliquoteSum.sum(5));
        Assertions.assertEquals(6, AliquoteSum.sum(6));

        Assertions.assertEquals(16, AliquoteSum.sum(12));
        Assertions.assertEquals(11, AliquoteSum.sum(21));
        Assertions.assertEquals(55, AliquoteSum.sum(36));
    }

    @Test
    @DisplayName("randomTest")
    void randomTest() {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int n = Math.abs(rand.nextInt());
            System.out.println("checking: "+n);
            Assertions.assertEquals(AliquoteSum.aliquotSum(n), AliquoteSum.sum(n));
        }

    }

}