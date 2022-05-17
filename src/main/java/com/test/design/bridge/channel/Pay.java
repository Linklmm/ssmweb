package com.test.design.bridge.channel;

import com.test.design.bridge.mode.IPayMode;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-16 21:25
 * @description: 支付-桥接模式 支付的抽象基类，实现有：微信支付、支付宝支付
 **/
@Slf4j
public abstract class Pay {

  protected IPayMode payMode;

  public Pay(IPayMode payMode) {
    this.payMode = payMode;
  }

  public abstract String transfer(String uId, String tradeId, BigDecimal amount);
}
