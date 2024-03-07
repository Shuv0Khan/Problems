package leetcode.Algorithms;

import java.util.ArrayDeque;
import java.util.Queue;

public class ValidateBinaryTree {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        if (n == 1) {
            return true;
        }
        /*
        cycle detection in directed graph
        bfs with visited set. if the current node is already in visited set then invalid
        */
        int [] visited = new int[n];
        Queue<Integer> Q = new ArrayDeque<>();

        /* 0 is not the root.
        to find the root use the property that root doesn't have any parent
         */
        // count parents
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                visited[leftChild[i]]++;
            }
            if (rightChild[i] != -1) {
                visited[rightChild[i]]++;
            }
        }
        //find and count roots or nodes with more than one parent
        int root = 0;
        int numOfRoots = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] != 1) {
                root = i;
                numOfRoots++;
            }
            visited[i] = 0;
        }

        if (numOfRoots != 1) {
            // either more than one root (forest) or one node with more than one parent
            return false;
        }

        // BFS to detect cycles
        Q.add(root);
        while(!Q.isEmpty()){
            int v = Q.remove();
            if (visited[v] == 1) {
                return false;
            }
            if (leftChild[v] != -1){
                Q.add(leftChild[v]);
            }
            if (rightChild[v] != -1) {
                Q.add(rightChild[v]);
            }

            visited[v] = 1;
        }

        // check if all the nodes have been used
        for (int i = 0; i < n; i++) {
            if (visited[i] != 1) {
                return false;
            }
        }

        return true;
    }
}
