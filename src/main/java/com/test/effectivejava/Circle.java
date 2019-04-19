package com.test.effectivejava;

/**
 * @Auther: linklmm
 * @Date: 2019/4/16 17:39
 * @Description 类层次优于标签类，子类型化的范例
 */
public class Circle extends FigureOptimize {

    final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * (radius * radius);
    }
}
