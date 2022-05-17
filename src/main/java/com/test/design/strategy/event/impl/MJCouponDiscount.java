package com.test.design.strategy.event.impl;

import com.test.design.strategy.event.ICouponDiscount;
import java.math.BigDecimal;
import java.util.Map;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-28 21:38
 * @description: 满减优惠券计算接口实现-------策略者模式
 **/
public class MJCouponDiscount implements ICouponDiscount<Map<String, String>> {

  @Override
  public BigDecimal discountAmount(Map<String, String> couponInfo, BigDecimal skuPrice) {
    //满减条件
    String x = couponInfo.get("x");
    //满减金额
    String o = couponInfo.get("n");

    //小于商品金额条件的，直接返回商品原价
    //小于满减条件
    if (skuPrice.compareTo(new BigDecimal(x)) < 0) {
      return skuPrice;
    }
    // 减去优惠金额判断
    BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(o));
    if (discountAmount.compareTo(BigDecimal.ZERO) < 1) {
      return BigDecimal.ONE;
    }

    return discountAmount;
  }
}
