package hackerRankPractice.july21;

import hackerRankPractice.july21.TheHurdleRace;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author shuvo
 * @since 06/07/2021
 *
 */
class TheHurdleRaceTest {

    @Test
    @DisplayName("Test cases provided")
    void testCasesProvided() {
        List<Integer> hurdles;

        hurdles = Arrays.asList(1, 2, 3, 3, 2);
        Assertions.assertEquals(2, TheHurdleRace.hurdleRace(1, hurdles));

        hurdles = Arrays.asList(1, 6, 3, 5, 2);
        Assertions.assertEquals(2, TheHurdleRace.hurdleRace(4, hurdles));

        hurdles = Arrays.asList(2, 5, 4, 5, 2);
        Assertions.assertEquals(0, TheHurdleRace.hurdleRace(7, hurdles));
    }

    @Test
    @DisplayName("Test cases")
    void testCases() {
        List<Integer> hurdles;

        hurdles = Arrays.asList(1, 2, 3, 3, 2);
        Assertions.assertEquals(1, TheHurdleRace.hurdleRace(2, hurdles));

        hurdles = Arrays.asList(1, 6, 3, 5, 2);
        Assertions.assertEquals(0, TheHurdleRace.hurdleRace(6, hurdles));

        hurdles = Arrays.asList(2, 5, 4, 5, 2);
        Assertions.assertEquals(4, TheHurdleRace.hurdleRace(1, hurdles));
    }
}
