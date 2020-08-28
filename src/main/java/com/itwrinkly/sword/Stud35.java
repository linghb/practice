package com.itwrinkly.sword;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * 复杂链表的复制
 */
public class Stud35 {

    public static void main(String[] args) {
        ComplexListNode a = new ComplexListNode(1);
        ComplexListNode b = new ComplexListNode(2);
        ComplexListNode c = new ComplexListNode(3);
        ComplexListNode d = new ComplexListNode(4);
        ComplexListNode e = new ComplexListNode(5);
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);

        a.setSibling(c);
        b.setSibling(e);
        d.setSibling(b);
        ComplexListNode copy = CopyComplex(a);
    }

    private static ComplexListNode CopyComplex(ComplexListNode head) {
        if (head == null || head.getNext() == null ) return head;
        return copyNode(head);
    }

    private static ComplexListNode copyNode(ComplexListNode head) {
        if (head == null) return null;
        ComplexListNode node = head;
        while (node != null) {
            ComplexListNode tmp = new ComplexListNode(node.getVal());
            tmp.setNext(node.getNext());
            node.setNext(tmp);
            node = node.getNext().getNext();
        }
        //printNode(head);
        copySibling(head);
        ComplexListNode stripHead = strip(head);
        printNode(stripHead);
        return stripHead;
    }

    private static ComplexListNode strip(ComplexListNode head) {
        if (head == null) return null;
        ComplexListNode stripHead = head.getNext();
        ComplexListNode stripNode = stripHead;
        ComplexListNode node = head;
        while (node != null) {
            if (node.getNext() != null) {
                node.setNext(node.getNext().getNext());
                node = node.getNext();
            }
            if (stripNode.getNext() != null) {
                stripNode.setNext(stripNode.getNext().getNext());
                stripNode = stripNode.getNext();
            }
        }
        return stripHead;
    }

    private static void copySibling(ComplexListNode head) {
        if (head == null) return;
        ComplexListNode node = head;
        while (node != null) {
            ComplexListNode slibing = node.getSibling();
            if (slibing != null) {
                node.getNext().setSibling(slibing.getNext());
            }
            node = node.getNext().getNext();
        }
    }

    private static void printNode(ComplexListNode head) {
        //print new ListNode
        ComplexListNode newNode = head;
        while (newNode != null) {
            System.out.println("ndoe:" + newNode.getVal() + " slibing:" + (newNode.getSibling() != null ? newNode.getSibling().getVal() : "null")) ;
            newNode = newNode.getNext();
        }
    }

}

@Data
@RequiredArgsConstructor
@ToString(exclude = {"next", "sibling"})
class ComplexListNode {
    @NonNull
    private int val;
    private ComplexListNode next;
    private ComplexListNode sibling;
}
