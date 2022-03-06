package common25;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StringProblemsTest {
    @Test
    @DisplayName("reverse sentence by words basic test")
    void reverseSentenceByWordsBasicTest() {
        String sentence = "my name is shuvo";
        String reverse = "shuvo is name my";

        assertEquals(reverse, new String(StringProblems.reverseSentenceByWordsWithExtraSpace(sentence.toCharArray())));
        assertEquals(reverse, new String(StringProblems.reverseSentenceByWords(sentence.toCharArray())));

        sentence = " my name is shuvo";
        reverse = "shuvo is name my ";

        assertEquals(reverse, new String(StringProblems.reverseSentenceByWordsWithExtraSpace(sentence.toCharArray())));
        assertEquals(reverse, new String(StringProblems.reverseSentenceByWords(sentence.toCharArray())));

        sentence = "  my  name  is  shuvo";
        reverse = "shuvo  is  name  my  ";

        assertEquals(reverse, new String(StringProblems.reverseSentenceByWordsWithExtraSpace(sentence.toCharArray())));
        assertEquals(reverse, new String(StringProblems.reverseSentenceByWords(sentence.toCharArray())));

    }

    @Test
    @DisplayName("find all palindrome substrings basic test")
    void findAllPalindromeSubstringsBasicTest() {
        String s = "poppopo";
        Set<String> palindromes = new HashSet<>(Arrays.asList(new String[]{"pop", "oppo", "pp", "poppop", "opo"}));
        Set<String> returns = StringProblems.recursiveFindPalindromeSubStrings(s);
        Set<String> returns2 = StringProblems.centerFindPalindromeSubStrings(s);

        assertEquals(palindromes.size(), returns.size());
        for (String p : palindromes) {
            assertTrue(returns.contains(p));
            assertTrue(returns2.contains(p));
        }

        s = "abcdef";
        palindromes = new HashSet<>();
        returns = StringProblems.recursiveFindPalindromeSubStrings(s);
        returns2 = StringProblems.centerFindPalindromeSubStrings(s);

        assertEquals(palindromes.size(), returns.size());
        for (String p : palindromes) {
            assertTrue(returns.contains(p));
            assertTrue(returns2.contains(p));
        }

        s = "ab";
        palindromes = new HashSet<>();
        returns = StringProblems.recursiveFindPalindromeSubStrings(s);
        returns2 = StringProblems.centerFindPalindromeSubStrings(s);

        assertEquals(palindromes.size(), returns.size());
        for (String p : palindromes) {
            assertTrue(returns.contains(p));
            assertTrue(returns2.contains(p));
        }

        s = "a";
        palindromes = new HashSet<>();
        returns = StringProblems.recursiveFindPalindromeSubStrings(s);
        returns2 = StringProblems.centerFindPalindromeSubStrings(s);

        assertEquals(palindromes.size(), returns.size());
        for (String p : palindromes) {
            assertTrue(returns.contains(p));
            assertTrue(returns2.contains(p));
        }

        s = "abcdcba";
        palindromes = new HashSet<>(Arrays.asList(new String[]{"abcdcba", "bcdcb", "cdc"}));
        returns = StringProblems.recursiveFindPalindromeSubStrings(s);
        returns2 = StringProblems.centerFindPalindromeSubStrings(s);

        assertEquals(palindromes.size(), returns.size());
        for (String p : palindromes) {
            assertTrue(returns.contains(p));
            assertTrue(returns2.contains(p));
        }

        s = "abababa";
        palindromes = new HashSet<>(Arrays.asList(new String[]{"abababa", "babab", "aba", "ababa", "bab"}));
        returns = StringProblems.recursiveFindPalindromeSubStrings(s);
        returns2 = StringProblems.centerFindPalindromeSubStrings(s);

        assertEquals(palindromes.size(), returns.size());
        for (String p : palindromes) {
            assertTrue(returns.contains(p));
            assertTrue(returns2.contains(p));
        }

        s = "poppop";
        palindromes = new HashSet<>(Arrays.asList(new String[]{"poppop", "oppo", "pp", "pop"}));
        returns = StringProblems.recursiveFindPalindromeSubStrings(s);
        returns2 = StringProblems.centerFindPalindromeSubStrings(s);

        assertEquals(palindromes.size(), returns.size());
        for (String p : palindromes) {
            assertTrue(returns.contains(p));
            assertTrue(returns2.contains(p));
        }

    }

    @Test
    @DisplayName("word break basic test")
    void wordBreakBasicTest() {
        List<String> dict = Arrays.asList(
                "i", "like", "samsung", "apple", "pen", "cat", "ball",
                "cats", "smoke", "and", "man", "go", "mango");

        String s = "ilikesamsung";
        assertTrue(StringProblems.wordBreak(s, dict));

        s = "iiiiiiii";
        assertTrue(StringProblems.wordBreak(s, dict));

        s = "";
        assertTrue(StringProblems.wordBreak(s, dict));

        s = "samsungandmango";
        assertTrue(StringProblems.wordBreak(s, dict));

        s = "applepenapple";
        assertTrue(StringProblems.wordBreak(s, dict));

        s = "samsungandmangok";
        assertFalse(StringProblems.wordBreak(s, dict));

        s = "appleandp";
        assertFalse(StringProblems.wordBreak(s, dict));
    }

}