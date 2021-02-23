package com.test.cycle.pojo;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-05 14:15
 * @Version 1.0
 * @Description setter循环依赖
 */
public class CircleC {
    private CircleA circleA;

    public void c() {
        circleA.a();
    }

    public CircleA getCircleA() {
        return circleA;
    }

    public void setCircleA(CircleA circleA) {
        this.circleA = circleA;
    }
}
