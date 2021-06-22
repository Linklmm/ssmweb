package com.test.algorithm.book.one.four;

import java.util.Collections;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;

/**
 * 3-sum
 * 求多少组满足三个整数相加为0的数组
 */
public class TreeSum {

    public static int count(int[] a) {
        int N = a.length;
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; j++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Collections.singletonMap("lll", "test").toString());
        System.out.println(JSON.toJSONString(Collections.singletonMap("mmmm","nnnn")));
        Map<String,String> map = Maps.newHashMap();
        System.out.println(map.get(null));
    }
}
