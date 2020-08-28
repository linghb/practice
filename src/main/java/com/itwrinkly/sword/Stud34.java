package com.itwrinkly.sword;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中和为某一路径的值
 */
public class Stud34 {

    public static void main(String[] args) {
        BTreeNode34 root = new BTreeNode34(10);
        BTreeNode34 five = new BTreeNode34(5);
        BTreeNode34 twe = new BTreeNode34(12);
        BTreeNode34 four = new BTreeNode34(4);
        BTreeNode34 seven = new BTreeNode34(7);

        root.setLeft(five);
        root.setRight(twe);
        five.setLeft(four);
        five.setRight(seven);

        List<Integer> elems = new ArrayList<>();
        int sum = 22;
        pathForSum(root, elems, sum);
    }

    private static void pathForSum(BTreeNode34 root, List<Integer> elems, int sum) {
        elems.add(root.getVal());
        if (root.getLeft() == null && root.getRight() == null
                && (sum - root.getVal()) == 0) {
            System.out.println("find path:" + elems);
        }

        if (root.getLeft() != null) {
            pathForSum(root.getLeft(), elems, sum - root.getVal());
        }
        if (root.getRight() != null) {
            pathForSum(root.getRight(), elems, sum - root.getVal());
        }
        elems.remove(elems.size() - 1);
    }
}


@Data
@RequiredArgsConstructor
class BTreeNode34 {
    @NonNull
    private int val;
    private BTreeNode34 left;
    private BTreeNode34 right;
}
