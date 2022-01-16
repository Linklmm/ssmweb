package com.test.design.builder.floor;

import com.test.design.builder.Matter;
import java.math.BigDecimal;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-01-14 08:42
 * @description: 德尔
 **/
public class DerFloor implements Matter {

  public String scene() {
    return "地板";
  }

  public String brand() {
    return "德尔(Der)";
  }

  public String model() {
    return "A+";
  }

  public BigDecimal price() {
    return new BigDecimal(119);
  }

  public String desc() {
    return "DER德尔集团是全球领先的专业木地板制造商，北京2008年奥运会家装和公装地板供应商";
  }
}