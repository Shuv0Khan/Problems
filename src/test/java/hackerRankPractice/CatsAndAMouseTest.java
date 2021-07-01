package hackerRankPractice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CatsAndAMouseTest {

    @Test
    void testCases() {
        Assertions.assertEquals("Cat A", CatsAndAMouse.catAndMouse(4, 1, 3));
        Assertions.assertEquals("Cat B", CatsAndAMouse.catAndMouse(1, 2, 3));
        Assertions.assertEquals("Mouse C", CatsAndAMouse.catAndMouse(1, 3, 2));
    }
}
