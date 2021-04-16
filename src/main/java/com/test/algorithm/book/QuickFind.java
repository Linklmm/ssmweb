package com.test.algorithm.book;

/**
 * 快速查找
 * quick find
 *
 */
public class QuickFind {

    private int[] id;

    public QuickFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; n++) {
            id[i] = i;
        }
    }

    public Boolean connected(int m, int n) {
        return id[m] == id[n];
    }

    public void union(int m, int n) {
        int idxM = id[m];
        int idxN = id[n];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == idxM) {
                id[i] = idxN;
            }
        }
    }
}
