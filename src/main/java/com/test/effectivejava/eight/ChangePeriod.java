package com.test.effectivejava.eight;

import java.util.Date;

/**
 * @Auther: linklmm
 * @Date: 2019/6/5 09:17* @Description 测试保护性拷贝和非保护性拷贝
 */
public class ChangePeriod {
    public static void main(String[] args) {
        Date start = new Date();
        Date end = new Date();
        Period p = new Period(start,end);
        System.out.println(p);
        end.setYear(78);
        System.out.println(p);

        Date start2 = new Date();
        Date end2 = new Date();
        Period2 period2 = new Period2(start2,end2);
        System.out.println(period2);
        end2.setYear(78);
        System.out.println(period2);
        period2.getEnd().setYear(78);
        System.out.println(period2);

        Date start3 = new Date();
        Date end3 = new Date();
        Period3 period3 = new Period3(start3,end3);
        System.out.println(period3);
        end2.setYear(78);
        System.out.println(period3);
        period2.getEnd().setYear(78);
        System.out.println(period3);

    }
}
