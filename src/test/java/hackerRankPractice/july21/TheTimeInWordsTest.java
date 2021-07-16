package hackerRankPractice.july21;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author shuvo
 * @since 16/07/2021
 *
 */
class TheTimeInWordsTest {

    @Test
    @DisplayName("Test cases given")
    void testCasesGiven() {
        Assertions.assertEquals("five o' clock", TheTimeInWords.timeInWords(5, 0));
        Assertions.assertEquals("one minute past five", TheTimeInWords.timeInWords(5, 1));
        Assertions.assertEquals("ten minutes past five", TheTimeInWords.timeInWords(5, 10));
        Assertions.assertEquals("twelve minutes past five", TheTimeInWords.timeInWords(5, 12));
        Assertions.assertEquals("quarter past five", TheTimeInWords.timeInWords(5, 15));
        Assertions.assertEquals("twenty one minutes past five", TheTimeInWords.timeInWords(5, 21));
        Assertions.assertEquals("twenty five minutes past five", TheTimeInWords.timeInWords(5, 25));
        Assertions.assertEquals("half past five", TheTimeInWords.timeInWords(5, 30));
        Assertions.assertEquals("twenty nine minutes to six", TheTimeInWords.timeInWords(5, 31));
        Assertions.assertEquals("twenty three minutes to six", TheTimeInWords.timeInWords(5, 37));
        Assertions.assertEquals("quarter to six", TheTimeInWords.timeInWords(5, 45));
        Assertions.assertEquals("ten minutes to six", TheTimeInWords.timeInWords(5, 50));
        Assertions.assertEquals("five minute to six", TheTimeInWords.timeInWords(5, 55));

        Assertions.assertEquals("thirteen minutes to six", TheTimeInWords.timeInWords(5, 47));
        Assertions.assertEquals("three o' clock", TheTimeInWords.timeInWords(3, 0));
        Assertions.assertEquals("quarter past seven", TheTimeInWords.timeInWords(7, 15));

    }

