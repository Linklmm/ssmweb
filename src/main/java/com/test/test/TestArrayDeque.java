package com.test.test;

import com.test.test.pojo.TestDelayed;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-03-03 21:41
 * @description: 测试双端队列
 **/
@Slf4j
public class TestArrayDeque {

  /**
   * 测试双端队列
   */
  @Test
  public void testArrayDeque() {
    Deque<Integer> deque = new ArrayDeque<>();

    //头插法
    deque.push(1);
    deque.push(2);
    deque.push(3);
    log.error("deque:{}", deque);
    log.error("deque first:{}", deque.getFirst());
    //头插法
    deque.offerFirst(4);
    deque.offerFirst(5);
    deque.offerFirst(6);
    log.error("deque:{}", deque);

    //尾插法
    deque.offerLast(7);
    deque.offerLast(8);
    deque.offerLast(9);
    log.error("deque:{}", deque);
  }

  /**
   * 测试延时队列
   */
  @Test
  public void testDelayedQueue() throws InterruptedException {
    DelayQueue<TestDelayed> delayQueue = new DelayQueue<TestDelayed>();
    delayQueue.offer(new TestDelayed("aaa", 5, TimeUnit.SECONDS));
    delayQueue.offer(new TestDelayed("ccc", 1, TimeUnit.SECONDS));
    delayQueue.offer(new TestDelayed("bbb", 3, TimeUnit.SECONDS));

    log.info(((TestDelayed) delayQueue.take()).getStr());
    log.info(((TestDelayed) delayQueue.take()).getStr());
    log.info(((TestDelayed) delayQueue.take()).getStr());
  }

}
