package com.test.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-06-29 22:56
 * @description: 测试线程池
 **/
@Slf4j
public class TestThread {

  public static final ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(10, 10, 0L,
      TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10));

  @Test
  public void testThread() {
    log.error("=======任务<=corePoolSize=====");
    for (int i = 0; i < 10; i++) {
      THREAD_POOL_EXECUTOR.execute(() -> {
        Thread thread = Thread.currentThread();
        log.error("hello 线程池!,name:{}", thread.getName());
      });
    }
    log.error("=======任务<=corePoolSize&&任务<workQueue.size()=====");
    for (int i = 0; i < 11; i++) {
      THREAD_POOL_EXECUTOR.execute(() -> {
        Thread thread = Thread.currentThread();
        log.error("hello 线程池!,name:{}", thread.getName());
      });
    }

  }
}
