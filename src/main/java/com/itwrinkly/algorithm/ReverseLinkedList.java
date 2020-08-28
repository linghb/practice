package com.itwrinkly.algorithm;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 1、反转整个链表
 * 2、反转前N个元素链表
 * 3、反转从前M 到 N个元素链表
 */
public class ReverseLinkedList {

            private static LinkedNode successor = null;

            public static void main(String[] args) {
                //构建单向链表
                LinkedNode a = new LinkedNode("1");
                LinkedNode b = new LinkedNode("2");
                LinkedNode c = new LinkedNode("3");
                LinkedNode d = new LinkedNode("4");

                a.setNext(b);
                b.setNext(c);
                c.setNext(d);

                LinkedNode head = a;
                LinkedNode node = null;
                //第一题：方法一，递归翻转单向链表
                //node = recurReverse(head);

                //第一题：方法二：循环翻转
                //node = loopReverse(head);

                //第二题：反转前N个元素链表
                //int n = 5;
                //node = reverseN(head, n);

                //第三题：反转从前M 到 N个元素链表
                //int n = 4; int m = 2;
                //node = reverseMtoN(head, m , n);

                //第四题：k个一组翻转链表，不足k个保持原样
                int k = 2;
                node = reverseKGroup(head, k);

                while (node != null) {
                    System.out.println("node val:" + node.getVal());
                    node = node.getNext();
                }
            }

            private static LinkedNode reverseKGroup(LinkedNode head, int k) {
                if (head == null || head.getNext() == null) return head;
                // 区间 [first, second) 包含 k 个待反转元素
                LinkedNode first, second;
                first = second = head;
                for (int i = 0; i < k; i++) {
                    if (second == null) return head;
                    second = second.getNext();
                }
                LinkedNode newHead = loopReverse(first, second);
                first.setNext(reverseKGroup(second, k));
                return newHead;
            }

            private static LinkedNode loopReverse(LinkedNode first, LinkedNode second) {
                LinkedNode pre = null;
                LinkedNode cur = first;
                LinkedNode next = first;
                while ( cur != second) {
                    next = cur.getNext();
                    cur.setNext(pre);
                    pre = cur;
                    cur = next;
                }
                return pre;
            }

            private static LinkedNode reverseMtoN(LinkedNode head, int m, int n) {
                if (head.getNext() == null) return head;
                if (m == 1) {
                    return reverseN(head, n);
                }
                head.setNext(reverseMtoN(head.getNext(), m - 1, n -1));
                return head;
            }

            private static LinkedNode reverseN(LinkedNode head, int n) {
                if (head.getNext() == null) return head;
                if (n == 1) {
                    successor = head.getNext();
                    return head;
                }
                LinkedNode last = reverseN(head.getNext(), n - 1);
                head.getNext().setNext(head);
                head.setNext(successor);
                return last;
            }

            private static LinkedNode loopReverse(LinkedNode head) {
                if (head.getNext() == null) return head;
                LinkedNode newHead = null;
                while (head != null) {
                    LinkedNode temp = head.getNext();
                    head.setNext(newHead);
                    newHead = head;
                    head = temp;
                }
                return newHead;
            }

            private static LinkedNode recurReverse(LinkedNode head) {
                if (head.getNext() == null) return head;
                LinkedNode last = recurReverse(head.getNext());
                head.getNext().setNext(head);
                head.setNext(null);
                return last;
            }
}

@Data
@RequiredArgsConstructor
class LinkedNode {
    @NonNull
    private String val;
    private LinkedNode next;
}
