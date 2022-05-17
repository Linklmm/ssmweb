package com.test.test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.test.designMode.singleton.different.SingletonEnum;
import com.test.test.pojo.Base;
import com.test.test.pojo.BaseResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

import com.test.test.pojo.SortEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

@Slf4j
public class Test2 {

    @Test
    public void testArray() {
        Base base1 = new Base(11, 11, false);
        Base base2 = new Base(12, 12, true);
        List<Base> bases = Lists.newArrayList(base1, base2);
        Base arrayBase = bases.stream().findFirst().get();
        log.error("array:{}", JSON.toJSONString(bases));
        log.error("findAndy:{}", JSON.toJSONString(bases.stream().findAny()));
        arrayBase.setI(111);
        log.error("array:{}", JSON.toJSONString(bases));
    }

    @Test
    public void testJson() {
        BaseResponse baseResponse = new BaseResponse();
        List<Base> bases = null;
        baseResponse.setBases(null == bases || bases.isEmpty() ? Collections.emptyList() : bases);
        log.error("baseResponse:{}", JSON.toJSONString(baseResponse));
    }

    @Test
    public void testLocalDate() {
        BigDecimal d = new BigDecimal("1.1111");
        log.error("d:{}", d);
        LocalDate localDate = LocalDate.now();
        log.error("date:{}", localDate);
        LocalDate yesterDay = localDate.plusDays(-1);
        log.error("yesterday:{}", yesterDay);
        log.error("compare:{}", localDate.isAfter(yesterDay));
        log.error("format:{}", localDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        Integer i = Integer.parseInt(localDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        log.error("integer:{}", Integer.parseInt(localDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"))));
        log.error("enum:{}", SingletonEnum.INSTANCE);
        log.error("max:{}", LocalDateTime.of(localDate, LocalTime.MAX));
        log.error("parse:{}", LocalDate.parse(i.toString(), DateTimeFormatter.BASIC_ISO_DATE));
        log.error("first:{}", localDate.with(TemporalAdjusters.firstDayOfMonth()));
        log.error("last:{}", localDate.with(TemporalAdjusters.lastDayOfMonth()));
        log.error("month:{}", localDate.getMonthValue());
        LocalDate now = LocalDate.now();
        LocalDate date = LocalDate.of(2022, 6, 18);
        log.error("months:{}", Period.between(date, now).getMonths());
        log.error("months2:{}", now.getMonthValue() - date.getMonthValue());
        log.error("years:{}", Period.between(date, now).getYears());
        log.error("years:{}", localDate.getYear());
        log.error("sub years:{}", now.getYear() - date.getYear());
        log.error("dayOfYear:{}", localDate.getDayOfYear());
        log.error("int:{}", localDate.getYear() * 10000 + localDate.getMonthValue() * 100 + localDate.getDayOfMonth());
        Instant nowI = Instant.now();
        log.error("nowI:{}", LocalDateTime.ofInstant(nowI, ZoneId.systemDefault()));
        log.error("plusSeconds:{}", LocalDateTime.ofInstant(nowI.plusSeconds(60), ZoneId.systemDefault()));
        log.error("instant:{}", Instant.now().toEpochMilli());

        LocalDateTime localDateTime = LocalDateTime.of(20022, 5, 15, 20, 20);
        LocalDateTime localDateTime2 = LocalDateTime.of(20022, 5, 15, 20, 20);
        log.error("{}", !localDateTime.toLocalDate().equals(localDateTime2.toLocalDate()));

        log.error("between:{}", Period.between(date, now).getDays());
    }

    @Test
    public void testDistinct() {
        List<Long> arry = Lists.newArrayList(1L, 2L, 3L, 3L, 2L, 1L, 4L, 5L, 1L, 2L);
        arry = arry.stream().distinct().collect(Collectors.toList());
        log.error("array:{}", JSON.toJSONString(arry));
    }

    @Test
    public void testDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        // int day = localDateTime.getDayOfMonth();
        localDateTime = localDateTime.with(TemporalAdjusters.firstDayOfMonth());
        localDateTime = localDateTime.withHour(0);
        localDateTime = localDateTime.withMinute(0);
        localDateTime = localDateTime.withSecond(0);
        localDateTime = localDateTime.withNano(0);

        LocalDateTime endTime = localDateTime.with(TemporalAdjusters.lastDayOfMonth());
        endTime = endTime.withHour(23);
        endTime = endTime.withMinute(59);
        endTime = endTime.withSecond(59);

        System.out.println(localDateTime);
        System.out.println(endTime);

        System.out.println(localDateTime.toInstant(OffsetDateTime.now()
                .getOffset()));
    }

    @Test
    public void testLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.of(2021, 6, 11, 14, 30, 0);
        LocalDateTime localDateTime1 = LocalDateTime.of(2021, 6, 11, 14, 0, 0);
        System.out.println(localDateTime.toInstant(OffsetDateTime.now().getOffset()));
        System.out.println(localDateTime1.toInstant(OffsetDateTime.now().getOffset()));
    }

    @Test
    public void testArrays() {
        //这里只是得到一个list视图，所以无法进行删除等操作
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(JSON.toJSONString(list));
        //不支持删除操作
        list.remove(1);
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void testBigDecimal() {
        Double d = 1.9D;
        System.out.println(BigDecimal.valueOf(d));
    }

    @Test
    public void testMap() {
        Map<Integer, List<Integer>> listMap = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                list.add(j);
            }
            listMap.put(i, list);
        }
        listMap.forEach((key, value) -> value.remove(1));
        log.error("listMap:{}", listMap);

    }

    @Test
    public void test() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        log.info("1:{}", array[1]);
        log.info("2:{}", array[2]);
    }

    @Test
    public void tset2() {
        List<SortEntity> list = Arrays.asList(
                new SortEntity("已放款"),
                new SortEntity("待放款"),
                new SortEntity("待确认"),
                new SortEntity("待审核"),
                new SortEntity("待发送"),
                new SortEntity("已放款"),
                new SortEntity("待放款"),
                new SortEntity("待审核")
        );

        //排序规则
        List<String> sortList = Arrays.asList("待确认", "待审核", "待发送", "待放款", "已放款");
        list = list.stream().sorted(
                Comparator.comparing(SortEntity::getTarget, (x, y) -> {
                    for (String sort : sortList) {
                        if (sort.equals(x) || sort.equals(y)) {
                            if (x.equals(y)) {
                                return 0;
                            } else if (sort.equals(x)) {
                                return -1;
                            } else {
                                return 1;
                            }
                        }
                    }
                    return 0;
                })
        ).collect(Collectors.toList());

        log.error("list:{}", JSON.toJSON(list));
    }

    @Test
    public void testForeach() {
        List<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5, 6);
        integers.forEach(i -> {
            if (1 == i) {
                i = 0;
            }
        });
        log.error("integers:{}", JSON.toJSONString(integers));
    }

}
