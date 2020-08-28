package com.itwrinkly.sword;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * 二叉搜索树与双向链表
 */
public class Stud36 {

    public static void main(String[] args) {
        BTreeNode36 root = new BTreeNode36(10);
        BTreeNode36 six = new BTreeNode36(6);
        BTreeNode36 fourteen = new BTreeNode36(14);
        BTreeNode36 four = new BTreeNode36(4);
        BTreeNode36 eight = new BTreeNode36(8);
        BTreeNode36 twelve = new BTreeNode36(12);
        BTreeNode36 sixteen = new BTreeNode36(16);

        root.setLeft(six);
        root.setRight(fourteen);

        six.setLeft(four);
        six.setRight(eight);

        fourteen.setLeft(twelve);
        fourteen.setRight(sixteen);

        BTreeNode36 head = convert(root);
        BTreeNode36 node = head;
        while (node != null) {
            System.out.println("node:" + node.getVal());
            node = node.getRight();
        }

    }

    private static BTreeNode36 convert(BTreeNode36 root) {
        BTreeNode36 pLastNodeList = null;
        pLastNodeList = convertListNode(root, pLastNodeList);
        BTreeNode36 pNodeHead = pLastNodeList;
        while (pNodeHead != null && pNodeHead.getLeft() != null) {
            pNodeHead = pNodeHead.getLeft();
        }
        return pNodeHead;
    }

    private static BTreeNode36 convertListNode(BTreeNode36 root, BTreeNode36 pLastNodeList) {
        if (root == null) return null;
        if (root.getLeft() != null) {
            pLastNodeList = convertListNode(root.getLeft(), pLastNodeList);
        }

        root.setLeft(pLastNodeList);
        if (pLastNodeList != null) {
            pLastNodeList.setRight(root);
        }
        pLastNodeList = root;
        if (root.getRight() != null) {
            pLastNodeList = convertListNode(root.getRight(), pLastNodeList);
        }
        return pLastNodeList;
    }
}

@Data
@RequiredArgsConstructor
@ToString(exclude = {"left", "right"})
class BTreeNode36 {
    @NonNull
    private int val;
    private BTreeNode36 left;
    private BTreeNode36 right;
}
