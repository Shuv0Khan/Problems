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
}

class Node{
    private int digit;
    private Node next = null;
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
    public Node getNext() {
        return this.next;
    }
    public void setNext(Node n) {
        this.next = n;
    }
}
