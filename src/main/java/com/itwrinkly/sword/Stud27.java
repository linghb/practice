package com.itwrinkly.sword;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


public class Stud27 {

    public static void main(String[] args) {

        BTreeNode27 root = new BTreeNode27(8);
        BTreeNode27 six = new BTreeNode27(6);
        BTreeNode27 ten = new BTreeNode27(10);
        BTreeNode27 five = new BTreeNode27(5);
        BTreeNode27 seven = new BTreeNode27(7);
        BTreeNode27 nine = new BTreeNode27(9);
        BTreeNode27 eleve = new BTreeNode27(11);

        root.setLeft(six);
        root.setRight(ten);
        six.setLeft(five);
        six.setRight(seven);
        ten.setLeft(nine);
        ten.setRight(eleve);

        print(root);
        mirrorBTree(root);
        System.out.println("----------");
        print(root);
    }

    private static void print(BTreeNode27 root) {
        if (root == null) return;
        System.out.println("node val:" + root.getVal());
        print(root.getLeft());
        print(root.getRight());

    }

    private static void mirrorBTree(BTreeNode27 root) {
        if (root == null) return;
        //System.out.println("ndoe val:" + root.getVal());
        BTreeNode27 tmp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(tmp);
        mirrorBTree(root.getLeft());
        mirrorBTree(root.getRight());
    }
}

@Data
@RequiredArgsConstructor
class BTreeNode27 {
    @NonNull
    private int val;
    private BTreeNode27 left;
    private BTreeNode27 right;
}
