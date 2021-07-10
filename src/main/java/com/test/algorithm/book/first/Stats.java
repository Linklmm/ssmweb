package com.test.algorithm.book.first;

import com.test.algorithm.book.common.StdIn;
import com.test.algorithm.book.common.StdOut;
import com.test.algorithm.book.dataStructure.Bag;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2021-06-07 21:22
 * @description: 背包用例
 **/
public class Stats {
    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<>();
        int i = 0;
        while (!StdIn.isEmpty() && i < 10) {
            numbers.add(StdIn.readDouble());
            i++;
        }

        int n = numbers.size();
        double sum = 0.0;
        for (double x : numbers) {
            sum += x;
        }
        double mean = sum / n;
        StdOut.println(mean);
        sum = 0.0;

        for (double x : numbers) {
            sum += (x - mean) * (x - mean);
        }

        double std = Math.sqrt(sum / (n - 1));
        StdOut.printf("mean: %.2f\n", mean);
        StdOut.printf("std dev: %.2f\n", std);
    }
}
