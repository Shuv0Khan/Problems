package common25;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListProblemsTest {
    @Test
    @DisplayName("sum two linked lists numbers basic test")
    void sumTwoLinkedListsNumbersBasicTest() {
        Node num1 = new Node();
        num1.setDigit(1).createNext().setDigit(0).createNext().setDigit(9).createNext().setDigit(9);

        Node num2 = new Node();
        num2.setDigit(7).createNext().setDigit(3).createNext().setDigit(2);

        Node result = new Node();
        result.setDigit(8).createNext().setDigit(3).createNext().setDigit(1).createNext().setDigit(0).createNext().setDigit(1);

        Node ret = LinkedListProblems.sumTwoIntegers(num1, num2);
        while (ret != null) {
            assertEquals(result.getDigit(), ret.getDigit());
            result = result.getNext();
            ret = ret.getNext();
        }

        num1 = new Node();
        num1.setDigit(9);
        num2 = new Node();
        num2.setDigit(0);
        result = new Node();
        result.setDigit(9);

        ret = LinkedListProblems.sumTwoIntegers(num1, num2);
        while (ret != null) {
            assertEquals(result.getDigit(), ret.getDigit());
            result = result.getNext();
            ret = ret.getNext();
        }

        num1 = new Node();
        num1.setDigit(9);
        num2 = new Node();
        num2.setDigit(2).createNext().setDigit(1);
        result = new Node();
        result.setDigit(1).createNext().setDigit(2);

        ret = LinkedListProblems.sumTwoIntegers(num1, num2);
        while (ret != null) {
            assertEquals(result.getDigit(), ret.getDigit());
            result = result.getNext();
            ret = ret.getNext();
        }

        num1 = new Node();
        num1.setDigit(9);
        num2 = new Node();
        num2.setDigit(2);
        result = new Node();
        result.setDigit(1).createNext().setDigit(1);

        ret = LinkedListProblems.sumTwoIntegers(num1, num2);
        while (ret != null) {
            assertEquals(result.getDigit(), ret.getDigit());
            result = result.getNext();
            ret = ret.getNext();
        }

        num1 = new Node();
        num1.setDigit(9);
        num2 = new Node();
        num2.setDigit(2).createNext().setDigit(9);
        result = new Node();
        result.setDigit(1).createNext().setDigit(0).createNext().setDigit(1);

        ret = LinkedListProblems.sumTwoIntegers(num1, num2);
        while (ret != null) {
            assertEquals(result.getDigit(), ret.getDigit());
            result = result.getNext();
            ret = ret.getNext();
        }
    }

    @Test
    @DisplayName("sum two linked list numbers 100 random test")
    void sumTwoLinkedListNumbers100RandomTest() {
        Random rand = new Random();
        for(int i = 0; i < 100; i++) {
            int n1 = Math.abs(rand.nextInt(100000));
            int n2 = Math.abs(rand.nextInt(100000));
            int sum = n1 + n2;
            System.out.println("n1: "+n1+", n2: "+n2+", sum: "+sum);
            Node num1 = new Node();
            Node num2 = new Node();
            Node result = new Node();

            int n = n1;
            num1.setDigit(n%10);
            n = n/10;
            Node num = num1;
            for (; n > 0;) {
                num = num.createNext().setDigit(n%10);
                n = n/10;
            }

            n = n2;
            num2.setDigit(n%10);
            n = n/10;
            num = num2;
            for (; n > 0;) {
                num = num.createNext().setDigit(n%10);
                n = n/10;
            }

            n = sum;
            result.setDigit(n%10);
            n = n/10;
            num = result;
            for (; n > 0;) {
                num = num.createNext().setDigit(n%10);
                n = n/10;
            }

            Node ret = LinkedListProblems.sumTwoIntegers(num1, num2);
            while (ret != null) {
                assertEquals(result.getDigit(), ret.getDigit());
                result = result.getNext();
                ret = ret.getNext();
            }
        }
    }

    @Test
    @DisplayName("deep copy linked list basic tests")
    void deepCopyLinkedListBasicTests() {
        Node head = new Node();
        head.setDigit(7).createNext().setDigit(14).createNext().setDigit(21);
        head.setRandomNext(head.getNext().getNext());
        head.getNext().setRandomNext(null);
        head.getNext().getNext().setRandomNext(head);

        String nextChainDigits = "71421";
        String randomChainDigits = "21null7";

        Node result = LinkedListProblems.deepCopyLinkedList(head);
        String resultNextChainDigits = "";
        String resultRandomChainDigits = "";

        for(Node h = result; h != null; h = h.getNext()) {
            resultNextChainDigits+=h.getDigit();
            if (h.getRandomNext() == null) {
                resultRandomChainDigits += "null";
            } else {
                resultRandomChainDigits += h.getRandomNext().getDigit();
            }
        }

        assertEquals(nextChainDigits, resultNextChainDigits);
        assertEquals(randomChainDigits, resultRandomChainDigits);
    }

    @Test
    @DisplayName("deep copy linked list random test")
    void deepCopyLinkedListRandomTest() {
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            String nextChainDigits = "";
            String randomChainDigits = "";

            Node[] list = new Node[rand.nextInt(10)+10];
            list[0] = new Node();
            for (int j = 0; j < list.length - 1; j++) {
                list[j].setDigit(rand.nextInt(100));
                list[j+1] = new Node();
                list[j].setNext(list[j+1]);
                nextChainDigits += list[j].getDigit();
            }
            list[list.length - 2].setNext(null);

            for (int j = 0, l = list.length - 2; j < l; j++) {
                int index = rand.nextInt(l);
                list[j].setRandomNext(list[index]);
                randomChainDigits += list[index].getDigit();
            }
            randomChainDigits+="null";

            Node result = LinkedListProblems.deepCopyLinkedList(list[0]);
            String resultNextChainDigits = "";
            String resultRandomChainDigits = "";

            for(Node h = result; h != null; h = h.getNext()) {
                resultNextChainDigits+=h.getDigit();
                if (h.getRandomNext() == null) {
                    resultRandomChainDigits += "null";
                } else {
                    resultRandomChainDigits += h.getRandomNext().getDigit();
                }
            }

            assertEquals(nextChainDigits, resultNextChainDigits);
            assertEquals(randomChainDigits, resultRandomChainDigits);
        }

    }

    @Test
    @DisplayName("merge sorted linked list basic test")
    void mergeSortedLinkedListBasicTest() {
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int[] a1 = new int[rand.nextInt(10)+1];
            int[] a2 = new int[rand.nextInt(10)+1];

            for (int j = 0; j < a1.length; j++) {
                a1[j] = rand.nextInt(100);
            }
            for (int j = 0; j < a2.length; j++) {
                a2[j] = rand.nextInt(100);
            }

            Arrays.sort(a1);
            Arrays.sort(a2);

            Node head1 = new Node();
            Node head2 = new Node();
            Node h = head1;
            Node prev = null;

            for (int j = 0; j < a1.length; j++) {
                prev = h;
                h = h.setDigit(a1[j]).createNext();
            }
            prev.setNext(null);

            h = head2;
            prev = null;
            for (int j = 0; j < a2.length; j++) {
                prev = h;
                h = h.setDigit(a2[j]).createNext();
            }
            prev.setNext(null);

            Node merged = LinkedListProblems.mergeSortedLinkedLists(head1, head2);
            h = merged;
            while (h.getNext() != null) {
                if (h.getDigit() > h.getNext().getDigit()) {
                    fail("Not Sorted");
                }
                h = h.getNext();
            }
        }
    }

}