package com.test.Theread.s;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-03-15 20:56
 * @description: Synchronized特性
 **/
@Slf4j
public class TestSynchronized {

  private static volatile int counter = 0;

  public static void main(String[] args) throws InterruptedException {
    for (int i = 0; i < 10; i++) {
      Thread thread = new Thread(() -> {
        for (int j = 0; j < 1000; j++) {
          add();
        }
      });
      thread.start();
    }

    //预期结果 10000，实际并不会达到，主要原因是volatile只保证了可见性，无法保证原子性
    Thread.sleep(1000);
    log.error("counter:{}", counter);
  }

  private static void add() {
    counter++;
  }

  @Test
  public void testSyn() throws InterruptedException {
    for (int i = 0; i < 10; i++) {
      Thread thread = new Thread(() -> {
        for (int j = 0; j < 1000; j++) {
          synAdd();
        }
      });
      thread.start();
    }

    //预期结果 10000，实际结果10000
    Thread.sleep(1000);
    log.error("counter:{}", counter);
  }

  private static synchronized void synAdd() {
    counter++;
  }

}
