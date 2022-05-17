package com.test.design.adapter.consumer;

import com.alibaba.fastjson.JSON;
import com.test.design.adapter.mq.CreateAccount;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-15 20:50
 * @description: 注册开户mq消费者
 **/
public class CreateAccountMqService {

  public void onMessage(String message) {

    CreateAccount mq = JSON.parseObject(message, CreateAccount.class);

    mq.getNumber();
    mq.getAccountDate();

    // ... 处理自己的业务
  }
}
