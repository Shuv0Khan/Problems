package common25;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeProblemsTest {

    TNode createTree(int[] a) {
        TNode root = new TNode(a[0]);
        TNode n = root;

        for (int i = 1; i < a.length; i++) {
            if (a[i] == -1) {
                n = n.parent;
            } else {
                TNode b = new TNode(a[i]);
                b.parent = n;
                n.branches.add(b);
                n = b;
            }
        }

        return root;
    }

    @Test
    @DisplayName("tree height basic test")
    void treeHeightBasicTest() {
        int [] a = new int[]{100, 50, 25, 27, -1, -1, 75, -1, -1, 200, 350};
        TNode root = createTree(a);
        assertEquals(4, TreeProblems.height(root));

        a = new int[]{1, 2, 5, -1, -1, 3, -1, 4, 6, -1, 7, 8};
        root = createTree(a);
        assertEquals(4, TreeProblems.height(root));

        a = new int[]{1, 2, 3};
        root = createTree(a);
        assertEquals(3, TreeProblems.height(root));

        a = new int[]{1, 2, -1, 3, 4};
        root = createTree(a);
        assertEquals(3, TreeProblems.height(root));

        a = new int[]{1};
        root = createTree(a);
        assertEquals(1, TreeProblems.height(root));

        a = new int[]{1, 2, 3, -1, 4, 5};
        root = createTree(a);
        assertEquals(4, TreeProblems.height(root));
    }

    @Test
    @DisplayName("level order print queue basic test")
    void levelOrderPrintQueueBasicTest() {
        int [] a = new int[]{100, 50, 25, 27, -1, -1, 75, -1, -1, 200, 350};
        TNode root = createTree(a);
        TreeProblems.levelOrderQueueBased(root);
        System.out.println("*************************************************");

        a = new int[]{1, 2, 5, -1, -1, 3, -1, 4, 6, -1, 7, 8};
        root = createTree(a);
        TreeProblems.levelOrderQueueBased(root);
        System.out.println("*************************************************");

        a = new int[]{1, 2, 3};
        root = createTree(a);
        TreeProblems.levelOrderQueueBased(root);
        System.out.println("*************************************************");

        a = new int[]{1, 2, -1, 3, 4};
        root = createTree(a);
        TreeProblems.levelOrderQueueBased(root);
        System.out.println("*************************************************");

        a = new int[]{1};
        root = createTree(a);
        TreeProblems.levelOrderQueueBased(root);
        System.out.println("*************************************************");

        a = new int[]{1, 2, 3, -1, 4, 5};
        root = createTree(a);
        TreeProblems.levelOrderQueueBased(root);
    }

    @Test
    @DisplayName("level order recursion basic test")
    void levelOrderRecursionBasicTest() {
        int [] a = new int[]{100, 50, 25, 27, -1, -1, 75, -1, -1, 200, 350};
        TNode root = createTree(a);
        TreeProblems.levelOrderRecursion(root);
        System.out.println("*************************************************");

        a = new int[]{1, 2, 5, -1, -1, 3, -1, 4, 6, -1, 7, 8};
        root = createTree(a);
        TreeProblems.levelOrderRecursion(root);
        System.out.println("*************************************************");

        a = new int[]{1, 2, 3};
        root = createTree(a);
        TreeProblems.levelOrderRecursion(root);
        System.out.println("*************************************************");

        a = new int[]{1, 2, -1, 3, 4};
        root = createTree(a);
        TreeProblems.levelOrderRecursion(root);
        System.out.println("*************************************************");

        a = new int[]{1};
        root = createTree(a);
        TreeProblems.levelOrderRecursion(root);
        System.out.println("*************************************************");

        a = new int[]{1, 2, 3, -1, 4, 5};
        root = createTree(a);
        TreeProblems.levelOrderRecursion(root);
    }

    @Test
    @DisplayName("connect siblings basic test")
    void connectSiblingsBasicTest() {
        int [][] a = new int[][]{
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
            TNode root = createTree(a[i]);
            TNode ret = TreeProblems.connectSiblings(root);
            TNode n = ret;
            String s = "";
            while (n != null) {
                s += n.digit;
                n = n.sibling;
            }
            assertEquals(siblings[i], s);
        }
    }

}