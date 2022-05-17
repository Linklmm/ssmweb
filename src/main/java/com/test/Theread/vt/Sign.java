package com.test.Theread.vt;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-03-15 20:19
 * @description: Volatile
 **/
@Slf4j
public class Sign implements Runnable {

  public boolean sign = false;

  @Override
  public void run() {
    while (!sign) {

    }
    log.error("sign改变");
  }

}
