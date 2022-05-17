package com.test.test.pojo;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import lombok.Getter;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-03-03 22:13
 * @description: 延时队列
 **/
public class TestDelayed implements Delayed {

  @Getter
  private String str;
  private long time;

  public TestDelayed(String str, long time, TimeUnit unit) {
    this.str = str;
    this.time = System.currentTimeMillis() + (time > 0 ? unit.toMillis(time) : 0);
  }

  @Override
  public long getDelay(TimeUnit unit) {
    return time - System.currentTimeMillis();
  }

  @Override
  public int compareTo(Delayed o) {
    TestDelayed work = (TestDelayed) o;
    long diff = this.time - work.time;
    if (diff <= 0) {
      return -1;
    } else {
      return 1;
    }
  }

}
