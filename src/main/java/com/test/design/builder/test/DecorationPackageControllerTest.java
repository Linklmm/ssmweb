package com.test.design.builder.test;

import com.test.design.builder.design.original.DecorationPackageController;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-01-25 20:57
 * @description: 测试类
 **/
public class DecorationPackageControllerTest {

  @Test
  public void testIfElse() {
    DecorationPackageController decorationPackageController = new DecorationPackageController();
    System.out.println(decorationPackageController.getMatterList(new BigDecimal("132.52"), 1));
    System.out.println(decorationPackageController.getMatterList(new BigDecimal("98.25"), 2));
    System.out.println(decorationPackageController.getMatterList(new BigDecimal("85.43"), 3));
  }

  @Test
  public void testBuilder() {
    DecorationPackageController decorationPackageController = new DecorationPackageController();
    System.out.println(decorationPackageController.getMatterListByBuilder(new BigDecimal("132.52"),1));
    System.out.println(decorationPackageController.getMatterListByBuilder(new BigDecimal("98.25"),2));
    System.out.println(decorationPackageController.getMatterListByBuilder(new BigDecimal("85.43"),3));

  }
}
