package com.test.design.bridge.mode;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-16 21:36
 * @description: 指纹支付模式风控
 **/
@Slf4j
public class PayFingerprintMode implements IPayMode {

  @Override
  public boolean security(String uId) {
    log.info("指纹支付，风控校验指纹信息");
    return true;
  }
}
