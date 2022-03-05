package common25;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}