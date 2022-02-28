package com.test.design.strategy.event.impl;

import com.test.design.strategy.event.ICouponDiscount;
import java.math.BigDecimal;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-28 21:42
 * @description: 直减优惠券计算========策略模式
 **/
public class ZJCouponDiscount implements ICouponDiscount<Double> {

  @Override
  public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
    //直接减去优惠券金额，无门槛优惠券
    BigDecimal discountAmount = skuPrice.subtract(BigDecimal.valueOf(couponInfo));
    //至少要1元
    //discount<=0
    if (discountAmount.compareTo(BigDecimal.ZERO) < 1) {
      return BigDecimal.ONE;
    }
    return discountAmount;
  }
}
