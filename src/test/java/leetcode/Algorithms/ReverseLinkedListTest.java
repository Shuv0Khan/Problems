package leetcode.Algorithms;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReverseLinkedListTest {
    @Test
    @DisplayName("basic test")
    void basicTest() {
        MergeLinkedList.ListNode list = MergeLinkedListTest.makeLinkedList(new int[]{1,2,3,4,5});
        assertArrayEquals(new int[] {5, 4, 3, 2, 1}, MergeLinkedListTest.makeList(ReverseLinkedList.reverseList(list)));

        list = MergeLinkedListTest.makeLinkedList(new int[]{1,2});
        assertArrayEquals(new int[] {2, 1}, MergeLinkedListTest.makeList(ReverseLinkedList.reverseList(list)));

        list = MergeLinkedListTest.makeLinkedList(new int[]{});
        assertArrayEquals(new int[] {}, MergeLinkedListTest.makeList(ReverseLinkedList.reverseList(list)));
    }
}