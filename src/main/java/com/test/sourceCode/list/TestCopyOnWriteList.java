package com.test.sourceCode.list;


import java.math.BigDecimal;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.jupiter.api.Test;

/**
 * Description 测试CopyOnWriteList
 *
 * @author playboy
 * @date 2020-02-23 14:01
 * version 1.0
 */
public class TestCopyOnWriteList {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("10");
        list.add("20");
        list.add("30");
        Iterator<String> iterator = list.iterator();
        list.add("50");
        iterator.next();
        list.add("50");
    }

    @Test
    public void test() {
        String d = "0";
        System.out.println(Double.valueOf(d) == 0);
    }
}
