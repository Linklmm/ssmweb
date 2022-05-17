package com.test.design.strategy.event;

import java.math.BigDecimal;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-28 21:49
 * @description: 策略控制类 策略者模式
 **/
public class Context<T> {

  private ICouponDiscount<T> couponDiscount;

  public Context(ICouponDiscount<T> couponDiscount) {
    this.couponDiscount = couponDiscount;
  }

  public BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice) {
    return couponDiscount.discountAmount(couponInfo, skuPrice);
  }
}
