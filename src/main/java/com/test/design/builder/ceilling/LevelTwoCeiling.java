package com.test.design.builder.ceilling;

import com.test.design.builder.Matter;
import java.math.BigDecimal;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-01-14 08:39
 * @description: 二级吊顶
 **/
public class LevelTwoCeiling implements Matter {

  public String scene() {
    return "吊顶";
  }

  public String brand() {
    return "装修公司自带";
  }

  public String model() {
    return "二级顶";
  }

  public BigDecimal price() {
    return new BigDecimal(850);
  }

  public String desc() {
    return "两个层次的吊顶，二级吊顶高度一般就往下吊20cm，要是层高很高，也可增加每级的厚度";
  }
}
