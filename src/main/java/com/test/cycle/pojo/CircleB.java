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
public class CircleB {
    private CircleC circleC;

    public void b(){
        circleC.c();
    }

    public CircleC getCircleC() {
        return circleC;
    }

    public void setCircleC(CircleC circleC) {
        this.circleC = circleC;
    }
}
