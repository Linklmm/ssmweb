package com.test.algorithm.leetCode;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2021-07-05 22:21
 * @description: 191. 位1的个数
 **/
public class HammingWeight {

  public int hammingWeight(int n) {
    int result = 0;
    for (int i = 0; i < 32; i++) {
      if ((n & (i << i)) != 0) {
        result++;
      }
    }
    return result;
  }
}
