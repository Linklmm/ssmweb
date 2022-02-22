package com.test.design.flyweight.controller;

import com.test.design.flyweight.domain.Activity;
import com.test.design.flyweight.domain.Stock;
import com.test.design.flyweight.factory.ActivityFactory;
import com.test.design.flyweight.util.RedisUtils;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-22 20:35
 * @description: 活动控制类
 * 活动控制类中使用了享元工厂获取活动信息，查询后将库存信息在补充上。因为库存信息是变化的，而活动信息是固定不变的。
 * 最终通过统一的控制类就可以把完整包装后的活动信息返回给调用方。
 **/
public class ActivityByFlyweightController {

  private RedisUtils redisUtils = new RedisUtils();

  public Activity queryActivityInfo(Long id) {
    Activity activity = ActivityFactory.getActivity(id);
    // 模拟从Redis中获取库存变化信息
    Stock stock = new Stock(1000, redisUtils.getStockUsed());
    activity.setStock(stock);
    return activity;
  }
}
