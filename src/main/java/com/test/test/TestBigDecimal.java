package com.test.test;

import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-04-30 15:57
 * @description: 测试bigDecimal
 **/
@Slf4j
public class TestBigDecimal {

  @Test
  public void testDouble() {
    double d = 1.03;
    double d2 = 0.42;
    double d3 = d - d2;
    log.error("d:{}", d - d2);
    log.error("bigDecimal:{}", new BigDecimal(d3));
    log.error("bigDecimal String:{}", new BigDecimal(String.valueOf(d3)));
    log.error("bigDecimal String:{}", BigDecimal.valueOf(d3));
  }

  @Test
  public void testBigDecimal() {
    BigDecimal d1 = new BigDecimal("1.03");
    BigDecimal d2 = new BigDecimal("0.42");
    log.error("sub:{}", d1.subtract(d2));
  }

  @Test
  public void testDoubleToBigDecimal() {
    double d = 1.03;
    double d2 = 0.42;
    double d3 = d - d2;
    log.error("double to bigDecimal:{}", new BigDecimal(d3));
    log.error("bigDecimal valueOf:{}", BigDecimal.valueOf(d3));
    log.error("0.1bigDecimal :{}", new BigDecimal(0.1));
    log.error("0.1bigDecimal :{}", BigDecimal.valueOf(0.1));
    log.error("================");
    BigDecimal b1 = BigDecimal.valueOf(d);
    BigDecimal b2 = BigDecimal.valueOf(d2);
    log.error("double to bigDecimal:{}", b1.subtract(b2));
  }

  @Test
  public void testBigDecimalCompare() {
    BigDecimal b1 = new BigDecimal("1.1");
    BigDecimal b2 = new BigDecimal("1.10");
    log.error("b1 == b2 :{}", b1.equals(b2));
    log.error("============");
    log.error("b1 == b2 :{}", b1.compareTo(b2) == 0);
  }

  @Test
  public void testBigDecimalToOtherData(){
    BigDecimal b1 = new BigDecimal("0.5");
    log.error("b1 long:{}",b1.longValue());
    log.error("b1 double:{}",b1.doubleValue());

    BigDecimal b2 = new BigDecimal("1.9");
    log.error("b2 long:{}",b2.longValue());
    log.error("b2 double:{}",b2.doubleValue());
  }

}
