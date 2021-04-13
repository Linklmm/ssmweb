package com.test.algorithm.book;

/**
 * 使用树的思想
 */
public class QuickUnion {

    private int[] array;

    public QuickUnion(int n) {
        array = new int[n];
        for (int i = 0; i < n; n++) {
            array[i] = i;
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
     * 让m的根节点变成n的根节点
     */
    public void union(int m, int n) {
        int i = root(m);
        int j = root(n);
        array[i] = j;
    }
}
