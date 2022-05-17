package com.test.test;

import com.test.test.pojo.TestDelayed;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Random;
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

    log.info((delayQueue.take()).getStr());
    log.info((delayQueue.take()).getStr());
    log.info((delayQueue.take()).getStr());
  }

  @Test
  public void testCollections() {

    List<String> list = new ArrayList<String>();
    list.add("1");
    list.add("2");
    list.add("3");
    list.add("4");
    list.add("5");
    list.add("6");
    list.add("7");
    list.add("8");
    int idx = Collections.binarySearch(list, "5");
    log.error("idx:{}", idx);
  }

  /**
   * 洗牌算法
   */
  @Test
  public void testShuffle() {
    List<String> list = new ArrayList<String>();
    list.add("1");
    list.add("2");
    list.add("3");
    list.add("4");
    list.add("5");
    list.add("6");
    list.add("7");
    list.add("8");

    Random random = new Random();
    for (int i = list.size(); i > 1; i--) {
      int ri = random.nextInt(i);  // 随机位置
      int ji = i - 1;              // 顺延
      //System.out.println("ri：" + ri + " ji：" + ji);
      log.error("ri:{},ji:{}", ri, ji);
      list.set(ji, list.set(ri, list.get(ji)));        // 元素置换
    }
    log.error("list:{}", list);

  }

  /**
   * 旋转算法，可以把ArrayList或者Linkedlist，从指定的某个位置开始，进行正旋或者逆旋操作。 有点像把集合理解成圆盘，把要的元素转到自己这，其他的元素顺序跟随。
   */
  @Test
  public void testRotate() {
    List<String> list = new ArrayList<String>();
    list.add("7");
    list.add("4");
    list.add("8");
    list.add("3");
    list.add("9");
    Collections.rotate(list, 2);
    log.error("list:{}", list);
  }

  /**
   * 测试sb和string的速度
   */
  @Test
  public void testString() {
    Instant start = Instant.now();
    String s = "";
    for (int i = 0; i < 100000; i++) {
      s += i;
    }
    log.error("time:{}", Duration.between(Instant.now(), start).toMillis());

    Instant sStart = Instant.now();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 100000; i++) {
      sb.append(i);
    }
    log.error("sb time:{}", Duration.between(Instant.now(), sStart).toMillis());

    Instant sbStart = Instant.now();
    StringBuffer sb2 = new StringBuffer();
    for (int i = 0; i < 100000; i++) {
      sb2.append(i);
    }
    log.error("sb2 time:{}", Duration.between(Instant.now(), sbStart).toMillis());
  }

  @Test
  public void testStr() {
    String str = new String("ab");
    String str2 = new String("ab");
    String str3 = "ab";

    //false 两个对象的比较
    log.error("str == str2 :{}", str == str2);
    //false 相当于 str == str3
    log.error("str == str2.intern():{}", str == str2.intern());
    //true intern是吧值直接推进了常量池，得到的是常量池的值
    log.error("str.intern() == str2.intern():{}", str.intern() == str2.intern());
    //false 这里比对的是引用地址，因为str是new出来的对象，是个新的引用地址，str3不会重新创建对象，是直接指向运行时常量池的，所以两者不等
    log.error("str == str3:{}", str == str3);
    //true intern是吧值直接推进了常量池，得到的是常量池的值，str3是常量池中的值，固两者相等。
    log.error("str.intern() == str3:{}", str.intern() == str3);
  }

}
