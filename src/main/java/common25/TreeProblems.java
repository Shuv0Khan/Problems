package common25;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

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
}

class TNode{
    int digit = 0;
    TNode parent = null;
    ArrayList<TNode> branches = new ArrayList<>();
    public TNode(int d) {
        this.digit = d;
    }
}
