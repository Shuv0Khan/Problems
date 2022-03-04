package common25;

/**
 * Source - https://www.educative.io/blog/microsoft-interview-coding-questions
 *
 * Learnings -
 * problem 1 -
 *      1. Always hand-simulate for corner cases before starting to code.
 *      2. OOP Basics reminder - Node.next and obj points to the same object,
 *      but setting obj=null doesn't make Node.next = null
 */
public class LinkedListProblems {

    /**
     * <b>4. Add two integers
     * <br>
     * Problem Statement:</b> Given the head pointers of two linked lists
     * where each linked list represents an integer number (each node is a digit),
     * add them and return the resulting linked list. In the example below,
     * the first node in a list represents the least significant digit.
     *
     * @param num1 Head of linked list of the first number
     * @param num2 Head of linked list of the second number
     * @return Node - the head of linked list with the sum
     */
    public static LNode sumTwoIntegers(LNode num1, LNode num2) {
        LNode ret = new LNode();
        LNode result = ret;
        LNode prev = null;
        LNode h1 = num1;
        LNode h2 = num2;
        int carry = 0;
        int nullCount = 0;
        while (nullCount != 2) {
            nullCount = 0;
            int n1 = 0;
            int n2 = 0;
            if (h1 != null) {
                n1 = h1.getDigit();
                h1 = h1.getNext();
            } else {
                nullCount++;
            }
            if (h2 != null) {
                n2 = h2.getDigit();
                h2 = h2.getNext();
            } else {
                nullCount++;
            }
            int sum = n1 + n2 + carry;
            result.setDigit(sum % 10);
            carry = sum / 10;
            if (nullCount != 2) {
                prev = result;
                result = result.createNext();
            }
        }

        prev.setNext(null);

        return ret;
    }

    /**
     * <b>5. Copy linked list with arbitrary pointer
     * <br>
     * Problem Statement:</b> You are given a linked list where
     * the node has two pointers. The first is the regular next pointer.
     * The second pointer is called arbitrary_pointer,
     * and it can point to any node in the linked list.
     *
     * Here, deep copy means that any operations on the original list
     * (inserting, modifying, and removing) should not affect the copied list.
     *
     * @param head the linked list to copy
     * @return head of the copied link list
     */
    public static LNode deepCopyLinkedList(LNode head) {
        for(LNode h = head; h != null;) {
            LNode n = new LNode();
            n.setDigit(h.getDigit());
            LNode next = h.getNext();
            h.setNext(n);
            n.setNext(next);
            h = next;
        }

        for (LNode h = head; h != null; ) {
            if (h.getRandomNext() != null) {
                h.getNext().setRandomNext(h.getRandomNext().getNext());
            }
            h = h.getNext().getNext();
        }

        LNode ret = head.getNext();

        for (LNode h = head, r = ret; h != null; ) {
            h.setNext(h.getNext().getNext());
            if (h.getNext() == null) {
                r.setNext(null);
            } else {
                r.setNext(h.getNext().getNext());
            }
            h = h.getNext();
            r = r.getNext();
        }

        return ret;
    }

    /**
     * <b>6. Merge two sorted linked lists
     * <br.
     * Problem Statement:</b> Write a function that takes two sorted linked lists
     * and merges them. The function should return a single, sorted list made from
     * splicing the nodes of the first two lists together.
     *
     * For example, if the first linked list is 1 -> 2 -> 4 and
     * the second linked list is 3 -> 5 -> 6, then
     * the output would be 1 -> 2 -> 3 -> 4 -> 5 -> 6
     *
     * @param head1 first linked list
     * @param head2 second linked list
     * @return the merged linked list in sorted order
     */
    public static LNode mergeSortedLinkedLists(LNode head1, LNode head2) {
        LNode ret = new LNode();
        LNode prev = ret;
        LNode h1 = head1, h2 = head2, r = ret;

        for (; h1 != null && h2 != null; ) {
            if (h1.getDigit() < h2.getDigit()) {
                r.setDigit(h1.getDigit());
                h1 = h1.getNext();
            } else {
                r.setDigit(h2.getDigit());
                h2 = h2.getNext();
            }
            r.createNext();
            prev = r;
            r = r.getNext();
        }

        LNode h = null;
        if (h1 != null) {
            h = h1;
        } else if (h2 != null) {
            h = h2;
        } else {
            prev.setNext(null);
            return ret;
        }

        for (r = prev.getNext(); h != null; h = h.getNext()) {
            r.setDigit(h.getDigit());
            prev = r;
            r.createNext();
            r = r.getNext();
        }

        prev.setNext(null);
        return ret;
    }
}

class LNode {
    private int digit;
    private LNode next = null;
    private LNode randomNext = null;
    public LNode setDigit(int n) {
        this.digit = n;
        return this;
    }
    public int getDigit(){
        return this.digit;
    }
    public LNode createNext() {
        this.next = new LNode();
        return this.next;
    }
    public LNode createRandomNext(){
        this.randomNext = new LNode();
        return this.randomNext;
    }
    public LNode getNext() {
        return this.next;
    }
    public void setNext(LNode n) {
        this.next = n;
    }
    public LNode getRandomNext() {
        return this.randomNext;
    }
    public void setRandomNext(LNode n) {
        this.randomNext = n;
    }
}
