package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecodeStringTest {
    @Test
    @DisplayName("basic tests")
    void basicTests() {
        DecodeString obj = new DecodeString();

        String encoded = "3[a]2[bc]";
        String decoded = "aaabcbc";
        assertEquals(decoded, obj.decodeString(encoded));

        encoded = "3[a2[c]]";
        decoded = "accaccacc";
        assertEquals(decoded, obj.decodeString(encoded));

        encoded = "2[abc]3[cd]ef";
        decoded = "abcabccdcdcdef";
        assertEquals(decoded, obj.decodeString(encoded));

    }
}