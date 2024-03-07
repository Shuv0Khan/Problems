package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateBinaryTreeTest {
    @Test
    @DisplayName("basic test")
    void basicTest() {
        assertTrue(new ValidateBinaryTree().validateBinaryTreeNodes(4, new int[]{1,-1,3,-1}, new int[]{2,-1,-1,-1}));
        assertFalse(new ValidateBinaryTree().validateBinaryTreeNodes(4, new int[]{1,-1,3,-1}, new int[]{2,3,-1,-1}));
        assertFalse(new ValidateBinaryTree().validateBinaryTreeNodes(2, new int[]{1,0}, new int[]{-1,-1}));
        assertTrue(new ValidateBinaryTree().validateBinaryTreeNodes(4, new int[]{3,-1,1,-1}, new int[]{-1,-1,0,-1}));
        assertFalse(new ValidateBinaryTree().validateBinaryTreeNodes(6, new int[]{3,-1,1,-1,5,-1}, new int[]{-1,-1,0,-1,-1,-1}));
        assertFalse(new ValidateBinaryTree().validateBinaryTreeNodes(3, new int[]{-1,2,-1}, new int[]{-1,-1,-1}));
        assertFalse(new ValidateBinaryTree().validateBinaryTreeNodes(4, new int[]{1,0,3,-1}, new int[]{-1,-1,-1,-1}));
    }
}