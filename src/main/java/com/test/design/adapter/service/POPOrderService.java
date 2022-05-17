package com.test.design.adapter.service;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-15 20:41
 * @description: 查询用户第三方下单首单接口
 **/
@Slf4j
public class POPOrderService {

  public boolean isFirstOrder(String uId) {
    log.info("pop商家，查询用户的订单是否为首单:{}", uId);
    return true;
  }
}
