package com.test.design.combination.mode.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-18 22:24
 * @description: 规则树线信息-组合模式
 **/
@Setter
@Getter
public class TreeNodeLink {
  //节点From
  private Long nodeIdFrom;
  //节点To
  private Long nodeIdTo;
  //限定类型；1:=;2:>;3:<;4:>=;5<=;6:enum[枚举范围]
  private Integer ruleLimitType;
  //限定值
  private String ruleLimitValue;


}
