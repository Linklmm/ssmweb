package com.test.design.adapter.adapter.impl;

import com.test.design.adapter.adapter.OrderAdapterService;
import com.test.design.adapter.service.OrderService;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-15 21:36
 * @description: 内部商品接口
 **/
public class InsideOrderService implements OrderAdapterService {

  private OrderService orderService = new OrderService();

  @Override
  public boolean isFirst(String uId) {
    return orderService.queryUserOrderCount(uId) <= 1;
  }
}
