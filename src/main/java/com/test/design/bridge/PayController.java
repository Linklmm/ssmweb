package com.test.design.bridge;

import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-16 21:17
 * @description: 支付-桥接模式
 * 有支付类型和支付模式
 * 固将两个抽出各自翻到 channel 包和 mode 包下
 **/
@Slf4j
public class PayController {

  public boolean doPay(String uId, String tradeId, BigDecimal amount, int channelType,
      int modeType) {
    if (1 == channelType) {
      log.info("模拟微信渠道支付划账开始。uId:{} tradeId:{} amount:{}", uId, tradeId, amount);
      /**
       * 这里为支付模式的各种风控
       */
      if (1 == modeType) {
        log.info("密码支付，风控校验环境安全");
      }else if (2 == modeType){
        log.info("人脸支付，风控校验脸部识别");
      } else if (3 == modeType) {
        log.info("指纹支付,风控校验指纹信息");
      }
    }
    //支付宝支付
    else if (2 == channelType) {
      log.info("模拟支付宝渠道支付划账开始。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
      if (1 == modeType) {
        log.info("密码支付，风控校验环境安全");
      } else if (2 == modeType) {
        log.info("人脸支付，风控校验脸部识别");
      } else if (3 == modeType) {
        log.info("指纹支付，风控校验指纹信息");
      }
    }
    return true;

  }
}
