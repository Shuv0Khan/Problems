package leetcode.Algorithms;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 * <p>
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [1, 100].
 * 1 <= Node.val <= 100
 */
public class SingleLinkedListMid {
    public static ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int count = 0;
        for (; temp != null; temp = temp.next, count++);

        int mid = count / 2;

        temp = head;
        for (int i = 0; i < mid; i++, temp = temp.next);

        return temp;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}



