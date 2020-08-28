package com.itwrinkly.sword;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 输入某二叉树的前序遍历和中序的结果，请重建该二叉树
 * 例如：前序遍历: {1,2,4,7,3,5,6,8} 后序遍历：{4,7,2,1,5,3,8,6}
 */
public class Stud7 {
    static int[] preOrders = new int[]{1,2,4,7,3,5,6,8};
    static int[] inOrders = new int[]{4,7,2,1,5,3,8,6};
    public static void main(String[] args) {
        BinaryTreeNode seven = new BinaryTreeNode(7, null, null);
        BinaryTreeNode root = rebuildBTree();
        System.out.println("root:" + root);

    }

    private static BinaryTreeNode rebuildBTree() {
        if (preOrders == null || inOrders == null || preOrders.length <= 0) return null;
        return build(0, preOrders.length - 1, 0, inOrders.length - 1);
    }

    private static BinaryTreeNode build(int startPre, int endPre, int startIn, int endIn) {
        BinaryTreeNode root = new BinaryTreeNode(preOrders[startPre], null, null);
        if (startPre == endPre) {
            if (startIn == endIn && preOrders[startPre] == inOrders[startIn]) {
                return root;
            } else {
                throw new RuntimeException("invalid input");
            }
        }
        int rootInOrder = startIn;
        while (rootInOrder <= endIn && preOrders[startPre] != inOrders[rootInOrder]) {
            rootInOrder++;
        }

        if (rootInOrder == endIn && preOrders[startPre] != inOrders[rootInOrder])
            throw new RuntimeException("invalid input");

        int leftLen = rootInOrder - startIn;
        if (leftLen > 0) {
            System.out.println("startPre+1:" + (startPre + 1) + " endPre:" + (startPre + leftLen) + " startIn:" + startIn + " endIn:" + (rootInOrder - 1));
            root.setLeft(build(startPre + 1, startPre + leftLen, startIn, rootInOrder - 1));
        }

        if (leftLen < endPre - startPre) {
            root.setRight(build(startPre + leftLen + 1, endPre, rootInOrder + 1, endIn));
        }
        return root;
    }
}

//        BinaryTreeNode four = new BinaryTreeNode(4, null, seven);
//        BinaryTreeNode two = new BinaryTreeNode(2, four, null);
//        BinaryTreeNode five = new BinaryTreeNode(5, null, null);
//        BinaryTreeNode eight = new BinaryTreeNode(8, null, null);
//        BinaryTreeNode six = new BinaryTreeNode(6, eight, null);
//        BinaryTreeNode three = new BinaryTreeNode(3, five, six);
//        BinaryTreeNode node = new BinaryTreeNode(1, two, three);
@Data
@AllArgsConstructor
class BinaryTreeNode {
    private int val;
    private BinaryTreeNode left;
    private BinaryTreeNode right;
}
