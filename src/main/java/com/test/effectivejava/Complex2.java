package com.test.effectivejava;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-04-03 18:04
 * @Version 1.0
 * @Description 不可变类变成final的另一种方法，让类的所有构造器都变成私有的或者包级私有
 */
public class Complex2 {
    private final double re;
    private final double im;

    private Complex2(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static Complex2 valueOf(double re, double im) {
        return new Complex2(re, im);
    }
}
