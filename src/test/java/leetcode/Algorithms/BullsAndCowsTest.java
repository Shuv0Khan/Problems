package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BullsAndCowsTest {
    @Test
    @DisplayName("basic tests")
    void basicTests() {
        BullsAndCows obj = new BullsAndCows();

        String secret = "9305";
        String[] guesses = new String[]{"1234", "5678", "9012", "9087", "1087", "9205", "9305"};
        String[] returns = new String[]{"0A1B", "0A1B", "1A1B", "1A1B", "0A1B", "3A0B", "4A0B"};

        for (int i = 0; i < guesses.length; i++) {
            assertEquals(returns[i], obj.getHint(secret, guesses[i]));
        }

        assertEquals("1A3B", obj.getHint("1807", "7810"));
        assertEquals("1A1B", obj.getHint("1123", "0111"));
        assertEquals("3A0B", obj.getHint("1122", "1222"));

    }
}