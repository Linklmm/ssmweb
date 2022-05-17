package com.test.design.singleton;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-09 21:18
 * @description: 双重校验锁 线程安全
 **/
public class DoubleSingleton {

  private static volatile DoubleSingleton instance;

  private DoubleSingleton() {
  }

  public static DoubleSingleton getInstance() {
    if (null != instance) {
      return instance;
    }
    synchronized (DoubleSingleton.class) {
      if (null == instance) {
        instance = new DoubleSingleton();
      }
    }
    return instance;
  }

}
