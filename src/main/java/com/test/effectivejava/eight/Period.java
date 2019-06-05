package com.test.effectivejava.eight;

import java.util.Date;

/**
 * @Auther: linklmm
 * @Date: 2019/6/5 09:13* @Description 非保护性拷贝
 */
public class Period {
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        if (start.compareTo(end)>0)
            throw new IllegalArgumentException(
                    start+" after"+end
            );
        this.start = start;
        this.end = end;
    }
    public Date getStart(){
        return start;
    }

    public Date getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Period{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
