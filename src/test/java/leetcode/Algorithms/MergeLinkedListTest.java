package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeLinkedListTest {
    @Test
    @DisplayName("basic test")
    void basicTest() {
        MergeLinkedList.ListNode list1 = makeLinkedList(new int[]{1, 2, 4});
        MergeLinkedList.ListNode list2 = makeLinkedList(new int[]{1, 3, 4});
        int [] result = makeList(MergeLinkedList.mergeTwoLists(list1, list2));
        assertArrayEquals(new int[]{1, 1, 2, 3, 4, 4}, result);

        list1 = makeLinkedList(new int[]{1, 2, 4});
        list2 = makeLinkedList(new int[]{1, 3, 4});
        result = makeList(MergeLinkedList.mergeTwoLists(list1, list2));
        assertArrayEquals(new int[]{1, 1, 2, 3, 4, 4}, result);
    }

    public static MergeLinkedList.ListNode makeLinkedList(int[] list) {
        if (list.length == 0) {
            return null;
        }
        MergeLinkedList.ListNode head = new MergeLinkedList.ListNode(list[0]);
        MergeLinkedList.ListNode temp = head;

        for (int i = 1; i < list.length; i++, temp = temp.next) {
            temp.next = new MergeLinkedList.ListNode(list[i]);
        }

        return head;
    }

    public static int[] makeList(MergeLinkedList.ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        for (;head != null; head = head.next) {
            list.add(head.val);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}