    @Test
    @DisplayName("Test cases")
    void testCases() {
        Assertions.assertEquals("twelve o' clock", TheTimeInWords.timeInWords(12, 0));
        Assertions.assertEquals("ten minutes past twelve", TheTimeInWords.timeInWords(12, 10));
        Assertions.assertEquals("quarter past twelve", TheTimeInWords.timeInWords(12, 15));
        Assertions.assertEquals("twenty five minutes past twelve", TheTimeInWords.timeInWords(12, 25));
        Assertions.assertEquals("half past twelve", TheTimeInWords.timeInWords(12, 30));
        Assertions.assertEquals("twenty three minutes to one", TheTimeInWords.timeInWords(12, 37));
        Assertions.assertEquals("quarter to one", TheTimeInWords.timeInWords(12, 45));
        Assertions.assertEquals("ten minutes to one", TheTimeInWords.timeInWords(12, 50));

        Assertions.assertEquals("one o' clock", TheTimeInWords.timeInWords(1, 0));
        Assertions.assertEquals("ten minutes past one", TheTimeInWords.timeInWords(1, 10));
        Assertions.assertEquals("quarter past one", TheTimeInWords.timeInWords(1, 15));
        Assertions.assertEquals("twenty five minutes past one", TheTimeInWords.timeInWords(1, 25));
        Assertions.assertEquals("half past one", TheTimeInWords.timeInWords(1, 30));
        Assertions.assertEquals("twenty three minutes to two", TheTimeInWords.timeInWords(1, 37));
        Assertions.assertEquals("quarter to two", TheTimeInWords.timeInWords(1, 45));
        Assertions.assertEquals("ten minutes to two", TheTimeInWords.timeInWords(1, 50));

        Assertions.assertEquals("two o' clock", TheTimeInWords.timeInWords(2, 0));
        Assertions.assertEquals("ten minutes past two", TheTimeInWords.timeInWords(2, 10));
        Assertions.assertEquals("quarter past two", TheTimeInWords.timeInWords(2, 15));
        Assertions.assertEquals("twenty five minutes past two", TheTimeInWords.timeInWords(2, 25));
        Assertions.assertEquals("half past two", TheTimeInWords.timeInWords(2, 30));
        Assertions.assertEquals("twenty three minutes to three", TheTimeInWords.timeInWords(2, 37));
        Assertions.assertEquals("quarter to three", TheTimeInWords.timeInWords(2, 45));
        Assertions.assertEquals("ten minutes to three", TheTimeInWords.timeInWords(2, 50));

        Assertions.assertEquals("three o' clock", TheTimeInWords.timeInWords(3, 0));
        Assertions.assertEquals("ten minutes past three", TheTimeInWords.timeInWords(3, 10));
        Assertions.assertEquals("quarter past three", TheTimeInWords.timeInWords(3, 15));
        Assertions.assertEquals("twenty five minutes past three", TheTimeInWords.timeInWords(3, 25));
        Assertions.assertEquals("half past three", TheTimeInWords.timeInWords(3, 30));
        Assertions.assertEquals("twenty three minutes to four", TheTimeInWords.timeInWords(3, 37));
        Assertions.assertEquals("quarter to four", TheTimeInWords.timeInWords(3, 45));
        Assertions.assertEquals("ten minutes to four", TheTimeInWords.timeInWords(3, 50));

        Assertions.assertEquals("four o' clock", TheTimeInWords.timeInWords(4, 0));
        Assertions.assertEquals("ten minutes past four", TheTimeInWords.timeInWords(4, 10));
        Assertions.assertEquals("quarter past four", TheTimeInWords.timeInWords(4, 15));
        Assertions.assertEquals("twenty five minutes past four", TheTimeInWords.timeInWords(4, 25));
        Assertions.assertEquals("half past four", TheTimeInWords.timeInWords(4, 30));
        Assertions.assertEquals("twenty three minutes to five", TheTimeInWords.timeInWords(4, 37));
        Assertions.assertEquals("quarter to five", TheTimeInWords.timeInWords(4, 45));
        Assertions.assertEquals("ten minutes to five", TheTimeInWords.timeInWords(4, 50));

        Assertions.assertEquals("five o' clock", TheTimeInWords.timeInWords(5, 0));
        Assertions.assertEquals("ten minutes past five", TheTimeInWords.timeInWords(5, 10));
        Assertions.assertEquals("quarter past five", TheTimeInWords.timeInWords(5, 15));
        Assertions.assertEquals("twenty five minutes past five", TheTimeInWords.timeInWords(5, 25));
        Assertions.assertEquals("half past five", TheTimeInWords.timeInWords(5, 30));
        Assertions.assertEquals("twenty three minutes to six", TheTimeInWords.timeInWords(5, 37));
        Assertions.assertEquals("quarter to six", TheTimeInWords.timeInWords(5, 45));
        Assertions.assertEquals("ten minutes to six", TheTimeInWords.timeInWords(5, 50));

        Assertions.assertEquals("six o' clock", TheTimeInWords.timeInWords(6, 0));
        Assertions.assertEquals("ten minutes past six", TheTimeInWords.timeInWords(6, 10));
        Assertions.assertEquals("quarter past six", TheTimeInWords.timeInWords(6, 15));
        Assertions.assertEquals("twenty five minutes past six", TheTimeInWords.timeInWords(6, 25));
        Assertions.assertEquals("half past six", TheTimeInWords.timeInWords(6, 30));
        Assertions.assertEquals("twenty three minutes to seven", TheTimeInWords.timeInWords(6, 37));
        Assertions.assertEquals("quarter to seven", TheTimeInWords.timeInWords(6, 45));
        Assertions.assertEquals("ten minutes to seven", TheTimeInWords.timeInWords(6, 50));

        Assertions.assertEquals("seven o' clock", TheTimeInWords.timeInWords(7, 0));
        Assertions.assertEquals("ten minutes past seven", TheTimeInWords.timeInWords(7, 10));
        Assertions.assertEquals("quarter past seven", TheTimeInWords.timeInWords(7, 15));
        Assertions.assertEquals("twenty five minutes past seven", TheTimeInWords.timeInWords(7, 25));
        Assertions.assertEquals("half past seven", TheTimeInWords.timeInWords(7, 30));
        Assertions.assertEquals("twenty three minutes to eight", TheTimeInWords.timeInWords(7, 37));
        Assertions.assertEquals("quarter to eight", TheTimeInWords.timeInWords(7, 45));
        Assertions.assertEquals("ten minutes to eight", TheTimeInWords.timeInWords(7, 50));

        Assertions.assertEquals("eight o' clock", TheTimeInWords.timeInWords(8, 0));
        Assertions.assertEquals("ten minutes past eight", TheTimeInWords.timeInWords(8, 10));
        Assertions.assertEquals("quarter past eight", TheTimeInWords.timeInWords(8, 15));
        Assertions.assertEquals("twenty five minutes past eight", TheTimeInWords.timeInWords(8, 25));
        Assertions.assertEquals("half past eight", TheTimeInWords.timeInWords(8, 30));
        Assertions.assertEquals("twenty three minutes to nine", TheTimeInWords.timeInWords(8, 37));
        Assertions.assertEquals("quarter to nine", TheTimeInWords.timeInWords(8, 45));
        Assertions.assertEquals("ten minutes to nine", TheTimeInWords.timeInWords(8, 50));

        Assertions.assertEquals("nine o' clock", TheTimeInWords.timeInWords(9, 0));
        Assertions.assertEquals("ten minutes past nine", TheTimeInWords.timeInWords(9, 10));
        Assertions.assertEquals("quarter past nine", TheTimeInWords.timeInWords(9, 15));
        Assertions.assertEquals("twenty five minutes past nine", TheTimeInWords.timeInWords(9, 25));
        Assertions.assertEquals("half past nine", TheTimeInWords.timeInWords(9, 30));
        Assertions.assertEquals("twenty three minutes to ten", TheTimeInWords.timeInWords(9, 37));
        Assertions.assertEquals("quarter to ten", TheTimeInWords.timeInWords(9, 45));
        Assertions.assertEquals("ten minutes to ten", TheTimeInWords.timeInWords(9, 50));

        Assertions.assertEquals("ten o' clock", TheTimeInWords.timeInWords(10, 0));
        Assertions.assertEquals("ten minutes past ten", TheTimeInWords.timeInWords(10, 10));
        Assertions.assertEquals("quarter past ten", TheTimeInWords.timeInWords(10, 15));
        Assertions.assertEquals("twenty five minutes past ten", TheTimeInWords.timeInWords(10, 25));
        Assertions.assertEquals("half past ten", TheTimeInWords.timeInWords(10, 30));
        Assertions.assertEquals("twenty three minutes to eleven", TheTimeInWords.timeInWords(10, 37));
        Assertions.assertEquals("quarter to eleven", TheTimeInWords.timeInWords(10, 45));
        Assertions.assertEquals("ten minutes to eleven", TheTimeInWords.timeInWords(10, 50));

        Assertions.assertEquals("eleven o' clock", TheTimeInWords.timeInWords(11, 0));
        Assertions.assertEquals("ten minutes past eleven", TheTimeInWords.timeInWords(11, 10));
        Assertions.assertEquals("quarter past eleven", TheTimeInWords.timeInWords(11, 15));
        Assertions.assertEquals("twenty five minutes past eleven", TheTimeInWords.timeInWords(11, 25));
        Assertions.assertEquals("half past eleven", TheTimeInWords.timeInWords(11, 30));
        Assertions.assertEquals("twenty three minutes to twelve", TheTimeInWords.timeInWords(11, 37));
        Assertions.assertEquals("quarter to twelve", TheTimeInWords.timeInWords(11, 45));
        Assertions.assertEquals("ten minutes to twelve", TheTimeInWords.timeInWords(11, 50));
    }
}
