package com.test.design.command.design.cook.impl;

import com.test.design.command.design.cook.ICook;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-24 22:25
 * @description: 山东菜
 **/
@Slf4j
public class ShangDongCook implements ICook {

  @Override
  public void doCooking() {
    log.info("山东厨师，烹饪鲁菜，宫廷最大菜系，以孔府风味为龙头");
  }
}
