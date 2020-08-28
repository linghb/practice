package com.itwrinkly.algorithm;

/**
 * 题目一：判定合法等式：给你一个数组 equations，装着若干字符串表示的算式。
 * 每个算式 equations[i] 长度都是 4，而且只有这两种情况：a==b 或者 a!=b，
 * 其中 a,b 可以是任意小写字母。你写一个算法，如果 equations 中所有算式都不会互相冲突，
 * 返回 true，否则返回 false
 *  比如说，输入 ["a==b","b!=c","c==a"]，算法返回 false，因为这三个算式不可能同时正确
 *  再比如，输入 ["c==c","b==d","x!=z"]，算法返回 true，因为这三个算式并不会造成逻辑冲突
 */
public class UnionFind {
    //记录联通分两个数
    private int count;
    //记录父节点
    private int[] parent;
    //记录树的重量
    private int[] size;

    public UnionFind(int n) {
        this.count = n;
        this.parent = new int[n];
        this.size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(26);
        String[] equations = {"a==b", "b!=c", "c==x"};
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                uf.union(x - 'a', y - 'a');
            }
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                if (uf.isConnected(x - 'a', y - 'a')) {
                    System.out.println("false");
                    return;
                }
            }
        }
        System.out.println("true");
    }



    public void union (int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        //小树接入大数下面，比较平衡
        if (rootP > rootQ) {
            this.parent[rootQ] = this.parent[rootP];
            this.size[rootP] += this.size[rootQ];
        } else {
            this.parent[rootP] = this.parent[rootQ];
            this.size[rootQ] += this.size[rootP];
        }
        this.count--;
    }

    public boolean isConnected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    public int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
}
