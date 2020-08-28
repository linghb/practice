package com.itwrinkly.sword;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 不分行从上到下打印二叉树
 */
public class Stud32 {

    public static void main(String[] args) {

        BTreeNode32 root = new BTreeNode32(8);
        BTreeNode32 six = new BTreeNode32(6);
        BTreeNode32 ten = new BTreeNode32(10);
        BTreeNode32 five = new BTreeNode32(5);
        BTreeNode32 seven = new BTreeNode32(7);
        BTreeNode32 night = new BTreeNode32(9);
        BTreeNode32 one = new BTreeNode32(1);

        root.setLeft(six);
        root.setRight(ten);
        six.setLeft(five);
        six.setRight(seven);
        ten.setLeft(night);
        ten.setRight(one);

        // 题一：不分行从上到下打印二叉树
        //printFromToDown(root);

        // 题二：分行从上到下打印二叉树
        //printLineFromToDown(root);

        // 题三：之字形 打印二叉树
        printZigZagFromToDown(root);
    }

    private static void printZigZagFromToDown(BTreeNode32 root) {
        if (root == null) return;
        int current = 0;
        int next = 1;
        Stack<BTreeNode32>[] stacks = new Stack[2];
        stacks[0] = new Stack<>();
        stacks[1] = new Stack<>();
        stacks[0].push(root);
        while (!stacks[0].isEmpty() || !stacks[1].isEmpty()) {
            BTreeNode32 node = stacks[current].pop();
            System.out.print(node.getVal() + ",");
            if (current == 0) {
                if (node.getLeft() != null) {
                    stacks[next].push(node.getLeft());
                }

                if (node.getRight() != null) {
                    stacks[next].push(node.getRight());
                }
            } else if (current == 1) {
                if (node.getRight() != null) {
                    stacks[next].push(node.getRight());
                }
                if (node.getLeft() != null) {
                    stacks[next].push(node.getLeft());
                }
            }

            if (stacks[current].isEmpty()) {
                System.out.println();
                next = current;
                current = 1 - current;
                //next = 1 - next;
            }
        }
    }

    private static void printFromToDown(BTreeNode32 root) {
        if (root == null) return;
        Queue<BTreeNode32> queue = new ArrayBlockingQueue<BTreeNode32>(100);
        queue.offer(root);
        while (! queue.isEmpty()) {
            BTreeNode32 node = queue.poll();
            System.out.print(node.getVal() + ",");
            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.offer(node.getRight());
            }
        }
    }

    private static void printLineFromToDown(BTreeNode32 root) {
        if (root == null) return;
        Queue<BTreeNode32> queue = new ArrayBlockingQueue<BTreeNode32>(100);
        queue.offer(root);
        int nextPrints = 0;
        int toBePrint = 1;
        while (! queue.isEmpty()) {
            BTreeNode32 node = queue.peek();
            System.out.print(node.getVal() + ",");
            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
                nextPrints++;
            }
            if (node.getRight() != null) {
                queue.offer(node.getRight());
                nextPrints++;
            }

            queue.poll();
            toBePrint--;
            if (toBePrint == 0) {
                System.out.println();
                toBePrint = nextPrints;
                nextPrints = 0;
            }

        }
    }
}

@Data
@RequiredArgsConstructor
class BTreeNode32 {
    @NonNull
    private int val;
    private BTreeNode32 left;
    private BTreeNode32 right;
}
