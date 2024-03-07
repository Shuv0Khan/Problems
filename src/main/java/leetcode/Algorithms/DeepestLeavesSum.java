package leetcode.Algorithms;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/problems/deepest-leaves-sum/
 * Given the root of a binary tree, return the sum of values of its deepest leaves.
 * <p>
 * <p>
 * Example 1:
 * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * Output: 15
 * <p>
 * Example 2:
 * Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * Output: 19
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 104].
 * 1 <= Node.val <= 100
 */
public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> bfs = new ArrayDeque<>();
        int levelSum = 0;
        bfs.add(root);
        while (!bfs.isEmpty()) {
            int noOfNodes = bfs.size();
            levelSum = 0;
            for (int i = 0; i < noOfNodes; i++) {
                TreeNode node = bfs.poll();
                levelSum += node.val;
                if (node.left != null) {
                    bfs.add(node.left);
                }
                if (node.right != null) {
                    bfs.add(node.right);
                }
            }
        }
        return levelSum;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
