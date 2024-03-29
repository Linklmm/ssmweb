package com.test.design.singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-09 21:26
 * @description: cas方式创建 线程安全
 * java并发库提供了很多原子类来支持并发访问的数据安全性；AtomicInteger、AtomicBoolean、AtomicLong、AtomicReference。
 * AtomicReference<V> 可以封装引用一个V实例，支持并发访问如上的单例方式就是使用了这样的一个特点。
 * 使用CAS的好处就是不需要使用传统的加锁方式保证线程安全，而是依赖于CAS的忙等算法，依赖于底层硬件的实现，来保证线程安全。相对于其他锁的实现没有线程的切换和阻塞也就没有了额外的开销，并且可以支持较大的并发性。
 * 当然CAS也有一个缺点就是忙等，如果一直没有获取到将会处于死循环中。
 **/
public class CASSingleton {

  private static final AtomicReference<CASSingleton> INSTANCE = new AtomicReference<>();

  private static CASSingleton instance;

  private CASSingleton() {

  }

  public static final CASSingleton getInstance() {
    for (; ; ) {
      CASSingleton instance = INSTANCE.get();
      if (null != instance) {
        return instance;
      }
      INSTANCE.compareAndSet(null, new CASSingleton());
      return INSTANCE.get();
    }
  }


}
