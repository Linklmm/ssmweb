package com.test.effectivejava.eight;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Auther: linklmm
 * @Date: 2019/6/10 08:20* @Description 它试图根据一个集合是set、list，还是其他的集合类型，来对它进行分类
 * 要调用哪个重载方法是在编译时就已经做出了决定
 */
public class CollectionClassifier {
    public static String classify(Set<?> s) {
        return "Set";
    }

    public static String classify(List<?> list) {
        return "List";
    }

    public static String classify(Collection<?> c) {
        return "Unknown Collection";
    }

    public static void main(String[] args) {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()};
        for (Collection<?> c : collections) {
            System.out.println(classify(c));
        }
    }
}
