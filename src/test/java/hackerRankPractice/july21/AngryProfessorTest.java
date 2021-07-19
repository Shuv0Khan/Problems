package hackerRankPractice.july21;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author shuvo
 * @since 19/07/2021
 *
 */
class AngryProfessorTest {

    @Test
    @DisplayName("Test cases provided")
    void testCasesProvided() {
        List<Integer> a;

        a = Arrays.asList(-2, -1, 0, 1, 2);
        Assertions.assertEquals("NO", AngryProfessor.angryProfessor(3, a));

        a = Arrays.asList(-1, -3, 4, 2);
        Assertions.assertEquals("YES", AngryProfessor.angryProfessor(3, a));

        a = Arrays.asList(0, -1, 2, 1);
        Assertions.assertEquals("NO", AngryProfessor.angryProfessor(2, a));
    }
}
