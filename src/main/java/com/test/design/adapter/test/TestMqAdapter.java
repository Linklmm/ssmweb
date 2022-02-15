package com.test.design.adapter.test;

import com.alibaba.fastjson.JSON;
import com.test.design.adapter.adapter.MqAdapter;
import com.test.design.adapter.adapter.pojo.RebateInfo;
import com.test.design.adapter.mq.CreateAccount;
import com.test.design.adapter.mq.OrderMq;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-15 21:11
 * @description: 测试mq适配类
 **/
public class TestMqAdapter {

  @Test
  public void testMQAdapter()
      throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
    CreateAccount createAccount = new CreateAccount();
    createAccount.setNumber("100001");
    createAccount.setAddress("河北省.廊坊市.广阳区.大学里职业技术学院");
    createAccount.setAccountDate(new Date());
    createAccount.setDesc("在校开户");

    HashMap<String, String> link01 = new HashMap<String, String>();
    link01.put("userId", "number");
    link01.put("bizId", "number");
    link01.put("bizTime", "accountDate");
    link01.put("desc", "desc");
    RebateInfo rebateInfo01 = MqAdapter.filter(JSON.toJSONString(createAccount), link01);
    System.out.println("mq.createAccount(适配前)" + createAccount.toString());
    System.out.println("mq.createAccount(适配后)" + JSON.toJSONString(rebateInfo01));

    System.out.println("");

    OrderMq orderMq = new OrderMq();
    orderMq.setUid("100001");
    orderMq.setSku("10928092093111123");
    orderMq.setOrderId("100000890193847111");
    orderMq.setCreateOrderTime(new Date());

    HashMap<String, String> link02 = new HashMap<String, String>();
    link02.put("userId", "uid");
    link02.put("bizId", "orderId");
    link02.put("bizTime", "createOrderTime");
    RebateInfo rebateInfo02 = MqAdapter.filter(JSON.toJSONString(orderMq), link02);

    System.out.println("mq.orderMq(适配前)" + orderMq.toString());
    System.out.println("mq.orderMq(适配后)" + JSON.toJSONString(rebateInfo02));
  }
}
