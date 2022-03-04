package common25;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListProblemsTest {
    @Test
    @DisplayName("sum two linked lists numbers basic test")
    void sumTwoLinkedListsNumbersBasicTest() {
        LNode num1 = new LNode();
        num1.setDigit(1).createNext().setDigit(0).createNext().setDigit(9).createNext().setDigit(9);

        LNode num2 = new LNode();
        num2.setDigit(7).createNext().setDigit(3).createNext().setDigit(2);

        LNode result = new LNode();
        result.setDigit(8).createNext().setDigit(3).createNext().setDigit(1).createNext().setDigit(0).createNext().setDigit(1);

        LNode ret = LinkedListProblems.sumTwoIntegers(num1, num2);
        while (ret != null) {
            assertEquals(result.getDigit(), ret.getDigit());
            result = result.getNext();
            ret = ret.getNext();
        }

        num1 = new LNode();
        num1.setDigit(9);
        num2 = new LNode();
        num2.setDigit(0);
        result = new LNode();
        result.setDigit(9);

        ret = LinkedListProblems.sumTwoIntegers(num1, num2);
        while (ret != null) {
            assertEquals(result.getDigit(), ret.getDigit());
            result = result.getNext();
            ret = ret.getNext();
        }

        num1 = new LNode();
        num1.setDigit(9);
        num2 = new LNode();
        num2.setDigit(2).createNext().setDigit(1);
        result = new LNode();
        result.setDigit(1).createNext().setDigit(2);

        ret = LinkedListProblems.sumTwoIntegers(num1, num2);
        while (ret != null) {
            assertEquals(result.getDigit(), ret.getDigit());
            result = result.getNext();
            ret = ret.getNext();
        }

        num1 = new LNode();
        num1.setDigit(9);
        num2 = new LNode();
        num2.setDigit(2);
        result = new LNode();
        result.setDigit(1).createNext().setDigit(1);

        ret = LinkedListProblems.sumTwoIntegers(num1, num2);
        while (ret != null) {
            assertEquals(result.getDigit(), ret.getDigit());
            result = result.getNext();
            ret = ret.getNext();
        }

        num1 = new LNode();
        num1.setDigit(9);
        num2 = new LNode();
        num2.setDigit(2).createNext().setDigit(9);
        result = new LNode();
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
            LNode num1 = new LNode();
            LNode num2 = new LNode();
            LNode result = new LNode();

            int n = n1;
            num1.setDigit(n%10);
            n = n/10;
            LNode num = num1;
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

            LNode ret = LinkedListProblems.sumTwoIntegers(num1, num2);
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
        LNode head = new LNode();
        head.setDigit(7).createNext().setDigit(14).createNext().setDigit(21);
        head.setRandomNext(head.getNext().getNext());
        head.getNext().setRandomNext(null);
        head.getNext().getNext().setRandomNext(head);

        String nextChainDigits = "71421";
        String randomChainDigits = "21null7";

        LNode result = LinkedListProblems.deepCopyLinkedList(head);
        String resultNextChainDigits = "";
        String resultRandomChainDigits = "";

        for(LNode h = result; h != null; h = h.getNext()) {
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

            LNode[] list = new LNode[rand.nextInt(10)+10];
            list[0] = new LNode();
            for (int j = 0; j < list.length - 1; j++) {
                list[j].setDigit(rand.nextInt(100));
                list[j+1] = new LNode();
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

            LNode result = LinkedListProblems.deepCopyLinkedList(list[0]);
            String resultNextChainDigits = "";
            String resultRandomChainDigits = "";

            for(LNode h = result; h != null; h = h.getNext()) {
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

            LNode head1 = new LNode();
            LNode head2 = new LNode();
            LNode h = head1;
            LNode prev = null;

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

            LNode merged = LinkedListProblems.mergeSortedLinkedLists(head1, head2);
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