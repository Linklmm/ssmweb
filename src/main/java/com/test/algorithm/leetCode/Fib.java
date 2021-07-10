package com.test.algorithm.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2021-07-05 22:29
 * @description: 509. 斐波那契数
 **/
public class Fib {

  public static Map<Integer, Integer> resultMap = new HashMap<>();

  public static int fib(int n) {
    if (n <= 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    if (Objects.isNull(resultMap.get(n))) {
      resultMap.put(n, fib(n - 1) + fib(n - 2));
    }
    return resultMap.get(n);
  }

  public static void main(String[] args) {
    System.out.println(fib(4));
  }
}
