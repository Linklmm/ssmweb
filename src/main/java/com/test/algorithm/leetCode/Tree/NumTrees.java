package com.test.algorithm.leetCode.Tree;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-01-10 22:22
 * @description: 96. 不同的二叉搜索树
 **/
public class NumTrees {

  public static int numTrees(int n) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return 1;
    }
    int sum = 0;
    for (int i = 1; i <= n; i++) {
      sum += numTrees(i - 1) * numTrees(n - i);
    }

    return sum;
  }

  public static int numTrees2(int n) {
    int[] g = new int[n + 1];
    g[0] = 1;
    g[1] = 1;
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        g[i] += g[j - 1] * g[i - j];
      }
    }

    return g[n];
  }


  public static void main(String[] args) {
    System.out.println(numTrees(3));
    System.out.println(numTrees2(3));
  }
}
