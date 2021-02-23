package com.test.effectivejava.eight;

import java.util.Date;

/**
 * @Auther: linklmm
 * @Date: 2019/6/5 09:26* @Description 对构造器和方法进行保护性拷贝，确保Period3是真正不可变的
 */
public class Period3 {
    private final Date start;
    private final Date end;

    public Period3(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException(
                    this.start + " after " + this.end
            );
        }
    }

    public Date getStart() {
        return new Date(start.getTime());
    }

    public Date getEnd() {
        return new Date(end.getTime());
    }

    @Override
    public String toString() {
        return "Period3{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
