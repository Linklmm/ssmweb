package com.test.Theread.vt;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-03-15 20:07
 * @description: 测试volatile可见性
 **/
@Slf4j
public class TestVolatile {

  public static void main(String[] args) throws InterruptedException {
    final Sign vt = new Sign();
    Thread thread1 = new Thread(vt);
    Thread thread2 = new Thread(() -> {
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      //这个时候应该会输出 《sign改变》但实际只会打印下面的一句。永远不会输出《sign改变》
      vt.sign = true;
      log.error("vt.sign = true while 循环结束");
    });

    thread1.start();
    thread2.start();
    Thread.sleep(3000);
  }

  /**
   * volatile保证线程的可见性
   */
  @Test
  public void testVolatile() throws InterruptedException {
    final VolatileSign vs = new VolatileSign();
    Thread thread1 = new Thread(vs);
    Thread thread2 = new Thread(() -> {
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      //这个时候应该会输出两句
      vs.sign = true;
      log.error("vt.sign = true while 循环结束");
    });

    thread1.start();
    thread2.start();
    //等待两个线程执行完
    Thread.sleep(3000);


  }

}
