package com.itwrinkly.sword;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 合并两个有序单向链表
 */
public class Stud25 {

    public static void main(String[] args) {
        //构造单向有序链表
        Node25 one = new Node25(1);
        Node25 three = new Node25(3);
        Node25 five = new Node25(5);
        Node25 seven = new Node25(7);

        one.setNext(three);
        three.setNext(five);
        five.setNext(seven);

        Node25 headOne = one;

        Node25 two = new Node25(2);
        Node25 four = new Node25(4);
        Node25 six = new Node25(6);

        two.setNext(four);
        four.setNext(six);

        Node25 headTwo = two;

        Node25 newHead = mergList(headOne, headTwo);
        while (newHead != null) {
            System.out.println("val:" + newHead.getVal());
            newHead = newHead.getNext();
        }

    }

    private static Node25 mergList(Node25 one, Node25 two) {
        if (one == null)  return two;
        if (two == null) return one;

        Node25 mergHead = null;
        if (one.getVal() < two.getVal()) {
            mergHead = one;
            mergHead.setNext(mergList(one.getNext(), two));
        } else {
            mergHead = two;
            mergHead.setNext(mergList(one, two.getNext()));
        }
        return mergHead;
    }
}

@Data
@RequiredArgsConstructor
class Node25 {
    @NonNull
    private int val;
    private Node25 next;
}
