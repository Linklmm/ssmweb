package com.test.design.adapter.mq;

import java.util.Date;
import lombok.Data;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-15 20:37
 * @description: 内部订单
 **/
@Data
public class OrderMq {

  private String uid;           // 用户ID
  private String sku;           // 商品
  private String orderId;       // 订单ID
  private Date createOrderTime; // 下单时间
}
