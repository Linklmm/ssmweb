package com.test.design.builder;

import java.math.BigDecimal;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-01-14 08:38
 * @description: 物料接口
 **/
public interface Matter {
  String scene();      // 场景；地板、地砖、涂料、吊顶

  String brand();      // 品牌

  String model();      // 型号

  BigDecimal price();  // 价格

  String desc();       // 描述
}
