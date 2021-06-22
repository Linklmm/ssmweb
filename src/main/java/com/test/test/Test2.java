package com.test.test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.test.test.pojo.Base;
import com.test.test.pojo.BaseResponse;
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
import java.util.Date;
import java.util.List;
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
    public void testLocalDateTime(){
        LocalDateTime localDateTime = LocalDateTime.of(2021,6,11,14,30,0);
        LocalDateTime localDateTime1 = LocalDateTime.of(2021,6,11,14,0,0);
        System.out.println(localDateTime.toInstant(OffsetDateTime.now().getOffset()));
        System.out.println(localDateTime1.toInstant(OffsetDateTime.now().getOffset()));
    }

}
