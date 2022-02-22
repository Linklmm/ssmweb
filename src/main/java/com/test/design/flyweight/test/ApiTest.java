package com.test.design.flyweight.test;

import com.alibaba.fastjson.JSON;
import com.test.design.flyweight.controller.ActivityByFlyweightController;
import com.test.design.flyweight.domain.Activity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-22 20:37
 * @description: 测试类
 **/
@Slf4j
public class ApiTest {

  private ActivityByFlyweightController activityByFlyweightController = new ActivityByFlyweightController();

  @Test
  public void testQueryActivityInfo() throws InterruptedException {
    for (int idx = 0; idx < 10; idx++) {
      long req = 1001L;
      Activity activity = activityByFlyweightController.queryActivityInfo(req);
      log.info("测试结果：{},{}",req, JSON.toJSONString(activity));
      Thread.sleep(1200);
    }
  }
}
