package com.test.design.flyweight.domain;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-22 20:27
 * @description: 活动类
 **/
@Getter
@Setter
public class Activity {
  private Long id;        // 活动ID
  private String name;    // 活动名称
  private String desc;    // 活动描述
  private Date startTime; // 开始时间
  private Date stopTime;  // 结束时间
  //可变的
  private Stock stock;    // 活动库存
}
