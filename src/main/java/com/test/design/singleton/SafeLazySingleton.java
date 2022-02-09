package com.test.design.singleton;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-09 21:07
 * @description: 懒汉模式 线程安全
 **/
public class SafeLazySingleton {

  private static SafeLazySingleton instance;

  private SafeLazySingleton() {
  }

  public static synchronized SafeLazySingleton getInstance() {
    if (null != instance) {
      return instance;
    }
    instance = new SafeLazySingleton();
    return instance;
  }
}
