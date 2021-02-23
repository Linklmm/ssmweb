package com.test.cycle.pojo;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-05 10:36
 * @Version 1.0
 * @Description 循环依赖
 */
public class TestA {
    private TestB testB;

    public TestA(TestB testB) {
        this.testB = testB;
    }

    public void a() {
        testB.b();
    }
}
