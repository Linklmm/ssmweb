package com.test.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-03-09 22:00
 * @description: ThreadLocal 分析
 **/
@Slf4j
public class TestThreadLocal {

  private static String pattern = "yyyy-MM-dd HH:mm:ss";
  //线程不安全
  private static SimpleDateFormat f = new SimpleDateFormat(pattern);
  //线程安全
  private static ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal
      .withInitial(() -> new SimpleDateFormat(pattern));

  /**
   * SimpleDateFormat会有线程安全问题
   */
  @Test
  public void testSimpleDateFormat() {
    while (true) {
      new Thread(() -> {
        String dateStr = f.format(new Date());
        try {
          Date parseDate = f.parse(dateStr);
          String dateStrCheck = f.format(parseDate);
          boolean equals = dateStr.equals(dateStrCheck);
          log.error("equals:{},dateStr:{},dataStrCheck:{}", equals, dateStr, dateStrCheck);
        } catch (ParseException e) {
          e.printStackTrace();
        }
      }).start();

    }
  }

  @Test
  public void testThreadLocal() {
    while (true) {
      new Thread(() -> {
        String dateStr = threadLocal.get().format(new Date());
        try {
          Date parseDate = threadLocal.get().parse(dateStr);
          String dateStrCheck = threadLocal.get().format(parseDate);
          boolean equals = dateStr.equals(dateStrCheck);
          if (!equals) {
            log.error("equals:{},dateStr:{},dataStrCheck:{}", equals, dateStr, dateStrCheck);
          } else {
            log.error("equals:{}", equals);
          }

        } catch (ParseException e) {
          e.printStackTrace();
        }
      }).start();

    }
  }

  private static AtomicInteger nextHashCode = new AtomicInteger();

  private static final int HASH_INCREMENT = 0x61c88647;

  // 计算哈希
  private static int nextHashCode() {
    return nextHashCode.getAndAdd(HASH_INCREMENT);
  }

  /**
   * threadLocal hash取模的实现方法，通过斐波那契数列来实现hash
   */
  @Test
  public void testThreadLocalHash(){
    int hashCode = 0;
    for (int i = 0; i < 16; i++) {
      hashCode = i * HASH_INCREMENT + HASH_INCREMENT;
      int idx = hashCode & 15;
      System.out.println("斐波那契散列：" + idx + " 普通散列：" + (String.valueOf(i).hashCode() & 15));
    }
  }

}
