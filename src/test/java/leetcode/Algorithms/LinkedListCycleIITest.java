package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListCycleIITest {
    @Test
    @DisplayName("basic test")
    void basicTest() {
        MergeLinkedList.ListNode head = MergeLinkedListTest.makeLinkedList(new int[]{3,2,0,-4});
        makeCycle(head, 1);
        assertEquals(1, getNodeIndex(head, LinkedListCycleII.detectCycle(head)));
        assertEquals(1, getNodeIndex(head, LinkedListCycleII.leetcodeSolution(head)));

        head = MergeLinkedListTest.makeLinkedList(new int[]{1,2});
        makeCycle(head, 0);
        assertEquals(0, getNodeIndex(head, LinkedListCycleII.detectCycle(head)));

        head = MergeLinkedListTest.makeLinkedList(new int[]{1});
        assertEquals(-1, getNodeIndex(head, LinkedListCycleII.detectCycle(head)));
    }

    public static void makeCycle(MergeLinkedList.ListNode head, int pos) {
        MergeLinkedList.ListNode temp = head;
        MergeLinkedList.ListNode start = null;
        MergeLinkedList.ListNode end = null;

        for (int i = 0; temp != null; i++, temp = temp.next) {
            if (pos == i) {
                start = temp;
            }
            end = temp;
        }
        end.next = start;
    }

    public static int getNodeIndex(MergeLinkedList.ListNode head, MergeLinkedList.ListNode search) {
        if (search == null) {
            return -1;
        }
        MergeLinkedList.ListNode temp = head;
        for(int i = 0; temp != null; i++, temp = temp.next) {
            if (temp == search) {
                return i;
            }
        }
        return -1;
    }
}