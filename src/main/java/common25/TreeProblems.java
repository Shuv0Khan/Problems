package common25;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Source - https://www.educative.io/blog/microsoft-interview-coding-questions
 *
 */
public class TreeProblems {
    public static int height(TNode n) {
        if (n.branches.size() == 0) {
            /*
             * shuvo - 2022-03-2, Wed, 14:49
             * leaf node
             **/
            return 1;
        }
        int max = 0;
        for (int i = 0, l = n.branches.size(); i < l; i++) {
            int h = height(n.branches.get(i));
            if (h > max) {
                max = h;
            }
        }
        return 1 + max;
    }

    /**
     * <b>7. Level order traversal of tree
     * <br>
     * Problem Statement: </b>Given the root of a tree, display the node values at each level.<br>
     * 100<br>
     * 50, 20<br>
     * 25, 75, 350<br>
     * Done with the BFS approach using queue.
     * @param root the root of the tree
     */
    public static void levelOrderQueueBased(TNode root) {
        Queue<TNode> q = new ArrayDeque<>();
        q.add(root);
        int currentLevelCount = 1;
        int nextLevelCount = 0;

        while (!q.isEmpty()) {
            TNode n = q.remove();
            for (int i = 0; i < n.branches.size(); i++) {
                q.add(n.branches.get(i));
            }
            nextLevelCount += n.branches.size();
            System.out.print(n.digit+" ");
            currentLevelCount--;

            if (currentLevelCount == 0) {
                System.out.print("\n");
                currentLevelCount = nextLevelCount;
                nextLevelCount = 0;
            }
        }

    }

    /**
     * Done with recursion upto the height
     * @param root
     */
    public static void levelOrderRecursion(TNode root) {
        int h = height(root);
        for (int i = 0; i < h; i++) {
            printLevel(root, i);
            System.out.print("\n");
        }
    }

    private static void printLevel(TNode n, int level) {
        if (level == 0) {
            System.out.print(n.digit+" ");
            return;
        }
        for (int i = 0; i < n.branches.size(); i++) {
            printLevel(n.branches.get(i), level - 1);
        }
    }

    public static TNode connectSiblings(TNode root) {
        Queue<TNode> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            TNode n = q.remove();
            for (int i = 0, l = n.branches.size(); i < l; i++) {
                q.add(n.branches.get(i));
            }
            n.sibling = q.peek();
        }

        return root;
    }

    /**
     * <b>9. Check a given binary tree for symmetry
     * <br>
     * Problem Statement:</b> Given a binary tree, write a program
     * that will return true if the binary tree is a mirror
     * image of itself, and false if it is not.
     * <br>
     * The correct output given this binary tree would be true because it is symmetrical.
     * @param root root of the binary tree
     * @return true if the tree is symmetrical, false otherwise.
     */
    public static boolean isSymmetrical(TNode root) {

        if (root.branches.size() == 0) return true;

        if (root.branches.get(0) != null &&
                root.branches.get(1) != null) {
            String left = symmetryCheck(root.branches.get(0));
            String right = symmetryCheck(root.branches.get(1));

            return left.equals(reverse(right));
        }

        return false;
    }

    /**
     * Reverses a comma seperated string
     * @param csv the comma separated string
     * @return reverse of the string in csv format
     */
    private static String reverse(String csv) {
        String[] parts = csv.split(",");
        if (parts.length < 2) {
            return csv;
        }
        String s = parts[parts.length - 1];
        for (int i = parts.length - 2; i > -1; i--) {
            s += ","+parts[i];
        }
        return s;
    }

    private static String symmetryCheck(TNode n) {
        if (n.branches.get(0) != null && n.branches.get(1) != null) {
            String left = symmetryCheck(n.branches.get(0));
            String right = symmetryCheck(n.branches.get(1));
            return left + "," + n.digit + "," + right;
        } else if (n.branches.get(0) != null) {
            return symmetryCheck(n.branches.get(0)) + "," + n.digit;
        } else if (n.branches.get(1) != null) {
            return n.digit + "," + symmetryCheck(n.branches.get(1));
        } else {
            return Integer.toString(n.digit);
        }
    }
}

class TNode{
    int digit = 0;
    TNode parent = null;
    TNode sibling = null;
    ArrayList<TNode> branches = new ArrayList<>();
    public TNode(int d) {
        this.digit = d;
    }
}
