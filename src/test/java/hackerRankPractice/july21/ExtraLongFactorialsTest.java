package hackerRankPractice.july21;

import hackerRankPractice.july21.ExtraLongFactorials;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ExtraLongFactorialsTest {

    @Test
    @DisplayName("Test Cases within Integer Limit")
    void testCasesWithinIntegerLimit() {
        Assertions.assertEquals("1", ExtraLongFactorials.extraLongFactorials(0).toString());
        Assertions.assertEquals("1", ExtraLongFactorials.extraLongFactorials(1).toString());
        Assertions.assertEquals("2", ExtraLongFactorials.extraLongFactorials(2).toString());
        Assertions.assertEquals("120", ExtraLongFactorials.extraLongFactorials(5).toString());
        Assertions.assertEquals("720", ExtraLongFactorials.extraLongFactorials(6).toString());
        Assertions.assertEquals("362880", ExtraLongFactorials.extraLongFactorials(9).toString());

    }

    @Test
    @DisplayName("Test cases for extra long factorials")
    void testCasesForExtraLongFactorials() {
        Assertions.assertEquals(
            "3628800",
            ExtraLongFactorials.extraLongFactorials(10).toString());
        Assertions.assertEquals(
            "121645100408832000",
            ExtraLongFactorials.extraLongFactorials(19).toString());
        Assertions.assertEquals(
            "15511210043330985984000000",
            ExtraLongFactorials.extraLongFactorials(25).toString());
    }
}
