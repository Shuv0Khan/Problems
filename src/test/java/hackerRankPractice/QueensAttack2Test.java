package hackerRankPractice;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
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
class QueensAttack2Test {

    @Test
    @DisplayName("Test corner Distance")
    void testCornerDistance() {
        int[][] cornerDist = {
            {1, 1, 1},
            {2, 0, 2},
            {2, 3, 2}
        };
        Assertions.assertArrayEquals(cornerDist, QueensAttack2.findCornerDistances(3, 4, 5));

        cornerDist = new int[][]{
            {2, 2, 2},
            {2, 0, 2},
            {2, 2, 2}
        };
        Assertions.assertArrayEquals(cornerDist, QueensAttack2.findCornerDistances(3, 3, 5));

        cornerDist = new int[][]{
            {0, 2, 2},
            {0, 0, 4},
            {0, 2, 2}
        };
        Assertions.assertArrayEquals(cornerDist, QueensAttack2.findCornerDistances(1, 3, 5));

    }

    @Test
    @DisplayName("Test cases provided")
    void testCasesProvided() {
        List<List<Integer>> obstacles;

        Assertions.assertEquals(27, QueensAttack2.queensAttack(8, 0, 4, 4, null));

        obstacles = new ArrayList<>();
        obstacles.add(Arrays.asList(3, 5));
        Assertions.assertEquals(24, QueensAttack2.queensAttack(8, 1, 4, 4, obstacles));

        Assertions.assertEquals(9, QueensAttack2.queensAttack(4, 0, 4, 4, null));

        obstacles = new ArrayList<>();
        obstacles.add(Arrays.asList(5, 5));
        obstacles.add(Arrays.asList(4, 2));
        obstacles.add(Arrays.asList(2, 3));
        Assertions.assertEquals(10, QueensAttack2.queensAttack(5, 3, 4, 3, obstacles));



    }
}
