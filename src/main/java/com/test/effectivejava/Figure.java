package com.test.effectivejava;

/**
 * @Auther: linklmm
 * @Date: 2019/4/16 16:46
 * @Description 类层次优于标签类
 */
public class Figure {
    enum Shape {
        RECTANCEL, CIRCLE
    }

    ;

    final Shape shape;

    double length;
    double width;

    double radius;

    public Figure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    public Figure(double length, double width) {
        shape = Shape.RECTANCEL;
        this.length = length;
        this.width = width;
    }

    double area() {
        switch (shape) {
            case RECTANCEL:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
            default:
                throw new AssertionError(shape);
        }
    }
}
