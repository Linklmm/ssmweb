package com.test.design.adapter.test;

import com.test.design.adapter.adapter.OrderAdapterService;
import com.test.design.adapter.adapter.impl.InsideOrderService;
import com.test.design.adapter.adapter.impl.POPOrderAdapterServiceImpl;
import org.junit.jupiter.api.Test;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-15 21:39
 * @description: 测试接口适配类
 **/
public class TestItAdapter {

  @Test
  public void test_itfAdapter() {
    OrderAdapterService popOrderAdapterService = new POPOrderAdapterServiceImpl();
    System.out.println("判断首单，接口适配(POP)：" + popOrderAdapterService.isFirst("100001"));

    OrderAdapterService insideOrderService = new InsideOrderService();
    System.out.println("判断首单，接口适配(自营)：" + insideOrderService.isFirst("100001"));
  }
}
