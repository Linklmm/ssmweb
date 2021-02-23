package com.test.effectivejava.eight;

import java.util.Date;

/**
 * @Auther: linklmm
 * @Date: 2019/6/5 09:19* @Description 对构造器进行保护性拷贝，方法未进行保护性拷贝
 */
public class Period2 {
    private final Date start;
    private final Date end;

    public Period2(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException(
                    this.start + " after " + this.end
            );
        }
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Period2{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
