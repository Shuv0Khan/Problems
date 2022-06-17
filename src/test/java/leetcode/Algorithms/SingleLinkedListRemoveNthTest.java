package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SingleLinkedListRemoveNthTest {
    @Test
    @DisplayName("basic test")
    void basicTest() {
        int [] nums = new int[]{1,2,3,4,5};
        int [] ret = new int[]{1,2,3,5};
        SingleLinkedListMid.ListNode head = new SingleLinkedListMid.ListNode(nums[0]);
        SingleLinkedListMid.ListNode temp = head;
        for (int i = 1; i < nums.length; i++, temp = temp.next) {
            temp.next = new SingleLinkedListMid.ListNode(nums[i]);
        }
        head = SingleLinkedListRemoveNth.removeNthFromEnd(head, 2);
        for (int i = 0; i < ret.length; i++, head = head.next) {
            assertEquals(ret[i], head.val);
        }

        nums = new int[]{1,2,3,4,5};
        ret = new int[]{2,3,4,5};
        head = new SingleLinkedListMid.ListNode(nums[0]);
        temp = head;
        for (int i = 1; i < nums.length; i++, temp = temp.next) {
            temp.next = new SingleLinkedListMid.ListNode(nums[i]);
        }
        head = SingleLinkedListRemoveNth.removeNthFromEnd(head, 5);
        for (int i = 0; i < ret.length; i++, head = head.next) {
            assertEquals(ret[i], head.val);
        }
    }
}