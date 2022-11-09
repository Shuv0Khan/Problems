package common25;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class TreeProblemsTest {

    public TreeProblems.TNode createTree(Integer[] a) {
        TreeProblems.TNode root = new TreeProblems.TNode(a[0]);
        TreeProblems.TNode n = root;

        for (int i = 1; i < a.length; i++) {
            if (a[i] == null) {
                TreeProblems.TNode b = new TreeProblems.TNode(-2);
                b.parent = n;
                n.branches.add(b);
                n = b;
            } else if (a[i] == -1) {
                n = n.parent;
            } else {
                TreeProblems.TNode b = new TreeProblems.TNode(a[i]);
                b.parent = n;
                n.branches.add(b);
                n = b;
            }
        }

        Queue<TreeProblems.TNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            n = q.remove();
            for (int i = 0; i < n.branches.size(); i++) {
                if (n.branches.get(i).digit == -2) {
                    n.branches.set(i, null);
                } else {
                    q.add(n.branches.get(i));
                }
            }
        }

        return root;
    }

    @Test
    @DisplayName("tree height basic test")
    void treeHeightBasicTest() {
        Integer [] a = new Integer[]{100, 50, 25, 27, -1, -1, 75, -1, -1, 200, 350};
        TreeProblems.TNode root = createTree(a);
        assertEquals(4, TreeProblems.height(root));

        a = new Integer[]{1, 2, 5, -1, -1, 3, -1, 4, 6, -1, 7, 8};
        root = createTree(a);
        assertEquals(4, TreeProblems.height(root));

        a = new Integer[]{1, 2, 3};
        root = createTree(a);
        assertEquals(3, TreeProblems.height(root));

        a = new Integer[]{1, 2, -1, 3, 4};
        root = createTree(a);
        assertEquals(3, TreeProblems.height(root));

        a = new Integer[]{1};
        root = createTree(a);
        assertEquals(1, TreeProblems.height(root));

        a = new Integer[]{1, 2, 3, -1, 4, 5};
        root = createTree(a);
        assertEquals(4, TreeProblems.height(root));
    }

    @Test
    @DisplayName("level order print queue basic test")
    void levelOrderPrintQueueBasicTest() {
        Integer [] a = new Integer[]{100, 50, 25, 27, -1, -1, 75, -1, -1, 200, 350};
        TreeProblems.TNode root = createTree(a);
        TreeProblems.levelOrderQueueBased(root);
        System.out.println("*************************************************");

        a = new Integer[]{1, 2, 5, -1, -1, 3, -1, 4, 6, -1, 7, 8};
        root = createTree(a);
        TreeProblems.levelOrderQueueBased(root);
        System.out.println("*************************************************");

        a = new Integer[]{1, 2, 3};
        root = createTree(a);
        TreeProblems.levelOrderQueueBased(root);
        System.out.println("*************************************************");

        a = new Integer[]{1, 2, -1, 3, 4};
        root = createTree(a);
        TreeProblems.levelOrderQueueBased(root);
        System.out.println("*************************************************");

        a = new Integer[]{1};
        root = createTree(a);
        TreeProblems.levelOrderQueueBased(root);
        System.out.println("*************************************************");

        a = new Integer[]{1, 2, 3, -1, 4, 5};
        root = createTree(a);
        TreeProblems.levelOrderQueueBased(root);
    }

    @Test
    @DisplayName("level order recursion basic test")
    void levelOrderRecursionBasicTest() {
        Integer [] a = new Integer[]{100, 50, 25, 27, -1, -1, 75, -1, -1, 200, 350};
        TreeProblems.TNode root = createTree(a);
        TreeProblems.levelOrderRecursion(root);
        System.out.println("*************************************************");

        a = new Integer[]{1, 2, 5, -1, -1, 3, -1, 4, 6, -1, 7, 8};
        root = createTree(a);
        TreeProblems.levelOrderRecursion(root);
        System.out.println("*************************************************");

        a = new Integer[]{1, 2, 3};
        root = createTree(a);
        TreeProblems.levelOrderRecursion(root);
        System.out.println("*************************************************");

        a = new Integer[]{1, 2, -1, 3, 4};
        root = createTree(a);
        TreeProblems.levelOrderRecursion(root);
        System.out.println("*************************************************");

        a = new Integer[]{1};
        root = createTree(a);
        TreeProblems.levelOrderRecursion(root);
        System.out.println("*************************************************");

        a = new Integer[]{1, 2, 3, -1, 4, 5};
        root = createTree(a);
        TreeProblems.levelOrderRecursion(root);
    }

    @Test
    @DisplayName("connect siblings basic test")
    void connectSiblingsBasicTest() {
        Integer [][] a = new Integer[][]{
                {100, 50, 25, 27, -1, -1, 75, -1, -1, 200, 350},
                {1, 2, 5, -1, -1, 3, -1, 4, 6, -1, 7, 8},
                {1, 2, 3},
                {1, 2, -1, 3, 4},
                {1},
                {1, 2, 3, -1, 4, 5}
        };
        String[] siblings = new String[]{
                "10050200257535027",
                "12345678",
                "123",
                "1234",
                "1",
                "12345"
        };

        for (int i = 0; i < a.length; i++) {
            TreeProblems.TNode root = createTree(a[i]);
            TreeProblems.TNode ret = TreeProblems.connectSiblings(root);
            TreeProblems.TNode n = ret;
            String s = "";
            while (n != null) {
                s += n.digit;
                n = n.sibling;
            }
            assertEquals(siblings[i], s);
        }
    }

    @Test
    @DisplayName("check binary tree symmetry basic test")
    void checkBinaryTreeSymmetryBasicTest() {
        Integer [][] a = new Integer[][]{
                {10,9,8,1,null,-1,null,-1,-1,null,-1,-1,8,null,-1,1,null,-1,null,-1,-1,-1,-1,9,8,1,null,-1,null,-1,-1,null,-1,-1,8,null,-1,1,null,-1,null},
                {10,9,8,1,null,-1,null,-1,-1,null,-1,-1,8,null,-1,null,-1,-1,-1,9,8,null,-1,null,-1,-1,8,null,-1,1,null,-1,null},
                {10,9,8,1,null,-1,null,-1,-1,null,-1,-1,8,null,-1,null,-1,-1,-1,9,null,-1,8,null,-1,1,null,-1,null},
                {8,1,null,-1,null,-1,-1,9,null,-1,8,null,-1,1,null,-1,null}
        };
        boolean[] symmetry = new boolean[]{
                true, true, false, false
        };

        for (int i = 0; i < a.length; i++) {
            TreeProblems.TNode root = createTree(a[i]);
            assertEquals(symmetry[i], TreeProblems.isSymmetrical(root));
        }
    }

}