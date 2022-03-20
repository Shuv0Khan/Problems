package common25;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BacktrackingProblemsTest {

    @Test
    @DisplayName("regex match basic test")
    void regexMatchBasicTest() {
        String [] regs = {
                "", "aaaaa", "aaaaa", "a*", "a*", "a*bc.*d", "a*bc.*d", "ab*bc.d*", "ab*bc.d*"
        };
        String [] inputs = {
                "", "aaaaa", "aaaab", "aaaaa", "aaaab", "aaaaabcccd", "bbcccd", "abcd", "abcde"
        };
        boolean [] results = {
                true, true, false, true, false, true, false, true, false
        };
        for (int i = 0; i < regs.length; i++) {
            assertEquals(results[i], BacktrackingProblems.regexMatch(regs[i], inputs[i]));
        }
    }

    @Test
    @DisplayName("regex match fsa basic test")
    void regexMatchFsaBasicTest() {
        String [] regs = {
                "", "aaaaa", "aaaaa", "a*", "a*", "a*bc.*d", "a*bc.*d", "ab*bc.d*", "ab*bc.d*"
        };
        String [] inputs = {
                "", "aaaaa", "aaaab", "aaaaa", "aaaab", "aaaaabcccd", "bbcccd", "abcd", "abcde"
        };
        boolean [] results = {
                true, true, false, true, false, true, false, true, false
        };
        for (int i = 0; i < regs.length; i++) {
            assertEquals(results[i], BacktrackingProblems.fsaMatch(regs[i], inputs[i]));
        }
    }
}