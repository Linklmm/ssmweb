package com.test.sourceCode.list;


import com.google.common.collect.ImmutableMap;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;

import java.util.Date;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * Description 测试谷歌的guava框架
 *
 * @author playboy
 * @date 2020-02-22 21:30
 * version 1.0
 */
@Slf4j
public class TestGuava {
    @Test
    public void testMapsDifference() {
        Map<String, String> leftMap = ImmutableMap.of("1", "1", "2", "2", "3", "3");
        Map<String, String> rightMap = ImmutableMap.of("2", "2", "3", "30", "4", "4");
        MapDifference difference = Maps.difference(leftMap, rightMap);
        log.info("左边map独有key：{}", difference.entriesOnlyOnLeft());
        log.info("右边map独有key:{}", difference.entriesOnlyOnRight());
        log.info("左右边map都有key，并且value相等:{}", difference.entriesInCommon());
        log.info("左右边map都有key，但value不等：{}", difference.entriesDiffering());
    }

    @Test
    public void testDate() {
        Date date = new Date();
        System.out.println(date);
    }

}
