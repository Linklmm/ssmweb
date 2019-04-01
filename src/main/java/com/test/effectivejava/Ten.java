package com.test.effectivejava;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-22 09:28
 * @Version 1.0
 * @Description 第十条，覆盖equals方法时请遵守通用约定
 */
public class Ten {
    public static void main(String[] args) {
        CaseInsensitiveString caseInsensitiveString = new CaseInsensitiveString("Polish");
        String s ="polish";
        //违反对称性
        System.out.println("equals:"+caseInsensitiveString.equals(s));
        System.out.println("equals:"+s.equals(caseInsensitiveString));

        System.out.println("equals2:"+caseInsensitiveString.equals2(s));
        System.out.println("equals2:"+s.equals(caseInsensitiveString));

        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(caseInsensitiveString);
        System.out.println(list.contains(s));


        //传递性
        Point p = new Point(1,2);
        ColorPoint cp = new ColorPoint(1,2,Color.RED);
        //违反对称性
        //忽略了颜色信息
        System.out.println("color:"+p.equals(cp));
        System.out.println("color:"+cp.equals(p));

        //违反传递性
        ColorPoint p1 = new ColorPoint(1,2,Color.RED);
        Point p2 = new Point(1,2);
        ColorPoint p3 = new ColorPoint(1,2,Color.BLUE);
        System.out.println("p1.equals2(p2):"+p1.equals2(p2));
        System.out.println("p2.equals(p3):"+p2.equals(p3));
        System.out.println("p1.equals2(p3):"+p1.equals2(p3));
    }
}
