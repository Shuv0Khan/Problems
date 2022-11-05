package leetcode.Algorithms;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/description/
 *
 * Given the head of a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 *
 * There is a cycle in a linked list if there is some node in the list that
 * can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next
 * pointer is connected to (0-indexed). It is -1 if there is no cycle.
 * Note that pos is not passed as a parameter.
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 *
 * The number of the nodes in the list is in the range [0, 10^4].
 * -10^5 <= Node.val <= 10^5
 * pos is -1 or a valid index in the linked-list.
 */
public class LinkedListCycleII {
    public static MergeLinkedList.ListNode detectCycle(MergeLinkedList.ListNode head) {
        HashMap<MergeLinkedList.ListNode, Integer> visited = new HashMap<>();
        MergeLinkedList.ListNode temp = head;
        for (int i = 0; temp != null; temp = temp.next) {
            if (visited.get(temp) == null) {
                visited.put(temp, i);
            } else {
                return temp;
            }
        }
        return null;
    }

    /**
     * https://leetcode.com/problems/linked-list-cycle-ii/solutions/1701128/c-java-python-slow-and-fast-image-explanation-beginner-friendly/
     *
     * Slow Fast method. Slow moves one step at a time. Fast moves two steps at a time.
     * They meet on the cycle. The number of steps slow travelled is a multiple of
     * number of cycles travelled by fast.
     * @param head
     * @return
     */
    public static MergeLinkedList.ListNode leetcodeSolution(MergeLinkedList.ListNode head) {
        if (head == null) {
            return null;
        }

        MergeLinkedList.ListNode slow = head;
        MergeLinkedList.ListNode fast = head;
        do {
            if (slow.next == null) {
                return null;
            }
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);

        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}
