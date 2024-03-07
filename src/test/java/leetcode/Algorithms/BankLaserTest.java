package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankLaserTest {
    @Test
    @DisplayName("basic test")
    void basicTest() {
        assertEquals(8, new BankLaser().numberOfBeams(new String[]{"011001","000000","010100","001000"}));
        assertEquals(0, new BankLaser().numberOfBeams(new String[]{"000","111","000"}));
    }
}