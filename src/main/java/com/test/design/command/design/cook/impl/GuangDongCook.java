package com.test.design.command.design.cook.impl;

import com.test.design.command.design.cook.ICook;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-24 22:22
 * @description: 粤菜厨师---命令模式----命令具体实现者
 **/
@Slf4j
public class GuangDongCook implements ICook {

  @Override
  public void doCooking() {
    log.info("广东厨师，烹饪粤菜，内民间第二大菜系，国外最有影响力的中国菜系，可以代表中国");
  }
}
