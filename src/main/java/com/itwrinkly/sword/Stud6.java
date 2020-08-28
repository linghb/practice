package com.itwrinkly.sword;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 从头到尾打印链表
 */
public class Stud6 {
    public static void main(String[] args) {
        LinkedNode empty = null;
        LinkedNode three = new LinkedNode(3, empty);
        LinkedNode two = new LinkedNode(2, three);
        LinkedNode one = new LinkedNode(1, two);
        LinkedNode head = one;

        recurPrint(head);
    }

    private static void recurPrint(LinkedNode head) {
        if (head != null) {
            if (head.getNext() != null) {
                recurPrint(head.getNext());
            }
            System.out.println("val:" + head.getVal());
        }
    }

}

class LinkedNode {
    private int val;
    private LinkedNode next;

    public LinkedNode(int val, LinkedNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }
}
