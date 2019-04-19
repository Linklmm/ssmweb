package com.test.effectivejava;

/**
 * @Auther: linklmm
 * @Date: 2019/4/16 17:44
 * @Description 类层次优于标签类，子类型化的范例
 */
public class Rectangle extends FigureOptimize {

    final double length;
    final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length*width;
    }
}
