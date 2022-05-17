package com.test.design.singleton;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-09 21:11
 * @description: 饿汉模式 线程安全
 **/
public class HungarySingleton {

  private static HungarySingleton instance = new HungarySingleton();

  private HungarySingleton() {
  }

  public static HungarySingleton getInstance() {
    return instance;
  }
}
