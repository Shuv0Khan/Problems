package common25;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

    @Test
    @DisplayName("maze traversal basic test")
    void mazeTraversalBasicTest() {
        int [][] maze = {
                {1, 1, 1},
                {0, 1, 1},
                {0, 0, 1}
        };
        assertEquals(2, BacktrackingProblems.mazeTraversal(maze));

        maze = new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        assertEquals(12, BacktrackingProblems.mazeTraversal(maze));
    }

    @Test
    @DisplayName("Test name")
    void testName() {
        List<Integer> l = new ArrayList<>();
        l.add(4);
        l.add(1);
        l.add(3);
        l.sort(Comparator.naturalOrder());
        System.out.println(l);
    }
}