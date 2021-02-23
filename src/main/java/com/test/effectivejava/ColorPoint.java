package com.test.effectivejava;

import java.awt.*;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-22 14:01
 * @Version 1.0
 * @Description equals 传递性，扩展point类
 */
public class ColorPoint extends Point {
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    /**
     * 只有当它的参数是个有色点，并且具有同样的位置和颜色时，他才会返回true
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ColorPoint)) {
            return false;
        }
        return super.equals(obj) && ((ColorPoint) obj).color == color;
    }

    /**
     * “混合比较”时忽略颜色信息,提供了对称性，但是牺牲了传递性
     *
     * @param o
     * @return
     */
    public boolean equals2(Object o) {
        if (!(o instanceof Point)) {
            return false;
        }

        if (!(o instanceof ColorPoint)) {
            return o.equals(this);
        }

        return super.equals(o) && ((ColorPoint) o).color == color;
    }
}
