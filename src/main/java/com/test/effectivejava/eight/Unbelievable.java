package com.test.effectivejava.eight;

/**
 * @Auther: linklmm
 * @Date: 2019/6/20 10:19
 * @Description 自动拆装箱导致的空指针异常
 */
public class Unbelievable {
    private static Integer i;

    public static void main(String[] args) {
        if (i == 49) {
            System.out.println("Unbelievable");
        }
    }
}
