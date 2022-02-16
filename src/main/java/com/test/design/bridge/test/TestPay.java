package com.test.design.bridge.test;

import com.test.design.bridge.PayController;
import com.test.design.bridge.channel.Pay;
import com.test.design.bridge.channel.WxPay;
import com.test.design.bridge.channel.ZfbPay;
import com.test.design.bridge.mode.PayFaceMode;
import com.test.design.bridge.mode.PayFingerprintMode;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-16 21:22
 * @description: 测试类
 **/
public class TestPay {

  /**
   * 正常模式下
   */
  @Test
  public void testNormal() {
    PayController pay = new PayController();
    System.out.println("\r\n模拟测试场景；微信支付、人脸方式。");
    pay.doPay("weixin_1092033111", "100000109893", new BigDecimal(100), 1, 2);

    System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
    pay.doPay("jlu19dlxo111", "100000109894", new BigDecimal(100), 2, 3);
  }

  /**
   * 桥接模式下
   * 支付类型下有多种不同的支付模式，造成笛卡尔积，
   * 所以桥接模式是通过组合的方式来降低if else的编写
   * 外部的使用接口的用户不需要关心具体的实现，只按需选择使用即可。
   */
  @Test
  public void testBridge(){
    System.out.println("\r\n模拟测试场景；微信支付、人脸方式。");
    Pay wxPay = new WxPay(new PayFaceMode());
    wxPay.transfer("weixin_1092033111", "100000109893", new BigDecimal(100));

    System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
    Pay zfbPay = new ZfbPay(new PayFingerprintMode());
    zfbPay.transfer("jlu19dlxo111","100000109894",new BigDecimal(100));
  }
}
