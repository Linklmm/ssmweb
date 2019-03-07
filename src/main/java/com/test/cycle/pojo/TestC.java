package com.test.cycle.pojo;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-05 10:37
 * @Version 1.0
 * @Description 循环依赖
 */
public class TestC {
    private TestA testA;

    public TestC(TestA testA) {
        this.testA = testA;
    }

    public void c(){
        testA.a();
    }
}
