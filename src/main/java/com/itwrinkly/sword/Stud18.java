package com.itwrinkly.sword;

import lombok.*;

/**
 * 在O(1)的时间复杂度内删除节点
 * 给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间内删除该节点
 */
public class Stud18 {
    public static void main(String[] args) {
        //构建单向链表
        Node18 a = new Node18("a");
        Node18 b = new Node18("b");
        Node18 c = new Node18("c");
        Node18 d = new Node18("d");

//        a.setNext(b);
//        b.setNext(c);
//        c.setNext(d);
        Node18 head = a;

        deleteNode(head, a);
        print(head);
    }

    private static void print(Node18 head) {
        if (head == null) return;
        Node18 node = head;
        while (node != null) {
            System.out.println(node.getVal());
            node = node.getNext();
        }
    }

    private static void deleteNode(Node18 head, Node18 delNode) {
        if (head == null || delNode == null) return;
        Node18 delNext = delNode.getNext();
        if (delNext != null) {
            delNode.setVal(delNext.getVal());
            delNode.setNext(delNext.getNext());
        } else if (head == delNode) {
            head.setVal("null");
            head.setNext(null);
            delNode.setVal("null");
            delNode.setNext(null);
        } else {
            Node18 node = head;
            while (!node.getNext().getVal().equals(delNode.getVal())) {
                node = node.getNext();
            }
            node.setNext(null);
        }
    }
}

@Data
@RequiredArgsConstructor
class Node18 {
    @NonNull
    private String val;
    private Node18 next;
}
