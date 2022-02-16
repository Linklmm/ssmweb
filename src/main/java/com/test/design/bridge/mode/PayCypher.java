package com.test.design.bridge.mode;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-16 21:37
 * @description: 密码支付模式风控
 **/
@Slf4j
public class PayCypher implements IPayMode{

  @Override
  public boolean security(String uId) {
    log.info("密码支付，风控校验环境安全");
    return true;
  }
}
