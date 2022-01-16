package com.test.design.builder.coat;

import com.test.design.builder.Matter;
import java.math.BigDecimal;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-01-14 08:41
 * @description: 立邦
 **/
public class LiBangCoat implements Matter {
  public String scene() {
    return "涂料";
  }

  public String brand() {
    return "立邦";
  }

  public String model() {
    return "默认级别";
  }

  public BigDecimal price() {
    return new BigDecimal(650);
  }

  public String desc() {
    return "立邦始终以开发绿色产品、注重高科技、高品质为目标，以技术力量不断推进科研和开发，满足消费者需求。";
  }
}
