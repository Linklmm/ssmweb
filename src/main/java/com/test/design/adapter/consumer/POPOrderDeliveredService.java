package com.test.design.adapter.consumer;

import com.alibaba.fastjson.JSON;
import com.test.design.adapter.mq.POPOrderDelivered;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-15 20:49
 * @description: 第三方订单mq接收器
 **/
public class POPOrderDeliveredService {

  public void onMessage(String message) {

    POPOrderDelivered mq = JSON.parseObject(message, POPOrderDelivered.class);

    mq.getUId();
    mq.getOrderId();
    mq.getOrderTime();

    // ... 处理自己的业务
  }
}
