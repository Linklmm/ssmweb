package com.test.design.flyweight.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-22 20:28
 * @description: 库存类
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
  private int total; // 库存总量
  private int used;  // 库存已用

}
