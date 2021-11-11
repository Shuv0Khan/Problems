package gitTheAlgos.algos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class CombinationsTest {
    @Test
    @DisplayName("basic positive test")
    void basicPositiveTest() {
        ArrayList<String> combs;
        ArrayList<String> data;

        // r = 0
        data = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        combs = Combinations.allOfLen(data, 0);
        assertEquals(0, combs.size());

        // r = 1
        data = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        combs = Combinations.allOfLen(data, 1);
        assertEquals(data, combs);

        // r > 1
        data = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        combs = Combinations.allOfLen(data, 3);
        data = new ArrayList<>(Arrays.asList(
                "a,b,c", "a,b,d", "a,c,d", "b,c,d"
        ));
        assertEquals(data, combs);

        data = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f"));
        combs = Combinations.allOfLen(data, 3);
        data = new ArrayList<>(Arrays.asList(
                "a,b,c", "a,b,d", "a,b,e", "a,b,f",
                "a,c,d", "a,c,e", "a,c,f",
                "a,d,e", "a,d,f",
                "a,e,f",
                "b,c,d", "b,c,e", "b,c,f",
                "b,d,e", "b,d,f",
                "b,e,f",
                "c,d,e", "c,d,f",
                "c,e,f",
                "d,e,f"
        ));
        assertEquals(data, combs);

        // n == r
        data = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        combs = Combinations.allOfLen(data, 4);
        data = new ArrayList<>(Arrays.asList(
                "a,b,c,d"
        ));
        assertEquals(data, combs);

        // n < r
        data = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        combs = Combinations.allOfLen(data, 5);
        assertEquals(0, combs.size());

    }

    @Test
    @DisplayName("random test against proven algo")
    void randomTestAgainstProvenAlgo() {
        ArrayList<String> combs;
        ArrayList<String> data;
        Random random = new Random();
        for (int l = 0; l < 10; l++) {
            int n = random.nextInt(10);
            int r = random.nextInt(10) + 1; // baeldung algo doesn't work with invalid input r<=0
            n += r;
            System.out.println(n+","+r);
            List<int[]> intcombs = Combinations.generate(n, r);
            combs = new ArrayList<>();
            for (int[] c : intcombs) {
                combs.add(Arrays.stream(c).mapToObj(Integer::toString).collect(Collectors.joining(",")));
            }
            data = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                data.add(Integer.toString(i));
            }
            assertEquals(combs, Combinations.allOfLen(data, r));
        }
    }
}