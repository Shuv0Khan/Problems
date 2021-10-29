package hackerRankPractice.july21;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author shuvo
 * @since 19/07/2021
 *
 */
class UtopianTreeTest {

    @Test
    @DisplayName("Test cases provided")
    void testCasesProvided() {
        Assertions.assertEquals(14, UtopianTree.utopianTree(5));
        Assertions.assertEquals(1, UtopianTree.utopianTree(0));
        Assertions.assertEquals(2, UtopianTree.utopianTree(1));
        Assertions.assertEquals(7, UtopianTree.utopianTree(4));
    }
}
