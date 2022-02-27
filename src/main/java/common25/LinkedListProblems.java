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
    public static Node sumTwoIntegers(Node num1, Node num2) {
        Node ret = new Node();
        Node result = ret;
        Node prev = null;
        Node h1 = num1;
        Node h2 = num2;
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
    public static Node deepCopyLinkedList(Node head) {
        for(Node h = head; h != null;) {
            Node n = new Node();
            n.setDigit(h.getDigit());
            Node next = h.getNext();
            h.setNext(n);
            n.setNext(next);
            h = next;
        }

        for (Node h = head; h != null; ) {
            if (h.getRandomNext() != null) {
                h.getNext().setRandomNext(h.getRandomNext().getNext());
            }
            h = h.getNext().getNext();
        }

        Node ret = head.getNext();

        for (Node h = head, r = ret; h != null; ) {
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
}

class Node{
    private int digit;
    private Node next = null;
    private Node randomNext = null;
    public Node setDigit(int n) {
        this.digit = n;
        return this;
    }
    public int getDigit(){
        return this.digit;
    }
    public Node createNext() {
        this.next = new Node();
        return this.next;
    }
    public Node createRandomNext(){
        this.randomNext = new Node();
        return this.randomNext;
    }
    public Node getNext() {
        return this.next;
    }
    public void setNext(Node n) {
        this.next = n;
    }
    public Node getRandomNext() {
        return this.randomNext;
    }
    public void setRandomNext(Node n) {
        this.randomNext = n;
    }
}
