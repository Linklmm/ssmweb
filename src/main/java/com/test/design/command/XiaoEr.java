package com.test.design.command;

import com.alibaba.fastjson.JSON;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-24 22:09
 * @description: 小二类-----命令模式
 **/
@Slf4j
public class XiaoEr {

  private Map<Integer, String> cuisineMap = new ConcurrentHashMap<>();

  //点菜
  public void order(int cuisine) {
    // 广东（粤菜）
    if (1 == cuisine) {
      cuisineMap.put(1, "广东厨师，烹饪鲁菜，宫廷最大菜系，以孔府风味为龙头");
    }

    // 江苏（苏菜）
    if (2 == cuisine) {
      cuisineMap.put(2, "江苏厨师，烹饪苏菜，宫廷第二大菜系，古今国宴上最受人欢迎的菜系。");
    }

    // 山东（鲁菜）
    if (3 == cuisine) {
      cuisineMap.put(3, "山东厨师，烹饪鲁菜，宫廷最大菜系，以孔府风味为龙头.");
    }

    // 四川（川菜）
    if (4 == cuisine) {
      cuisineMap.put(4, "四川厨师，烹饪川菜，中国最有特色的菜系，也是民间最大菜系。");
    }
  }

  /**
   * 展示菜品
   */
  public void placeOrder() {
    log.info("菜单：{}", JSON.toJSONString(cuisineMap));
  }
}
