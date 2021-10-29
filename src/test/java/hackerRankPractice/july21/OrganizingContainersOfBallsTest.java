package hackerRankPractice.july21;

import hackerRankPractice.july21.OrganizingContainersOfBalls;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author shuvo
 * @since 11/07/2021
 *
 */
class OrganizingContainersOfBallsTest {

    @Test
    @DisplayName("Test cases provided")
    void testCasesProvided() {
        List<List<Integer>> container;

        container = new ArrayList<>();
        container.add(Arrays.asList(1, 4));
        container.add(Arrays.asList(2, 3));
        Assertions.assertEquals("Impossible", OrganizingContainersOfBalls.organizingContainers(container));

        container = new ArrayList<>();
        container.add(Arrays.asList(1, 1));
        container.add(Arrays.asList(1, 1));
        Assertions.assertEquals("Possible", OrganizingContainersOfBalls.organizingContainers(container));

        container = new ArrayList<>();
        container.add(Arrays.asList(0, 2));
        container.add(Arrays.asList(1, 1));
        Assertions.assertEquals("Impossible", OrganizingContainersOfBalls.organizingContainers(container));

        container = new ArrayList<>();
        container.add(Arrays.asList(1, 3, 1));
        container.add(Arrays.asList(2, 1, 2));
        container.add(Arrays.asList(3, 3, 3));
        Assertions.assertEquals("Impossible", OrganizingContainersOfBalls.organizingContainers(container));

        container = new ArrayList<>();
        container.add(Arrays.asList(0, 2, 1));
        container.add(Arrays.asList(1, 1, 1));
        container.add(Arrays.asList(2, 0, 0));
        Assertions.assertEquals("Possible", OrganizingContainersOfBalls.organizingContainers(container));
    }

    @Test
    @DisplayName("Test cases")
    void testCases() {
        List<List<Integer>> container;

        container = new ArrayList<>();
        container.add(Arrays.asList(0));
        Assertions.assertEquals("Possible", OrganizingContainersOfBalls.organizingContainers(container));

        container = new ArrayList<>();
        container.add(Arrays.asList(1));
        Assertions.assertEquals("Possible", OrganizingContainersOfBalls.organizingContainers(container));

        container = new ArrayList<>();
        container.add(Arrays.asList(1, 0));
        container.add(Arrays.asList(0, 2));
        Assertions.assertEquals("Possible", OrganizingContainersOfBalls.organizingContainers(container));

        container = new ArrayList<>();
        container.add(Arrays.asList(0, 1));
        container.add(Arrays.asList(2, 0));
        Assertions.assertEquals("Possible", OrganizingContainersOfBalls.organizingContainers(container));

        container = new ArrayList<>();
        container.add(Arrays.asList(1, 1));
        container.add(Arrays.asList(0, 0));
        Assertions.assertEquals("Impossible", OrganizingContainersOfBalls.organizingContainers(container));

        container = new ArrayList<>();
        container.add(Arrays.asList(3, 4, 5, 2));
        container.add(Arrays.asList(2, 0, 2, 1));
        container.add(Arrays.asList(3, 7, 3, 8));
        container.add(Arrays.asList(7, 6, 2, 9));
        Assertions.assertEquals("Impossible", OrganizingContainersOfBalls.organizingContainers(container));
    }

    /*@Test
    @DisplayName("Test case generation")
    void testCaseGeneration() {
        int n = (int)(Math.random() * 10);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int m = (int)(Math.random() * 10);
                System.out.print(m+", ");
            }
            System.out.println("");
        }
    }*/
}
