package com.test.algorithm.leetCode.array;

import java.util.*;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2021-02-23 21:42
 * @description: 121.买卖股票的最佳时机
 **/
public class MaxProfit {
    //得到第几天
    public static int maxProfit(int[] prices) {
        //记录第几天卖出最值
        Map<Integer, Integer> map = new HashMap<>();
        //当前天的最大利润
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < prices.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i + 1; j < prices.length; j++) {
                //只有前一天的价格比后一天的价格便宜才能卖出，算出价格
                if (prices[i] < prices[j]) {
                    list.add(prices[j] - prices[i]);
                } else {
                    //无最高利润设为0
                    list.add(0);
                }
            }
            //最后一天直接为0
            if (list.isEmpty()) {
                map.put(i, 0);
                result.add(0);
            } else {
                map.put(i, i + list.indexOf(Collections.max(list)) + 1);
                result.add(Collections.max(list));
            }

        }
        //无利润；
        if (Collections.max(result) == 0) {
            return 0;
        }
        //得到哪天买入价格是最大利润
        int day = result.indexOf(Collections.max(result));
        return map.get(day) + 1;
    }

    public static int maxProfit2(int[] prices) {
        //当前天的最大利润
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < prices.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i + 1; j < prices.length; j++) {
                //只有前一天的价格比后一天的价格便宜才能卖出，算出价格
                if (prices[i] < prices[j]) {
                    list.add(prices[j] - prices[i]);
                }
            }
            //最后一天直接为0
            if (list.isEmpty()) {
                result.add(0);
            } else {
                result.add(Collections.max(list));
            }

        }
        return Collections.max(result);
    }

    public static int maxProfit3(int[] prices) {
        List<Integer> list = new ArrayList<>();
        if (prices.length == 1) {
            return 0;
        } else {
            for (int i = 1; i < prices.length; i++) {
                if (prices[0] < prices[i]) {
                    list.add(prices[i] - prices[0]);
                }
            }
            int max = 0;
            if (!list.isEmpty()) {
                max = Collections.max(list);
            }

            int[] array = Arrays.copyOfRange(prices, 1, prices.length);
            int nextMax = maxProfit3(array);
            return max > nextMax ? max : nextMax;
        }
    }

    public static int maxProfit4(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int max = 0;
                if (prices[i] < prices[j]) {
                    max = prices[j] - prices[i];
                }
                maxProfit = maxProfit < max ? max : maxProfit;
            }
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        int[] prices = {1, 2};
        int max = maxProfit4(prices);
        System.out.println(max);
    }
}
