package com.test.design.strategy.event.impl;

import com.test.design.strategy.event.ICouponDiscount;
import java.math.BigDecimal;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-28 21:45
 * @description: N元购
 **/
public class NYGCouponDiscount implements ICouponDiscount<Double> {

  /**
   * n元购购买
   * 1. 无论原价多少钱都固定金额购买
   */
  @Override
  public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
    return BigDecimal.valueOf(couponInfo);
  }
}
