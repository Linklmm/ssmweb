package com.test.design.singleton;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-09 21:37
 * @description: 枚举单例模式 推荐 线程安全
 * Effective Java 作者推荐使用枚举的方式解决单例模式，此种方式可能是平时最少用到的。
 * 这种方式解决了最主要的；线程安全、自由串行化、单一实例。
 **/
public enum EnumSingleton {
  INSTANCE;
  public void test(){
    System.out.println("hello singleton");
  }
}
