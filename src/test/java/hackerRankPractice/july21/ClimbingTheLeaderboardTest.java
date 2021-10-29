package hackerRankPractice.july21;

import hackerRankPractice.july21.ClimbingTheLeaderboard;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author shuvo
 * @since 05/07/2021
 *
 */
class ClimbingTheLeaderboardTest {

    @Test
    @DisplayName("Test custom binarySearch")
    void testCustomBinarySearch() {
        List<Integer> items;

        items = Arrays.asList(100, 90, 90, 80);
        Assertions.assertEquals(0, ClimbingTheLeaderboard.binarySearch(items, 100));
        Assertions.assertEquals(1, ClimbingTheLeaderboard.binarySearch(items, 90));
        Assertions.assertEquals(3, ClimbingTheLeaderboard.binarySearch(items, 80));

        Assertions.assertEquals(0, ClimbingTheLeaderboard.binarySearch(items, 110));
        Assertions.assertEquals(4, ClimbingTheLeaderboard.binarySearch(items, 70));

        Assertions.assertEquals(1, ClimbingTheLeaderboard.binarySearch(items, 95));
        Assertions.assertEquals(3, ClimbingTheLeaderboard.binarySearch(items, 85));

        items = Arrays.asList(100, 100, 50, 40, 40, 20, 10);
        Assertions.assertEquals(1, ClimbingTheLeaderboard.binarySearch(items, 100));
        Assertions.assertEquals(2, ClimbingTheLeaderboard.binarySearch(items, 50));
        Assertions.assertEquals(3, ClimbingTheLeaderboard.binarySearch(items, 40));
        Assertions.assertEquals(5, ClimbingTheLeaderboard.binarySearch(items, 20));
        Assertions.assertEquals(6, ClimbingTheLeaderboard.binarySearch(items, 10));

        int n = (int) (Math.random() * 100);
        items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            items.add((int) (Math.random() * 100));
        }
        Collections.sort(items, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return -1;
                } else if (o1 < o2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(items.toString());

        List<Integer> find = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < n/2; i++) {
            n = (int) (Math.random() * 100);
            find.add(n);
            try {
                int index = ClimbingTheLeaderboard.binarySearch(items, n);
                indexes.add(index);
                if (index == items.size()) {
                    if (items.get(index - 1) <= n) {
                        Assertions.fail("Item: " + n + ", index found: " + index);
                        break;
                    }
                    continue;
                }

                if (!(items.get(index) == n || (items.get(index - 1) > n && items.get(index) < n))) {
                    Assertions.fail("Item: " + n + ", index found: " + index);
                    break;
                }
            } catch (Exception e){
                Assertions.fail("Failed for item: "+n);
                e.printStackTrace();
            }
        }

        System.out.println(find.toString());
        System.out.println(indexes.toString());

    }

    @Test
    @DisplayName("Test cases provided")
    void testCasesProvided() {
        List<Integer> ranked;
        List<Integer> player;
        List<Integer> expectedResult;

        ranked = Arrays.asList(100, 90, 90, 80);
        player = Arrays.asList(70, 80, 105);
        expectedResult = Arrays.asList(4, 3, 1);
        Assertions.assertEquals(expectedResult, ClimbingTheLeaderboard.climbingLeaderboard(ranked, player));

        ranked = Arrays.asList(100, 100, 50, 40, 40, 20, 10);
        player = Arrays.asList(5, 25, 50, 120);
        expectedResult = Arrays.asList(6, 4, 2, 1);
        Assertions.assertEquals(expectedResult, ClimbingTheLeaderboard.climbingLeaderboard(ranked, player));

        ranked = Arrays.asList(100, 90, 90, 80, 75, 60);
        player = Arrays.asList(50, 65, 77, 90, 120);
        expectedResult = Arrays.asList(6, 5, 4, 2, 1);
        Assertions.assertEquals(expectedResult, ClimbingTheLeaderboard.climbingLeaderboard(ranked, player));

    }
}
