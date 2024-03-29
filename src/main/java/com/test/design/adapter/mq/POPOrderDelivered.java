package com.test.design.adapter.mq;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-15 20:38
 * @description: 第三方订单MQ
 **/
@Data
public class POPOrderDelivered {

  private String uId;     // 用户ID
  private String orderId; // 订单号
  private Date orderTime; // 下单时间
  private Date sku;       // 商品
  private Date skuName;   // 商品名称
  private BigDecimal decimal; // 金额
}
