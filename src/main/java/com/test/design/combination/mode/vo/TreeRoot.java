package com.test.design.combination.mode.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-02-18 22:27
 * @description: 树根信息
 **/
@Getter
@Setter
public class TreeRoot {
  //规则树ID
  private Long treeId;
  //规则树根ID
  private Long treeRootNodeId;
  //规则树名称
  private String treeName;

}
