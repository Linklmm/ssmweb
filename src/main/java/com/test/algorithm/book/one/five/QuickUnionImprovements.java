package com.test.algorithm.book.one.five;

/**
 * 使用树的思想和加权的思想
 * 加权quick-union 快速合并集
 */
public class QuickUnionImprovements {

    private int[] array;
    private int[] sz;

    public QuickUnionImprovements(int n) {
        array = new int[n];
        for (int i = 0; i < n; n++) {
            array[i] = i;
            sz[i] = 1;
        }
    }

    /**
     * 查找根节点
     */
    public int root(int i) {
        while (array[i] != i) {
            i = array[i];
        }
        return i;
    }

    /**
     * connect是否连通
     */
    public boolean connect(int m, int n) {
        return root(array[m]) == root(array[n]);
    }

    /**
     * 连通两个节点
     * 通过比较两个节点的权值，哪个权值大，哪个就为父节点
     * 算法的时间复杂度为O(lgn)
     */
    public void union(int m, int n) {
        int i = root(m);
        int j = root(n);
        if (i == j) {
            return;
        }
        if (sz[i] < sz[j]) {
            array[i] = j;
            sz[j] += sz[i];
        } else {
            array[j] = i;
            sz[i] += sz[j];
        }
    }
}
