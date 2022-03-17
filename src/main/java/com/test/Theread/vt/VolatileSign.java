package com.test.Theread.vt;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-03-15 20:27
 * @description: 添加Volatile关键字的线程
 **/
@Slf4j
public class VolatileSign implements Runnable{

  public volatile boolean sign = false;

  @Override
  public void run() {
    while (!sign) {

    }
    log.error("volatile sign 改变");
  }
}
