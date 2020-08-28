package com.itwrinkly.sword;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


public class Stud28 {

    public static void main(String[] args) {

        BTreeNode28 root = new BTreeNode28(8);
        BTreeNode28 one = new BTreeNode28(6);
        BTreeNode28 two = new BTreeNode28(6);
        BTreeNode28 three = new BTreeNode28(5);
        BTreeNode28 four = new BTreeNode28(7);
        BTreeNode28 five = new BTreeNode28(7);
        BTreeNode28 six = new BTreeNode28(5);

        root.setLeft(one);
        root.setRight(two);
        one.setLeft(three);
        one.setRight(four);
        two.setLeft(five);
        two.setRight(six);

        boolean isSym = isSymmetrical(root, root);
    }

    private static boolean isSymmetrical(BTreeNode28 root, BTreeNode28 root1) {
        if (root == null && root1 == null) return true;
        if (root == null || root1 == null) return false;
        if (root.getVal() != root1.getVal()) return false;
        return isSymmetrical(root.getLeft(), root1.getRight())
                && isSymmetrical(root.getRight(), root1.getLeft());
    }


    private static void print(BTreeNode28 root) {
        if (root == null) return;
        System.out.println("node val:" + root.getVal());
        print(root.getLeft());
        print(root.getRight());

    }


}

@Data
@RequiredArgsConstructor
class BTreeNode28 {
    @NonNull
    private int val;
    private BTreeNode28 left;
    private BTreeNode28 right;
}
