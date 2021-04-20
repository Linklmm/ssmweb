package com.test.algorithm.book.one.five;

/**
 * 使用树的思想
 * quick uinion
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
     * o(n)
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
     * 解决了quick find 的union问题，但并不能保证在所有情况下它都能比quick-find算法快得多
     * 2n+1
     */
    public void union(int m, int n) {
        //o(n)
        int i = root(m);
        //o(n)
        int j = root(n);
        //o(1)
        array[i] = j;
    }
}
