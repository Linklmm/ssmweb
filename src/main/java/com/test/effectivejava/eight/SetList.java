package com.test.effectivejava.eight;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Auther: linklmm
 * @Date: 2019/6/10 08:47
 * @Description list的remove的重载方法的实现和set的重载方法不一样
 * List每remove掉一个元素以后，后面的元素都会向前移动，此时如果执行i=i+1，则刚刚移过来的元素没有被读取。
 */
public class SetList {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }

        for (int i = 0; i < 3; i++) {
            set.remove(i);
//            list.remove(i);
//            list.remove((Integer) i);
            if (list.get(i).equals(-3)) {
                list.remove(i);
            }
        }
        System.out.println(set + " " + list);
    }
}
