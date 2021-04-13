package com.test.test.dateTime;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
public class TestDateTime {
    /**
     * UTC时间处理
     */
    @Test
    public void testUTCTransDateTime() {
        String utcTime = "2020-10-23T11:43:11.058Z";
        DateTimeFormatter utc = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").withZone(ZoneOffset.UTC);
        DateTimeFormatter local = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").withZone(ZoneId.systemDefault());
        Instant instant = Instant.from(utc.parse(utcTime));
        log.error("time:{}", local.format(instant));
        LocalDateTime now = LocalDateTime.now();
        log.error("hour is {}", now.getHour());
        log.error("dayOfYear is {}", now.getDayOfYear());
        log.error("year is {}", now.getYear());
        LocalDateTime afterHour = now.plusHours(1);
        if (now.isBefore(afterHour)) {
            log.error("晚一个小时,now:{},afterHour:{}", now, afterHour);
        }
        DateTimeFormatter FOREIGN_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("MMM d, yyyy HH:mm").withZone(ZoneId.systemDefault());
        log.error("time:{}", FOREIGN_DATE_TIME_FORMATTER.format(instant));
        log.error("localDate:{}", LocalDate.now());
        log.error("date:{}", new Date());
        DateTimeFormatter CTS_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss").withZone(ZoneId.systemDefault());
        log.error("instant:{}", Instant.now().toString());
//        log.error("new instant:{}",instant);
        log.error("time:{}", CTS_FORMATTER.format(Instant.now()));
        log.error("message:{}", MessageFormat.format("{0}{1}{2}", "", "123", " hello word"));

    }

    public static String getStartOrEndDayOfWeek(LocalDateTime today, Boolean isFirst) {
        LocalDateTime resDate = LocalDateTime.now();
        if (today == null) {
            today = resDate;
        }
        DayOfWeek week = today.getDayOfWeek();
        int value = week.getValue();
        if (isFirst) {
            resDate = today.minusDays(value - 1);
        } else {
            resDate = today.plusDays(7 - value);
        }
        return resDate.toString();
    }

    public static void main(String[] args) {
        System.out.println(getStartOrEndDayOfWeek(null, Boolean.TRUE));
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4);
        List<Integer> nums = Optional.of(list.stream().filter(i -> i == 1).collect(Collectors.toList())).orElse(Collections.emptyList());
        System.out.println(0 == nums.size() ? null : nums.get(0));
        String s = String.format("lmm %s ", "大帅哥");
        System.out.println(s);
//        User user = new User();
//        if (Objects.nonNull(user.getRequestA().getName())){
//            System.out.println("meiyou");
//        }else {
//            System.out.println("you");
//        }

        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            log.error("jjjjj:{}", 22, e);
        }
        System.out.println(String.class.getTypeName());
        System.out.println(Long.class.getSimpleName());
        Instant old = Instant.ofEpochSecond(1613913681L);
        Instant now = Instant.now();
        System.out.println(Duration.between(now, old));
    }
}
