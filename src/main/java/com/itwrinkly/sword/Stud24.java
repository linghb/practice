package com.itwrinkly.sword;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 *反转链表
 *
 */
public class Stud24 {

    public static void main(String[] args) {
        //构建单向链表
        Node24 a = new Node24("1");
        Node24 b = new Node24("2");
        Node24 c = new Node24("3");
        Node24 d = new Node24("4");

        a.setNext(b);
        b.setNext(c);
        c.setNext(d);


        Node24 head = a;
        reverse(head);
    }

    private static void reverse(Node24 head) {
        if (head == null || head.getNext() == null) return;
        Node24 prev = null;
        Node24 cur = head;
        Node24 reverseHead = null;

        while (cur != null) {
            Node24 next = cur.getNext();
            if (next == null) reverseHead = cur;
            cur.setNext(prev);
            prev = cur;
            cur = next;
        }

        Node24 node = reverseHead;
        while (node != null) {
            System.out.println("reverse:" + node.getVal());
            node = node.getNext();
        }
    }

}

@Data
@RequiredArgsConstructor
class Node24 {
    @NonNull
    private String val;
    private Node24 next;
}
