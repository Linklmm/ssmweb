package com.test.design.adapter.adapter.pojo;

import java.util.Date;
import lombok.Data;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-15 20:55
 * @description: 统一的Mq消息体
 **/
@Data
public class RebateInfo {

  private String userId;  // 用户ID
  private String bizId;   // 业务ID
  private Date bizTime;   // 业务时间
  private String desc;    // 业务描述
}
