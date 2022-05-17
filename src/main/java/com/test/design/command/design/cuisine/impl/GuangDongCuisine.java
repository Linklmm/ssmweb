package com.test.design.command.design.cuisine.impl;

import com.test.design.command.design.cook.ICook;
import com.test.design.command.design.cuisine.ICuisine;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-24 22:17
 * @description: 命令的具体实现者-粤菜
 **/
@AllArgsConstructor
public class GuangDongCuisine implements ICuisine {

  private ICook iCook;

  @Override
  public void cook() {
    iCook.doCooking();
  }
}
