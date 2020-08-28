package com.itwrinkly.algorithm;

/**
 * 巩固基本算法
 */
public class AlgorithmRandom {

    private static LinkedNode successor = null;
    private static LinkedNode head = null;

    public static void main(String[] args) {
        //构建单向链表
        LinkedNode a = new LinkedNode("1");
        LinkedNode b = new LinkedNode("2");
        LinkedNode c = new LinkedNode("3");
        LinkedNode d = new LinkedNode("4");
        LinkedNode e = new LinkedNode("5");

        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);

        head = a;

        //链表翻转（循环和递归）
        //reverseLinked();
        //k group翻转链表
        LinkedNode node = reverseKGroup(head, 2);
        while (node != null) {
            System.out.println("node val:" + node.getVal());
            node = node.getNext();
        }
    }

    private static LinkedNode reverseKGroup(LinkedNode head, int k) {
        if (head == null || head.getNext() == null) return head;
        LinkedNode first, second;
        first = second = head;
        for (int i = 1; i <= k; i++) {
            if (second == null) return head;
            second = second.getNext();
        }
        LinkedNode newHead = loopReverse(first, second);
        first.setNext(reverseKGroup(second, k));
        return newHead;
    }

    private static void reverseLinked() {


        //LinkedNode pre = loopReverse(a);
        //LinkedNode pre = recurReverse(a);
        LinkedNode pre = recurReverseN(head, 3);

        LinkedNode node = pre;
        while (node != null) {
            System.out.println("node val:" + node.getVal());
            node = node.getNext();
        }
    }

    private static LinkedNode recurReverse(LinkedNode head) {
        if (head.getNext() == null) return head;
        LinkedNode last = recurReverse(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return last;
    }

    //翻转前N个元素
    private static LinkedNode recurReverseN(LinkedNode head, int n) {
        if (head.getNext() == null) return head;
        if (n == 1) {
            successor = head.getNext();
            return head;
        }
        LinkedNode last = recurReverseN(head.getNext(), n - 1);
        head.getNext().setNext(head);
        head.setNext(successor);
        return last;
    }

    //翻转从第M到N的元素
    private static LinkedNode recurReverseMtoN(LinkedNode head, int m, int n) {
        if (head.getNext() == null) return head;
        if (m == 1) {
            return recurReverseN(head, n);
        }
        //LinkedNode last = recurReverseMtoN(head.getNext(), m - 1, n - 1);
        head.setNext(recurReverseMtoN(head.getNext(), m - 1, n - 1));
        return head;
    }

    private static LinkedNode loopReverse(LinkedNode a) {
        LinkedNode head = a;
        LinkedNode pre = null;
        LinkedNode cur = head;
        LinkedNode next = head;

        while (cur != null) {
            next = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private static LinkedNode loopReverse(LinkedNode a, LinkedNode b) {
        LinkedNode head = a;
        LinkedNode pre = null;
        LinkedNode cur = head;
        LinkedNode next = head;

        while (cur != b) {
            next = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
