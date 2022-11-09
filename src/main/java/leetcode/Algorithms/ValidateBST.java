package leetcode.Algorithms;

import common25.TreeProblems;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Input: root = [2,1,3]
 * Output: true
 *
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 10^4].
 * -2^31 <= Node.val <= 2^31 - 1
 */
public class ValidateBST {
    public static boolean isValidBST(TreeProblems.TNode root) {
        Integer[] prevVal = new Integer[]{null};
        Boolean isValid = inorder(root, prevVal);
        return isValid;
    }

    private static boolean inorder(TreeProblems.TNode node, Integer[] prevVal) {
        if (node == null) {
            return true;
        }

        TreeProblems.TNode n = (node.branches.size() < 1)? null : node.branches.get(0);
        boolean isValid = inorder(n, prevVal) && (prevVal[0] == null || prevVal[0] < node.digit);
        prevVal[0] = node.digit;
        n = (node.branches.size() < 2)? null : node.branches.get(1);
        return isValid && inorder(n, prevVal);
    }
}
