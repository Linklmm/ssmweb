package com.test.effectivejava.five;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: linklmm
 * @Date: 2019/4/18 09:01
 * @Description 泛型26条
 */
public class GenericityOne {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.toString(42));
        String s = strings.get(0);
    }

    //    public static void unsafeAdd(List list,Object o){
//        list.add(o);
//    }
//    public static void unsafeAdd(List<Object> list, Object o) {
//        list.add(o);
//    }
    public static void unsafeAdd(List<String> list, String o) {
        list.add(o);
    }
}
