package leetcode.Algorithms;

import common25.TreeProblems.*;
import common25.TreeProblemsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateBSTTest {
    @Test
    @DisplayName("basic test")
    void basicTest() {
        Integer [] a = new Integer[]{5, 1, -1, 4, 3, -1, 6};
        TNode root = new TreeProblemsTest().createTree(a);
        assertFalse(ValidateBST.isValidBST(root));

        a = new Integer[]{1, 1};
        root = new TreeProblemsTest().createTree(a);
        assertFalse(ValidateBST.isValidBST(root));
    }
}