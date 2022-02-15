package com.test.design.adapter.consumer;

import com.alibaba.fastjson.JSON;
import com.test.design.adapter.mq.OrderMq;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-15 20:48
 * @description: 内部订单mq接收器
 **/
public class OrderMqService {

  public void onMessage(String message){
    OrderMq mq = JSON.parseObject(message,OrderMq.class);
    mq.getUid();
    mq.getOrderId();
    mq.getCreateOrderTime();
    //......

  }
}
