package com.test.design.adapter.adapter.impl;

import com.test.design.adapter.adapter.OrderAdapterService;
import com.test.design.adapter.service.POPOrderService;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-15 21:37
 * @description: 第三方商品接口
 **/
public class POPOrderAdapterServiceImpl implements OrderAdapterService {

  private POPOrderService popOrderService = new POPOrderService();

  @Override
  public boolean isFirst(String uId) {
    return popOrderService.isFirstOrder(uId);
  }
}
