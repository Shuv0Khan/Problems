package hackerRankPractice.july21;

import hackerRankPractice.july21.AppendAndDelete;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AppendAndDeleteTest {
    String YES = "Yes";
    String NO = "No";

    @Test
    @DisplayName("Test with full delete or empty")
    void testWithFullDeleteOrEmpty() {
        Assertions.assertEquals(YES, AppendAndDelete.appendAndDelete("abc", "def", 6));
        Assertions.assertEquals(YES, AppendAndDelete.appendAndDelete("abc", "def", 7));
        Assertions.assertEquals(NO, AppendAndDelete.appendAndDelete("abc", "def", 5));

        Assertions.assertEquals(YES, AppendAndDelete.appendAndDelete("", "def", 3));
        Assertions.assertEquals(YES, AppendAndDelete.appendAndDelete("", "def", 5));
        Assertions.assertEquals(NO, AppendAndDelete.appendAndDelete("", "def", 2));

        Assertions.assertEquals(YES, AppendAndDelete.appendAndDelete("abc", "", 3));
        Assertions.assertEquals(YES, AppendAndDelete.appendAndDelete("abc", "", 5));
        Assertions.assertEquals(NO, AppendAndDelete.appendAndDelete("abc", "", 2));

        Assertions.assertEquals(YES, AppendAndDelete.appendAndDelete("", "", 0));
        Assertions.assertEquals(YES, AppendAndDelete.appendAndDelete("", "", 2));
    }

    @Test
    @DisplayName("Test partial delete and Append")
    void testPartialDeleteAndAppend() {

        Assertions.assertEquals(YES, AppendAndDelete.appendAndDelete("abc", "abc", 0));
        Assertions.assertEquals(YES, AppendAndDelete.appendAndDelete("abc", "abc", 4));
        Assertions.assertEquals(NO, AppendAndDelete.appendAndDelete("abc", "abc", 5));

        Assertions.assertEquals(YES, AppendAndDelete.appendAndDelete("abcd", "ab", 2));
        Assertions.assertEquals(YES, AppendAndDelete.appendAndDelete("abcd", "ab", 4));
        Assertions.assertEquals(NO, AppendAndDelete.appendAndDelete("abcd", "ab", 5));
        Assertions.assertEquals(NO, AppendAndDelete.appendAndDelete("abcd", "ab", 1));

        Assertions.assertEquals(YES, AppendAndDelete.appendAndDelete("abc", "abcdef", 3));
        Assertions.assertEquals(YES, AppendAndDelete.appendAndDelete("abc", "abcdef", 5));
        Assertions.assertEquals(YES, AppendAndDelete.appendAndDelete("abc", "abcdef", 9));
        Assertions.assertEquals(NO, AppendAndDelete.appendAndDelete("abc", "abcdef", 6));
        Assertions.assertEquals(NO, AppendAndDelete.appendAndDelete("abc", "abcdef", 2));

        Assertions.assertEquals(YES, AppendAndDelete.appendAndDelete("abcd", "abef", 4));
        Assertions.assertEquals(YES, AppendAndDelete.appendAndDelete("abcd", "abef", 6));
        Assertions.assertEquals(NO, AppendAndDelete.appendAndDelete("abcd", "abef", 7));
        Assertions.assertEquals(NO, AppendAndDelete.appendAndDelete("abcd", "abef", 3));

        Assertions.assertEquals(YES, AppendAndDelete.appendAndDelete("abc", "adef", 5));
        Assertions.assertEquals(YES, AppendAndDelete.appendAndDelete("abc", "abdef", 6));
        Assertions.assertEquals(NO, AppendAndDelete.appendAndDelete("abc", "abdef", 7));
        Assertions.assertEquals(NO, AppendAndDelete.appendAndDelete("abc", "adef", 4));

        Assertions.assertEquals(YES, AppendAndDelete.appendAndDelete("abc", "ad", 3));
        Assertions.assertEquals(YES, AppendAndDelete.appendAndDelete("abc", "ad", 5));
        Assertions.assertEquals(YES, AppendAndDelete.appendAndDelete("abc", "ad", 6));
        Assertions.assertEquals(YES, AppendAndDelete.appendAndDelete("abc", "ad", 5));

        Assertions.assertEquals(NO, AppendAndDelete.appendAndDelete("qwerasdf", "qwerbsdf", 6));
    }
}
