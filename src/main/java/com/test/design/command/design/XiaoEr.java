package com.test.design.command.design;

import com.test.design.command.design.cuisine.ICuisine;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-24 22:16
 * @description: 命令调用者
 **/
@Slf4j
public class XiaoEr {

  private List<ICuisine> cuisineList = new ArrayList<ICuisine>();

  public void order(ICuisine cuisine) {
    cuisineList.add(cuisine);
  }


  public synchronized void placeOrder() {
    for (ICuisine cuisine : cuisineList) {
      cuisine.cook();
    }
    cuisineList.clear();
  }
}
