package com.test.design.flyweight.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-22 20:33
 * @description: 模拟Redis操作
 **/
public class RedisUtils {
  private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

  private AtomicInteger stock = new AtomicInteger(0);

  public RedisUtils() {
    scheduledExecutorService.scheduleAtFixedRate(() -> {
      // 模拟库存消耗
      stock.addAndGet(1);
    }, 0, 100000, TimeUnit.MICROSECONDS);

  }

  public int getStockUsed() {
    return stock.get();
  }
}
