package com.test.test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.test.designMode.singleton.different.SingletonEnum;
import com.test.test.pojo.Base;
import com.test.test.pojo.BaseResponse;
import com.test.test.pojo.SortEntity;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

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
  public void testLocalDate() throws InterruptedException {
    BigDecimal d = new BigDecimal("1.1111");
    log.error("d:{}", d);
    LocalDate localDate = LocalDate.now();
    LocalDateTime localDateTime = LocalDateTime.now();
    LocalTime localTime = LocalTime.now();
    Instant instant = Instant.now();
    //获取当前时间
    log.error("localDate:{}", localDate);
    log.error("localDateTime:{}", localDateTime);
    log.error("localTime:{}", localTime);
    log.error("instant:{}", instant);
    //LocalDateTime 类型转换
    log.error("LocalDateTime 类型转换");
    log.error("LocalDateTime to LocalDate:{}", localDateTime.toLocalDate());
    log.error("LocalDateTime to Instant:{}",
        localDateTime.toInstant(OffsetDateTime.now().getOffset()));
    //log.error("LocalDateTime to Instant2:{}", Instant.from(localDateTime));
    log.error("LocalDateTime to LocalTime:{}", localDateTime.toLocalTime());

    log.error("LocalDate 类型转换");
    log.error("localDate To LocalDateTime:{}", LocalDateTime.of(localDate, localTime));
    //log.error("localDate to Instant:{}", Instant.from(localDate));

    log.error("localTime 类型转换");
    //log.error("localTime to Instant:{}", Instant.from(localTime));

    log.error("instant 类型转换");
    log.error("Instant to LocalDateTime:{}",
        LocalDateTime.ofInstant(instant, ZoneId.systemDefault()));
    //log.error("Instant to LocalDate:{}", LocalDate.from(instant));
    //log.error("Instant to LocalTime:{}", LocalTime.from(instant));

    log.error("自定义时间");
    LocalDateTime customLocalDateTime = LocalDateTime.of(2022, 6, 20, 22, 18, 30, 300);
    log.error("customLocalDateTime:{}", customLocalDateTime);
    LocalDate customLocalDate = LocalDate.of(2022, 6, 20);
    log.error("customLocalDate:{}", customLocalDate);
    LocalTime customLocalTime = LocalTime.of(6, 20, 10, 200);
    log.error("customLocalTime:{}", customLocalTime);
    Instant customInstant = Instant.ofEpochSecond(1655735301, 1);
    log.error("customInstant:{}", customInstant);
    log.error("customInstant:{}ms", Instant.ofEpochMilli(1655735754000L));

    log.error("时间操作");
    log.error("加1天:{}", localDateTime.plusDays(1));
    log.error("减一天:{}", localDateTime.minusDays(1));
    log.error("加一周:{}", localDateTime.plusWeeks(1));
    log.error("减一周:{}", localDateTime.minusWeeks(1));
    log.error("加一个月:{}", localDateTime.plusMonths(1));
    log.error("减一个月:{}", localDateTime.minusMonths(1));
    log.error("加一年:{}", localDateTime.plusYears(1));
    log.error("减一年:{}", localDateTime.minusYears(1));
    log.error("加减:{}", localDateTime.plus(1, ChronoUnit.DAYS));

    LocalDate yesterday = localDate.plusDays(-1);
    log.error("yesterday:{}", yesterday);
    log.error("isAfter:{}", localDate.isAfter(yesterday));
    log.error("isBefore:{}",localDate.isBefore(localDate));

    log.error("format:{}", localDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
    Integer i = Integer.parseInt(localDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
    log.error("integer:{}",
        Integer.parseInt(localDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"))));
    log.error("enum:{}", SingletonEnum.INSTANCE);
    log.error("max:{}", LocalDateTime.of(localDate, LocalTime.MAX));
    log.error("parse:{}", LocalDate.parse(i.toString(), DateTimeFormatter.BASIC_ISO_DATE));
    log.error("first:{}", localDate.with(TemporalAdjusters.firstDayOfMonth()));
    log.error("last:{}", localDate.with(TemporalAdjusters.lastDayOfMonth()));
    log.error("month:{}", localDate.getMonthValue());
    LocalDate now = LocalDate.now();
    LocalDate date = LocalDate.of(2021, 6, 1);
    log.error("months:{}", Period.between(date, now).getMonths());
    log.error("months2:{}", now.getMonthValue() - date.getMonthValue());
    log.error("years:{}", Period.between(date, now).getYears());
    log.error("years:{}", localDate.getYear());
    log.error("sub years:{}", now.getYear() - date.getYear());
    log.error("dayOfYear:{}", localDate.getDayOfYear());
    log.error("int:{}",
        localDate.getYear() * 10000 + localDate.getMonthValue() * 100 + localDate.getDayOfMonth());
    Instant nowI = Instant.now();
    log.error("nowI:{}", LocalDateTime.ofInstant(nowI, ZoneId.systemDefault()));
    log.error("nowILocalDate:{}", nowI.atZone(ZoneId.systemDefault()).toLocalDate());
    log.error("plusSeconds:{}",
        LocalDateTime.ofInstant(nowI.plusSeconds(60), ZoneId.systemDefault()));
    log.error("instant:{}", Instant.now().toEpochMilli());

    LocalDateTime localDateTimeByOf = LocalDateTime.of(20022, 1, 1, 20, 20);
    LocalDateTime localDateTime2 = LocalDateTime.of(20022, 5, 19, 20, 20);
    log.error("days:{}", ChronoUnit.DAYS.between(now, date));
    log.error("{}", !localDateTimeByOf.toLocalDate().equals(localDateTime2.toLocalDate()));

    log.error("between:{}", Period.between(date, now).getDays());
    Thread.sleep(300);
    log.error("duration:{}", Duration.between(nowI, Instant.now()).toMillis());
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

    Map<Integer, Integer> linkedMap = new LinkedHashMap<>();
    for (int i = 0; i < 10; i++) {
      linkedMap.put(i, i);
    }
    log.error("linkedMap:{}", linkedMap);

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

  @Test
  public void testObjectHash() {
    Base base = new Base(1000, 1000, false);
    Base base2 = new Base(1000, 1000, false);
    Base base3 = new Base(1000, 1000, true);
    log.error("base hash:{},base2 hash:{},base3 hash:{}", base.hashCode(), base2.hashCode(),
        base3.hashCode());
    Set<Base> bases = new HashSet<>();
    bases.add(base);
    bases.add(base2);
    bases.add(base3);

    log.error("contains:{},size:{}", bases.contains(new Base(1000, 1000, false)), bases.size());

  }

  @Test
  public void testHashCode() {
    log.error("hashCode:{}", "abc".hashCode());
  }

  @Test
  public void testException() {
    Test2 test2 = new Test2();
    try {
      test2.testExce();
    } catch (IllegalArgumentException e) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException interruptedException) {
      }
      test2.testExce();
    }
  }

  public void testExce() {
    log.error("重新执行");
    throw new IllegalArgumentException();
  }

}
