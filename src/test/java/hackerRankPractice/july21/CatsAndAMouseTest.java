package hackerRankPractice.july21;

import static org.junit.jupiter.api.Assertions.fail;

import hackerRankPractice.july21.CatsAndAMouse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CatsAndAMouseTest {

    @Test
    @DisplayName("Test basic cases")
    void testBasicCases() {
        Assertions.assertEquals("Cat A", CatsAndAMouse.catAndMouse(4, 1, 3));
        Assertions.assertEquals("Cat B", CatsAndAMouse.catAndMouse(1, 2, 3));
        Assertions.assertEquals("Mouse C", CatsAndAMouse.catAndMouse(1, 3, 2));
    }
}
