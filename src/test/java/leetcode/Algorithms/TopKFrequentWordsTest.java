package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopKFrequentWordsTest {
    @Test
    @DisplayName("basic tests")
    void basicTests() {
        TopKFrequentWords obj = new TopKFrequentWords();

        String [] words = new String[] {"i","love","leetcode","i","love","coding"};
        int k = 2;
        assertArrayEquals(new String[] {"i", "love"}, obj.topKFrequent(words, k).toArray());

        words = new String[] {"a", "b", "b", "c", "c"};
        k = 2;
        assertArrayEquals(new String[] {"b", "c"},obj.topKFrequent(words, k).toArray());

        words = new String[] {"the","day","is","sunny","the","the","the","sunny","is","is"};
        k = 4;
        assertArrayEquals(new String[] {"the","is","sunny","day"},obj.topKFrequent(words, k).toArray());
    }
}