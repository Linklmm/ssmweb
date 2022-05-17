package com.test.design.strategy.test;

import com.test.design.strategy.event.Context;
import com.test.design.strategy.event.impl.MJCouponDiscount;
import com.test.design.strategy.event.impl.ZKCouponDiscount;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-28 21:51
 * @description: 测试策略类
 *
 * 通过策略设计模式的使用可以把我们方法中的if语句优化掉，大量的if语句使用会让代码难以扩展，也不好维护，
 * 同时在后期遇到各种问题也很难维护。在使用这样的设计模式后可以很好的满足隔离性与和扩展性，对于不断新增的需求也非常方便承接。
 **/
@Slf4j
public class TestStrategy {

  @Test
  public void testMj() {
    // 满100减10，商品100元
    Context<Map<String, String>> context = new Context<Map<String, String>>(new MJCouponDiscount());
    Map<String, String> mapReq = new HashMap<String, String>();
    mapReq.put("x", "100");
    mapReq.put("n", "10");
    BigDecimal discountAmount = context.discountAmount(mapReq, new BigDecimal(100));
    log.info("测试结果：满减优惠后金额 {}", discountAmount);
  }

  @Test
  public void TestZk() {
    // 折扣9折，商品100元
    Context<Double> context = new Context<Double>(new ZKCouponDiscount());
    BigDecimal discountAmount = context.discountAmount(0.9D, new BigDecimal(100));
    log.info("测试结果：折扣9折后金额 {}", discountAmount);
  }

}
