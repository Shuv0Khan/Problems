package hackerRankPractice.july21;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author shuvo
 * @since 16/07/2021
 */
class TheGridSearchTest {

    @Test
    @DisplayName("Test cases provided")
    void testCasesProvided() {
        List<String> given;
        List<String> pattern;

        given = new ArrayList<>();
        given.add("7283455864");
        given.add("6731158619");
        given.add("8988242643");
        given.add("3830589324");
        given.add("2229505813");
        given.add("5633845374");
        given.add("6473530293");
        given.add("7053106601");
        given.add("0834282956");
        given.add("4607924137");

        pattern = new ArrayList<>();
        pattern.add("9505");
        pattern.add("3845");
        pattern.add("3530");

        Assertions.assertEquals("YES", TheGridSearch.gridSearch(given, pattern));

        given = new ArrayList<>();
        given.add("400453592126560");
        given.add("114213133098692");
        given.add("474386082879648");
        given.add("522356951189169");
        given.add("887109450487496");
        given.add("252802633388782");
        given.add("502771484966748");
        given.add("075975207693780");
        given.add("511799789562806");
        given.add("404007454272504");
        given.add("549043809916080");
        given.add("962410809534811");
        given.add("445893523733475");
        given.add("768705303214174");
        given.add("650629270887160");

        pattern = new ArrayList<>();
        pattern.add("99");
        pattern.add("99");

        Assertions.assertEquals("NO", TheGridSearch.gridSearch(given, pattern));

    }
}
