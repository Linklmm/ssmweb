package com.test.test;


import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableList;
import com.test.test.pojo.SortEntity;
import com.test.test.pojo.User;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description 自定义类
 *
 * @author playboy
 * @date 2020-02-11 16:47
 * version 1.0
 */
public class SortDTO implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(SortDTO.class);
    private String sortTarget;

    public String getSortTarget() {
        return sortTarget;
    }

    public void setSortTarget(String sortTarget) {
        this.sortTarget = sortTarget;
    }

    public SortDTO(String sortTarget) {
        this.sortTarget = sortTarget;
    }

    public static void testSort() {
        List<SortDTO> list = ImmutableList.of(
                new SortDTO("300"),
                new SortDTO("50"),
                new SortDTO("200"),
                new SortDTO("220")
        );

        SortDTO[] array = new SortDTO[list.size()];
        list.toArray(array);

        log.info("搜索之前：{}", JSON.toJSONString(array));
        Arrays.sort(array, Comparator.comparing(SortDTO::getSortTarget));
        log.info("先排序，结果为：{}", JSON.toJSONString(array));
        int index = Arrays.binarySearch(array, new SortDTO("200"),
                Comparator.comparing(SortDTO::getSortTarget));
        if (index < 0) {
            throw new RuntimeException("没有找到 200");
        }
        log.info("搜索结果：{}", JSON.toJSONString(array[index]));
    }

    public static void main(String[] args) {
        //
        //testSort();
        User user = new User("ddd", 2);
        //log.info("user:{}",JSON.toJSONString(user));
        System.out.println(user.getId());
        Integer integer = 11;
        Integer integer1 = 11;
        Integer integer2 = 129;
        Integer integer3 = 129;
        System.out.println(integer == integer1);
        System.out.println(integer2 == integer3);
    }

    @Test
    public void test() {
        User user = new User();
        //log.info("user:{}",JSON.toJSONString(user));
        System.out.println(user.getId());

    }

    @Test
    public void test1() {
        User[] users1 = {new User("java", 1)};
        User[] users2 = Arrays.copyOf(users1, users1.length);

        users1[0].setName("jdk");
        log.error("o1:{}", JSON.toJSONString(users1));
        log.error("o2:{}", JSON.toJSONString(users2));
    }

}
