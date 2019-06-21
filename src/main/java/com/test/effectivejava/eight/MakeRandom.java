package com.test.effectivejava.eight;

import java.util.Random;

/**
 * @Auther: linklmm
 * @Date: 2019/6/18 08:04
 * @Description 制造随机数，了解和使用类库
 */
public class MakeRandom {
    /**
     * 缺点1：如果n是比较小的2的乘方，经过一段相当短的周期之后，他产生的随机数序列将会重复。
     * 缺点2：如果n不是2的乘方，那么平均起来，有些数会比其他的数出现得更为频繁。如果n比较大，
     * 这个缺点就会非常的明显
     * 第三个缺点：在极少数情况下，它的失败是灾难性的，因为会返回一个落在指定范围之外的数。
     */
    static Random rnd = new Random();

    static int random(int n) {
        return Math.abs(rnd.nextInt()) % n;
    }

    public static void main(String[] args) {
        int n = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        for (int i = 0; i < 1000000; i++) {
            if (random(n) < n / 2) {
                low++;
            }
        }
        System.out.println(low);
    }
}
