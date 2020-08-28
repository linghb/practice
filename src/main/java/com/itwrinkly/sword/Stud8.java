package com.itwrinkly.sword;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 二叉树的下一个节点
 * 给定一棵二叉树和其中的节点，如何找出中序遍历的下一个节点？
 * 树中节点除了有两个分别指向左右子节点的指针，还有一个指向父节点的指针
 * 中序遍历: {d,b,h,e,i,a,f,c,g}
 */
public class Stud8 {
    static BTreeNode8 tree;
    static BTreeNode8 curr;
    public static void main(String[] args) {
        initBTree();
        BTreeNode8 node = findNext(tree, curr);
        System.out.println("node:" + node.getVal());
    }

    private static BTreeNode8 findNext(BTreeNode8 tree, BTreeNode8 curr) {
        if (tree == null || curr == null) return null;
        BTreeNode8 curRight = curr.getRight();
        if (curRight != null) {
            BTreeNode8 node = curRight;
            while (node.getLeft() != null) {
                node = node.getLeft();
            }
            return node;
        } else {
            BTreeNode8 parent = curr.getParent();
            while (parent != null &&
                    (parent.getRight() != null && parent.getRight().getVal().equals(curr.getVal())) ) {
                curr = parent;
                parent = curr.getParent();
            }
            return parent;

        }
    }

    private static void initBTree() {
        BTreeNode8 h = new BTreeNode8("h", null, null, null);
        BTreeNode8 i = new BTreeNode8("i", null, null, null);
        BTreeNode8 e = new BTreeNode8("e", h, i, null);
        h.setParent(e);
        i.setParent(e);

        BTreeNode8 d = new BTreeNode8("d", null, null, null);
        BTreeNode8 b = new BTreeNode8("b", d, e, null);
        e.setParent(b);
        d.setParent(b);

        BTreeNode8 f = new BTreeNode8("f", null, null, null);
        BTreeNode8 g = new BTreeNode8("g", null, null, null);
        BTreeNode8 c = new BTreeNode8("c", f, g, null);
        f.setParent(c);
        g.setParent(c);

        BTreeNode8 a = new BTreeNode8("a", b, c, null);
        b.setParent(a);
        c.setParent(a);
        tree = a;
        curr = i;
    }
}

@Data
@AllArgsConstructor
class BTreeNode8 {
    private String val;
    private BTreeNode8 left;
    private BTreeNode8 right;
    private BTreeNode8 parent;
}
