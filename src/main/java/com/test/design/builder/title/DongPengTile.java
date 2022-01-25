package com.test.design.builder.title;

import com.test.design.builder.Matter;
import java.math.BigDecimal;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-01-25 20:42
 * @description: 东鹏
 **/
public class DongPengTile implements Matter {

  @Override
  public String scene() {
    return "地砖";
  }

  public String brand() {
    return "东鹏瓷砖";
  }

  public String model() {
    return "10001";
  }

  public BigDecimal price() {
    return new BigDecimal(102);
  }

  public String desc() {
    return "东鹏瓷砖以品质铸就品牌，科技推动品牌，口碑传播品牌为宗旨，2014年品牌价值132.35亿元，位列建陶行业榜首。";
  }

}
