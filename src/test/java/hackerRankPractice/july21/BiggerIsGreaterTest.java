package hackerRankPractice.july21;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author shuvo
 * @since 13/07/2021
 *
 */
class BiggerIsGreaterTest {

    @Test
    @DisplayName("Test cases provided")
    void testCasesProvided() {
        Assertions.assertEquals("abdc", BiggerIsGreater.biggerIsGreater("abcd"));
        Assertions.assertEquals("ba", BiggerIsGreater.biggerIsGreater("ab"));
        Assertions.assertEquals("no answer", BiggerIsGreater.biggerIsGreater("bb"));
        Assertions.assertEquals("hegf", BiggerIsGreater.biggerIsGreater("hefg"));
        Assertions.assertEquals("dhkc", BiggerIsGreater.biggerIsGreater("dhck"));
        Assertions.assertEquals("hcdk", BiggerIsGreater.biggerIsGreater("dkhc"));

        Assertions.assertEquals("lmon", BiggerIsGreater.biggerIsGreater("lmno"));
        Assertions.assertEquals("no answer", BiggerIsGreater.biggerIsGreater("dcba"));
        Assertions.assertEquals("no answer", BiggerIsGreater.biggerIsGreater("dcbb"));
        Assertions.assertEquals("acbd", BiggerIsGreater.biggerIsGreater("abdc"));
        Assertions.assertEquals("abdc", BiggerIsGreater.biggerIsGreater("abcd"));
        Assertions.assertEquals("fedcbabdc", BiggerIsGreater.biggerIsGreater("fedcbabcd"));
    }

    @Test
    @DisplayName("Test cases")
    void testCases() {
        Assertions.assertEquals("decab", BiggerIsGreater.biggerIsGreater("debca"));
        Assertions.assertEquals("eabcd", BiggerIsGreater.biggerIsGreater("decba"));
        Assertions.assertEquals("abdce", BiggerIsGreater.biggerIsGreater("abced"));
    }
}
