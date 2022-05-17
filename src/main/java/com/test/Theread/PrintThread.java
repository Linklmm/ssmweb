package com.test.Theread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2021-07-12 00:06
 * @description: 用三个线程按顺序循环打印abc三个字母
 **/
public class PrintThread implements Runnable {
  private static ReentrantLock lockStatic = new ReentrantLock();
  private static Condition conditionStatic = lockStatic.newCondition();


  private String symbol;
  private Condition conditionA = null;
  private int go = 0;
  private ReentrantLock lock = null;

  private static AtomicInteger i = new AtomicInteger(0);

  public PrintThread(String symbol, Condition conditionA, int go,
      ReentrantLock lock) {
    this.symbol = symbol;
    this.conditionA = conditionA;
    this.go = go;
    this.lock = lock;
  }

  @Override
  public void run() {
    while (true) {
      lock.lock();
      try {
        try {
          while (i.get() % 3 != go) {
            conditionA.wait();
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("result "+symbol);
        i.getAndIncrement();
        conditionA.signalAll();
      } finally {
        lock.unlock();
      }
    }
  }


  public static void main(String[] args) {
    new Thread(new PrintThread("A",conditionStatic,0,lockStatic)).start();
    new Thread(new PrintThread("B",conditionStatic,1,lockStatic)).start();
    new Thread(new PrintThread("C",conditionStatic,2,lockStatic)).start();
  }
}
