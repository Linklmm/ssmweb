package com.test.design.builder.design.builder;

import com.test.design.builder.Matter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-01-25 21:04
 * @description: Imenu接口具体实现类
 **/
public class PackageMenu implements IMenu {

  private List<Matter> matters = new ArrayList<>();
  private BigDecimal price = BigDecimal.ZERO;

  /**
   * 面积
   */
  private BigDecimal area;
  /**
   * 套餐等级
   */
  private String grade;

  public PackageMenu() {
  }

  public PackageMenu(BigDecimal area, String grade) {
    this.area = area;
    this.grade = grade;
  }

  @Override
  public IMenu appendCeiling(Matter matter) {
    matters.add(matter);
    price = price.add(area.multiply(new BigDecimal("0.2")).multiply(matter.price()));
    return this;
  }

  @Override
  public IMenu appendCoat(Matter matter) {
    matters.add(matter);
    price = price.add(area.multiply(new BigDecimal("1.4")).multiply(matter.price()));
    return this;
  }

  @Override
  public IMenu appendFloor(Matter matter) {
    matters.add(matter);
    price = price.add(area.multiply(matter.price()));
    return this;
  }

  @Override
  public IMenu appendTile(Matter matter) {
    matters.add(matter);
    price = price.add(area.multiply(matter.price()));
    return this;
  }

  @Override
  public String getDetail() {
    StringBuilder detail = new StringBuilder(
        "\r\n-------------------------------------------------------\r\n" +
            "装修清单" + "\r\n" +
            "套餐等级：" + grade + "\r\n" +
            "套餐价格：" + price.setScale(2, BigDecimal.ROUND_HALF_UP) + " 元\r\n" +
            "房屋面积：" + area.doubleValue() + " 平米\r\n" +
            "材料清单：\r\n");

    for (Matter matter : matters) {
      detail.append(matter.scene()).append("：").append(matter.brand()).append("、")
          .append(matter.model()).append("、平米价格：").append(matter.price()).append(" 元。\n");
    }

    return detail.toString();
  }
}
