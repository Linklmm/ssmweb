package com.test.design.bridge.channel;

import com.test.design.bridge.mode.IPayMode;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-16 21:26
 * @description: 微信支付-桥接模式
 **/
@Slf4j
public class WxPay extends Pay{

  public WxPay(IPayMode payMode) {
    super(payMode);
  }

  @Override
  public String transfer(String uId, String tradeId, BigDecimal amount) {
    log.info("模拟微信渠道支付划账开始。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
    boolean security = payMode.security(uId);
    log.info("模拟微信渠道支付风控校验。uId：{} tradeId：{} security：{}", uId, tradeId, security);
    if (!security) {
      log.info("模拟微信渠道支付划账拦截。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
      return "0001";
    }
    log.info("模拟微信渠道支付划账成功。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
    return "0000";
  }
}
