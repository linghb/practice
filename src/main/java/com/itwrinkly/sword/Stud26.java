package com.itwrinkly.sword;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class Stud26 {

    public static void main(String[] args) {

        //构造二叉搜索树
        BTreeNode26 root1 = new BTreeNode26(8);
        BTreeNode26 left1 = new BTreeNode26(8);
        BTreeNode26 right1 = new BTreeNode26(7);
        BTreeNode26 left2 = new BTreeNode26(9);
        BTreeNode26 right2 = new BTreeNode26(2);
        BTreeNode26 left3 = new BTreeNode26(4);
        BTreeNode26 right3 = new BTreeNode26(7);

        root1.setLeft(left1);
        root1.setRight(right1);
        left1.setLeft(left2);
        left1.setRight(right2);
        right2.setLeft(left3);
        right2.setRight(right3);

        BTreeNode26 root2 = new BTreeNode26(8);
        BTreeNode26 one = new BTreeNode26(9);
        BTreeNode26 two = new BTreeNode26(2);
        root2.setLeft(one);
        root2.setRight(two);

        boolean isSubTree = subTree(root1, root2);

        System.out.println();
    }

    private static boolean subTree(BTreeNode26 root1, BTreeNode26 root2) {
        boolean isSubTree = false;
        if (root1 != null && root2 != null) {
            if (root1.getVal() == root2.getVal()) {
                isSubTree = furtherSubTree(root1, root2);
            }

            if (!isSubTree) {
                isSubTree = subTree(root1.getLeft(), root2);
            }

            if (!isSubTree) {
                isSubTree = subTree(root1.getRight(), root2);
            }
        }

        return isSubTree;
    }

    private static boolean furtherSubTree(BTreeNode26 root1, BTreeNode26 root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.getVal() != root2.getVal()) return false;
        return subTree(root1.getLeft(), root2.getLeft()) &&
                subTree(root1.getRight(), root2.getRight());
    }
}

@Data
@RequiredArgsConstructor
class BTreeNode26 {
    @NonNull
    private int val;
    private BTreeNode26 left;
    private BTreeNode26 right;
}