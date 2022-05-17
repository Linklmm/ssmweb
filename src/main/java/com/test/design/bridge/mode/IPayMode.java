package com.test.design.bridge.mode;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-16 21:28
 * @description: 支付模型的接口：刷脸支付、指纹支付
 **/
public interface IPayMode {

  /**
   * 安全校验接口，任何支付模式都有不同程度的安全风控
   * @param uId
   * @return
   */
  boolean security(String uId);
}
