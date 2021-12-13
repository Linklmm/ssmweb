package com.test.algorithm.leetCode.thread;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2021-07-18 10:28
 * @description: 按序打印
 **/
public class Foo {
  private AtomicInteger firstJobDone = new AtomicInteger(0);
  private AtomicInteger secondJobDone = new AtomicInteger(0);
  public Foo() {

  }

  public void first(Runnable printFirst) throws InterruptedException {

    // printFirst.run() outputs "first". Do not change or remove this line.
    printFirst.run();
  }

  public void second(Runnable printSecond) throws InterruptedException {

    // printSecond.run() outputs "second". Do not change or remove this line.
    printSecond.run();
  }

  public void third(Runnable printThird) throws InterruptedException {

    // printThird.run() outputs "third". Do not change or remove this line.
    printThird.run();
  }
}
