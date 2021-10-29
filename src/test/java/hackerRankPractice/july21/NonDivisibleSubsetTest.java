package hackerRankPractice.july21;

import hackerRankPractice.july21.NonDivisibleSubset;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author shuvo
 * @since 10/07/2021
 *
 */
class NonDivisibleSubsetTest {

    @Test
    @DisplayName("Test cases provided")
    void testCasesProvided() {
        List<Integer> list;

        list = Arrays.asList(19, 10, 12, 10, 24, 25, 22);
        Assertions.assertEquals(3, NonDivisibleSubset.nonDivisibleSubset(4, list));

        list = Arrays.asList(1, 7, 2, 4);
        Assertions.assertEquals(3, NonDivisibleSubset.nonDivisibleSubset(3, list));
    }

    @Test
    @DisplayName("Test cases")
    void testCases() {
        List<Integer> list;

        list = Arrays.asList(18, 28, 19, 17, 5, 4, 16);
        Assertions.assertEquals(4, NonDivisibleSubset.nonDivisibleSubset(4, list));
    }
}
