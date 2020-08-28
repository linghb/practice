package com.itwrinkly.sword;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 链表中倒数第k个节点
 */
public class Stud22 {

    public static void main(String[] args) {
        //构建单向链表
        Node22 a = new Node22("a");
        Node22 b = new Node22("b");
        Node22 c = new Node22("c");
        Node22 d = new Node22("d");
        Node22 e = new Node22("e");
        Node22 f = new Node22("f");

        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        e.setNext(f);

        Node22 head = a;
        int k = 3;
        Node22 node = findKthToTheLast(head, k);
        System.out.println("node:" + node.getVal());
    }

    private static Node22 findKthToTheLast(Node22 head, int k) {
        if (head == null || k <= 0) return null;
        Node22 first = head;
        Node22 second = head;
        for (int i = 0; i < k - 1; i++) {
            if (second.getNext() != null) {
                second = second.getNext();
            } else {
                return null;
            }

        }

        while (second.getNext() != null) {
            first = first.getNext();
            second = second.getNext();
        }
        return first;
    }
}

@Data
@RequiredArgsConstructor
class Node22 {
    @NonNull
    private String val;
    private Node22 next;
}


