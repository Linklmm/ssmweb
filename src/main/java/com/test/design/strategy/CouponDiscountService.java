package com.test.design.strategy;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-28 21:34
 * @description: 优惠券折扣计算接口 ----- 策略者模式
 **/
public class CouponDiscountService {

  /**
   *
   * @param type 优惠券类型
   * @param typeContent 优惠券金额
   * @param skuPrice 商品金额
   * @param typeExt 优惠券扩展
   * @return
   */
  public double discountAmount(int type, double typeContent, double skuPrice, double typeExt) {
    // 1. 直减券
    if (1 == type) {
      return skuPrice - typeContent;
    }
    // 2. 满减券
    if (2 == type) {
      if (skuPrice < typeExt) return skuPrice;
      return skuPrice - typeContent;
    }
    // 3. 折扣券
    if (3 == type) {
      return skuPrice * typeContent;
    }
    // 4. n元购
    if (4 == type) {
      return typeContent;
    }
    return 0D;
  }
}
