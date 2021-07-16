package hackerRankPractice.july21;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author shuvo
 * @since 16/07/2021
 *
 */
class ThreeDSurfaceAreaTest {

    @Test
    @DisplayName("Test cases provided")
    void testCasesProvided() {
        List<List<Integer>> A;

        A = new ArrayList<>();
        A.add(Arrays.asList(1));
        Assertions.assertEquals(6, ThreeDSurfaceArea.surfaceArea(A));

        A = new ArrayList<>();
        A.add(Arrays.asList(1, 3, 4));
        A.add(Arrays.asList(2, 2, 3));
        A.add(Arrays.asList(1, 2, 4));
        Assertions.assertEquals(60, ThreeDSurfaceArea.surfaceArea(A));
    }
}
