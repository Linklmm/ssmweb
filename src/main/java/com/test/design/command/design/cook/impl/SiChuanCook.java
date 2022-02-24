package com.test.design.command.design.cook.impl;

import com.test.design.command.design.cook.ICook;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-24 22:25
 * @description: 四川菜
 **/
@Slf4j
public class SiChuanCook implements ICook {

  @Override
  public void doCooking() {
    log.info("四川厨师，烹饪川菜，中国最有特色的菜系，也是民间最大菜系。");
  }
}
