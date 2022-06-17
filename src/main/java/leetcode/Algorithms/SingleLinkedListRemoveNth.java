package leetcode.Algorithms;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * Given the head of a linked list, remove the nth node from
 * the end of the list and return its head.
 *
 * Constraints:
 *
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class SingleLinkedListRemoveNth {
    public static SingleLinkedListMid.ListNode removeNthFromEnd(SingleLinkedListMid.ListNode head, int n) {
        SingleLinkedListMid.ListNode current = head;
        SingleLinkedListMid.ListNode prev = null;

        int count = 0;
        for (; current != null; count++, current = current.next);

        n = count - n;
        if (n == 0) {
            return head.next;
        }

        current = head;
        for (int i = 0; i < n; i++) {
            prev = current;
            current = current.next;
        }
        prev.next = current.next;

        return head;
    }
}
