package com.test.effectivejava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-20 10:17
 * @Version 1.0
 * @Description 避免创建不必要的对象，确定一个字符串是否为一个有效的罗马数字
 */
public class IsRomanNumeral {
    /**
     * 内部为正则表达式创建了一个Pattern实例，却只用了一次
     * 之后就可以进行垃圾回收了，创建Pattern实例的成本很高，
     * 因为需要将正则表达式编译成一个有限状态机
     *
     * @param s
     * @return
     */
    static boolean isRomanNumber(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C[0,3])"
                + "(X[CL]|L?X{0,3})(I[XV]V?I{0,3})$");
    }

    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C[0,3])"
            + "(X[CL]|L?X{0,3})(I[XV]V?I{0,3})$");

    /**
     * 将正则表达式编译成一个Pattern实例（不可变），让它成为类初始化的一部分，并将它缓存起来
     *
     * @param s
     * @return
     */
    static boolean isRomanNumeral(String s) {
        return ROMAN.matcher(s).matches();
    }

    /**
     * 自动装箱导致的创建多余对象，
     * 每次循环创建一个Long对象，即2^31个Long实例
     *
     * @return
     */
    private static long sum() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }

    private static long sum2() {
        long sum = 0;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isRomanNumber("III"));

        System.out.println(isRomanNumeral("III"));

        Date date = new Date();
        System.out.println(date);

        String s = "2";
        System.out.println(Long.valueOf(s));

        List<Long> list = new ArrayList<Long>();
        System.out.println();
//        System.out.println(sum());
//        System.out.println(sum2());
    }
}
