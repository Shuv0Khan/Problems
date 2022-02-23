package common25;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}