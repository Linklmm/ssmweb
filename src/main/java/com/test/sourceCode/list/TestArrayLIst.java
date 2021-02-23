package com.test.sourceCode.list;


import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

/**
 * Description 测试ArrayList
 *
 * @author playboy
 * @date 2020-02-19 15:13
 * version 1.0
 */
@Slf4j
public class TestArrayLIst {
    @Test
    public void testBatchInsert() {
        ArrayList<Integer> list = new ArrayList<>(3000000);
        for (int i = 0; i < 3000000; i++) {
            list.add(i);
        }

        ArrayList<Integer> list2 = new ArrayList<>();
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list2.add(list.get(i));
        }
        log.info("单个for循环新增300w个，耗时：{}", System.currentTimeMillis() - start1);

        ArrayList<Integer> list3 = new ArrayList<>();
        long start2 = System.currentTimeMillis();
        list3.addAll(list);
        log.info("批量新增300w个，耗时:{}", System.currentTimeMillis() - start2);

        ArrayList<Integer> list4 = new ArrayList<>(3000000);
        long start3 = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list4.add(list.get(i));
        }
        log.info("初始化容量，单个for循环新增300w个，耗时：{}", System.currentTimeMillis() - start3);

        ArrayList<Integer> list5 = new ArrayList<>(2000);
        long start4 = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            list5.add(i);
        }
        log.info("单个for循环2000个，耗时:{}", System.currentTimeMillis() - start4);

        long start5 = System.currentTimeMillis();
        list.removeAll(list5);
        log.info("批量删除2w耗时:{}", System.currentTimeMillis() - start5);

        ArrayList<Integer> list6 = new ArrayList<>(2000);
        for (int i = 20000; i < 40000; i++) {
            list6.add(i);
        }
        long start6 = System.currentTimeMillis();
        for (int i = 0; i < list6.size(); i++) {
            list.remove(list6.get(i));
        }
        log.info("单个删除2w耗时：{}", System.currentTimeMillis() - start6);

    }

    @Test
    public void testArrayToList() {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5};
        List<Integer> list = Arrays.asList(array);

    }

    @Test
    public void testListToArray() {
        List<Integer> list = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
        }};

        Integer[] array0 = new Integer[2];
        list.toArray(array0);
        log.info("toArray数组大小小于list，array[0]={},array[1]={},length:{}", array0[0], array0[1], array0.length);

        Integer[] array1 = new Integer[list.size()];
        list.toArray(array1);
        log.info("toArray数组大小等于list，array[0]={},array[1]={}", array1[0], array1[1]);

        Integer[] array2 = new Integer[list.size() + 2];
        list.toArray(array2);
        log.info("toArray数组大小大于list，array[0]={},array[1]={}，array[4]={}", array2[0], array2[1], array2[4]);

    }

    @Test
    public void test() {
        String s = null;
    }

    /**
     * 测试Google的guava框架的lists工具的反转
     * Guava返回的是自己定义的List，不是JDK的ArrayList
     */
    @Test
    public void testReverse() {
        List<String> list = new ArrayList<String>() {{
            add("10");
            add("20");
            add("30");
            add("40");
        }};

        log.info("反转之前：" + JSON.toJSONString(list));
        list = Lists.reverse(list);
        log.info("反转之后：" + JSON.toJSONString(list));
    }

    /**
     * 分组
     */
    @Test
    public void testPartition() {
        List<String> list = new ArrayList<String>() {{
            add("10");
            add("20");
            add("30");
            add("40");
        }};

        log.info("分组之前：" + JSON.toJSONString(list));
        List<List<String>> list2 = Lists.partition(list, 3);
        log.info("分组之后：" + JSON.toJSONString(list2));
    }

}
