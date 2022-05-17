package com.test.Theread.rtl;

import java.util.concurrent.locks.ReentrantLock;
import org.junit.jupiter.api.Test;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-03-16 22:51
 * @description: 测试ReentrantLock公平锁
 **/
public class TestReentrantLock {

  @Test
  public void testReentrantLock() {
    //默认非公平锁
    ReentrantLock lock = new ReentrantLock(true);
    lock.lock();
    try {

    } finally {
      lock.unlock();
    }

  }
}
