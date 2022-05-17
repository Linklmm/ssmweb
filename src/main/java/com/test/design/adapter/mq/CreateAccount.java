package com.test.design.adapter.mq;

import java.util.Date;
import lombok.Data;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-15 20:35
 * @description: 注册开户mq
 **/
@Data
public class CreateAccount {

  /**
   * 开户编号
   */
  private String number;
  /**
   * 开户地
   */
  private String address;
  /**
   * 开户时间
   */
  private Date accountDate;
  /**
   * 开户描述
   */
  private String desc;

}
