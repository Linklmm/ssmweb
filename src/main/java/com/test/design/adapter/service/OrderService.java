package com.test.design.adapter.service;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-15 20:40
 * @description: 查询用户内部下单数量的接口
 **/
@Slf4j
public class OrderService {

  public long queryUserOrderCount(String userId) {
    log.info("自营商家，查询用户的订单是否为首单:{}", userId);
    return 10L;
  }
}
