package com.test.design.command.design.cuisine.impl;

import com.test.design.command.design.cook.ICook;
import com.test.design.command.design.cuisine.ICuisine;
import lombok.AllArgsConstructor;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-24 22:21
 * @description: 四川菜
 **/
@AllArgsConstructor
public class SichuanCuisine implements ICuisine {

  private ICook iCook;
  @Override
  public void cook() {
    iCook.doCooking();
  }
}
