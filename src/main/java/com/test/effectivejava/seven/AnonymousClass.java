package com.test.effectivejava.seven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Auther: linklmm
 * @Date: 2019/5/15 08:46* @Description 通过一个匿名类创建了排序的比较函数
 */
public class AnonymousClass {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        String ss = "lmm";
        String ss2 = "link";
        String ss3 = "flower";
        words.add(ss);
        words.add(ss2);
        words.add(ss3);
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
        //lambda表达式
        Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
    }
}
