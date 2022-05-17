package com.test.design.strategy.event.impl;

import com.test.design.strategy.event.ICouponDiscount;
import java.math.BigDecimal;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-28 21:43
 * @description: 折扣计算=====策略者模式
 **/
public class ZKCouponDiscount implements ICouponDiscount<Double> {

  /**
   *
   * @param couponInfo
   * @param skuPrice
   * @return
   *
   * 1. 使用商品价格乘以折扣比例，为最后支付金额
   *      * 2. 保留两位小数
   *      * 3. 最低支付金额1元
   */
  @Override
  public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
    BigDecimal discountAmount = skuPrice.multiply(BigDecimal.valueOf(couponInfo))
        .setScale(2, BigDecimal.ROUND_HALF_UP);
    //Discount <=0
    if (discountAmount.compareTo(BigDecimal.ZERO) < 1) {
      return BigDecimal.ONE;
    }
    return discountAmount;
  }
}
