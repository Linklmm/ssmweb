package com.test.algorithm.leetCode;


import java.util.HashMap;
import java.util.Map;

/**
 * Description 70。爬楼梯
 *
 * @author playboy
 * @date 2020-07-10 09:42
 * version 1.0
 */
public class ClimbStairs {
    //增加缓存，减少重复计算,key为n，value为结果
    private static final Map<Integer, Integer> cache = new HashMap<>();

    //递归实现速度太慢，
    public int climbStairs(int n) {

        if (n < 3) {
            //有缓存直接返回
            if (cache.containsKey(n)) {
                return cache.get(n);
            }
            cache.put(n, n);
            return n;
        } else {
            if (cache.containsKey(n)) {
                return cache.get(n);
            }
            int num = climbStairs(n - 1) + climbStairs(n - 2);
            //没有则添加至缓存中
            cache.put(n, num);
            return num;
        }
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println(climbStairs.climbStairs(45));
    }

}
