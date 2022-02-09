package com.test.design.singleton;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-09 21:07
 * @description: 懒汉模式 线程不安全
 **/
public class LazySingleton {

  private static LazySingleton instance;

  private LazySingleton() {
  }

  public static LazySingleton getInstance() {
    if (null != instance) {
      return instance;
    }
    instance = new LazySingleton();
    return instance;
  }
}
