package com.test.design.strategy.event;

import java.math.BigDecimal;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-28 21:36
 * @description: 优惠券接口------策略者模式
 **/
public interface ICouponDiscount<T> {

  /**
   * 优惠券金额计算
   * @param couponInfo
   * @param skuPrice
   * @return
   */
  BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice);

}
