package com.test.effectivejava.six;

import org.junit.jupiter.api.Test;

/**
 * @Auther: linklmm
 * @Date: 2019/5/13 16:51* @Description 注解优先于命名模式
 */
public class Sample {
    @Test
    public static void m1(){}
    public static void m2(){}
    @Test
    public static void m3(){
        throw new RuntimeException("Boom");
    }
    public static void m4(){}
    @Test
    public void m5(){}
    public static void m6(){}
    @Test
    public static void m7(){
        throw new RuntimeException("Crash");
    }
    public static void m8(){}
}
