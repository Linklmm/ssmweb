package com.test.design.bridge.mode;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-16 21:35
 * @description: 刷脸支付模式风控
 **/
@Slf4j
public class PayFaceMode implements IPayMode{

  @Override
  public boolean security(String uId) {
    log.info("人脸支付，风控校验脸部识别");
    return true;
  }
}
