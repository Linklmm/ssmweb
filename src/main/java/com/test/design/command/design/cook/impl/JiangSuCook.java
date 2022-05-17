package com.test.design.command.design.cook.impl;

import com.test.design.command.design.cook.ICook;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-24 22:24
 * @description: 苏菜
 **/
@Slf4j
public class JiangSuCook implements ICook {

  @Override
  public void doCooking() {
    log.info("江苏厨师，烹饪苏菜，宫廷第二大菜系，古今国宴上最受人欢迎的菜系。");
  }
}
