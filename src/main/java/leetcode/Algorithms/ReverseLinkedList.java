package leetcode.Algorithms;

/**
 * https://leetcode.com/problems/reverse-linked-list
 *
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 * Input: head = [1,2]
 * Output: [2,1]
 *
 * Input: head = []
 * Output: []
 */
public class ReverseLinkedList {
    public static MergeLinkedList.ListNode reverseList(MergeLinkedList.ListNode head) {
        int len = 0;
        for(MergeLinkedList.ListNode temp = head; temp != null; temp = temp.next) {
            len++;
        }

        if (len < 2) {
            return head;
        }

        MergeLinkedList.ListNode node1 = head;
        MergeLinkedList.ListNode node2 = head.next;
        MergeLinkedList.ListNode node3 = head.next.next;

        for (node1.next = null; node2 != null;) {
            node2.next = node1;
            node1 = node2;
            node2 = node3;
            if (node3 != null) {
                node3 = node3.next;
            }
        }
        return node1;
    } 
}
