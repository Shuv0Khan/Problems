package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleLinkedListMidTest {
    @Test
    @DisplayName("basic test")
    void basicTest() {
        int [] nums = new int[]{1,2,3,4,5};
        SingleLinkedListMid.ListNode head = new SingleLinkedListMid.ListNode(nums[0]);
        SingleLinkedListMid.ListNode temp = head;
        for (int i = 1; i < nums.length; i++, temp = temp.next) {
            temp.next = new SingleLinkedListMid.ListNode(nums[i]);
        }
        assertEquals(3, SingleLinkedListMid.middleNode(head).val);

        nums = new int[]{1,2,3,4,5,6};
        head = new SingleLinkedListMid.ListNode(nums[0]);
        temp = head;
        for (int i = 1; i < nums.length; i++, temp = temp.next) {
            temp.next = new SingleLinkedListMid.ListNode(nums[i]);
        }
        assertEquals(4, SingleLinkedListMid.middleNode(head).val);
    }
}