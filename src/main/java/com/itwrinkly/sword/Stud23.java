package com.itwrinkly.sword;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 *链表中是否有环，如果有环找出其的入口节点
 */
public class Stud23 {

    public static void main(String[] args) {
        //构建单向链表
        Node23 a = new Node23("1");
        Node23 b = new Node23("2");
        Node23 c = new Node23("3");
        Node23 d = new Node23("4");
        Node23 e = new Node23("5");

        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
//        e.setNext(c);


        Node23 head = a;
        Node23 node = findLoopPort(head);
        System.out.println("port:" + node.getVal());
    }

    private static Node23 findLoopPort(Node23 head) {
        if (head == null || head.getNext() == null) return null;
        Node23 slow = head;
        Node23 fast = head;
        while (true) {
            if (fast == null || fast.getNext() == null) {
                return null;
            }
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if (slow == fast) {
                break;
            }
        }

        slow = head;
        while (slow != fast) {
            slow = slow.getNext();
            fast = fast.getNext();
        }
        return slow;
    }
}

@Data
@RequiredArgsConstructor
class Node23 {
    @NonNull
    private String val;
    private Node23 next;
}
